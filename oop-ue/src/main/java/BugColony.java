import java.util.List;

public class BugColony implements Runnable {

    /**
     * The maximum number of steps a colony can make before the simulation ends.
     */
    public static final int MAX_STEPS = 32;

    /**
     * The field where the bug colony has settled
     */
    private ForestField     home;

    /**
     * Indicates if this colony is healthy, i.e. not infected by bacteria.
     */
    private boolean         healthy   = true;

    private int             steps     = 0;

    /**
     * Precondition: home is not null and lays in the forest
     * Postcondition: a BugColony has been created with a set home (infected if all 8 neighbours are healthy, otherwise healty)
     * @param home  ForestField where colony should be placed
     */
    public BugColony(ForestField home) {
        this.home = home;
        if (this.home.getNumHealthyNeighbors() == 8) {
            this.healthy = false;
        }
    }

    /**
     * Precondition: home is not null and lays in the forest, origin is not null
     * Postcondition: a BugColony has been created with a set home and the steps of the origin colony
     * @param home  ForestField where colony should be placed
     * @param origin original BugColony which param should be taken
     */
    public BugColony(ForestField home, BugColony origin) {
        this(home);
        this.steps = origin.steps;
    }

    /**
     * Precondition: Forest, Forestfield and BugColony have been initialized
     * Postcondition: the behaviour of this BugColony has been simulated
     */
    public void run() {
        while (this.steps < BugColony.MAX_STEPS) {
            try {
                System.out.println("Colony waiting..");
                Thread.sleep((long) BugColony.calcWaitMsecs());
            } catch (InterruptedException ex) {
                System.err.println("Thread interrupted...");
            }
            // create new colony on neighbor field if possible
            System.out.println("Starting to do stuff...");
            if (this.healthy && this.home.checkNeighborhoodFree()) {
                List<ForestField> fields = this.home.getFreeNeighbors();
                try {
                    ForestField settlingTarget = fields.get((int) (Math.random() * fields.size()));
                    boolean replicated = false;
                    System.out.println("Colony replicating...");
                    synchronized (settlingTarget) {
                        // check again if the settling target is free, 
                        // another thread could try to settle on the same target!
                        if (settlingTarget.getColony() == null) {
                            BugColony newCol = new BugColony(settlingTarget, this);
                            settlingTarget.setColony(newCol);
                            new Thread(newCol).start();
                            replicated = true;
                        }
                        // if another thread did settle in the meantime, just don't do anything
                    }
                    if (replicated) {
                        Forest forest = Forest.getInstance();
                        synchronized (forest) {
                            System.out.println(forest.toString());
                        }
                    }
                } catch (IndexOutOfBoundsException ex) {
                    // cannot settle because another thread was faster
                    // TODO maybe print some warning...
                }
            }
            // if an infected colony has 2 infected neighbors infect them, die afterwards
            if (!this.healthy) {
                System.out.println("Infected colony infecting...");
                List<ForestField> healthyNeighbors = this.home.getHealthyNeighbors();
                if (healthyNeighbors.size() >= 2) {
                    for (int i = 0; i < 2; i++) {
                        // no synchronization needed here -
                        // a colony cannot be healed, and it being infected multpile times by multiple
                        // threads doesn't change the result
                        healthyNeighbors.get(i).getColony().setHealthy(false);
                    }
                }
                // let the colony die - detach it from forest field
                System.out.println("Infected colony dying...");
                synchronized (this.home) {
                    this.home.setColony(null);
                    break;
                }
            }
            this.steps++;
        }
        System.out.println("Colony reached max, stopping");
        Forest.getInstance().stopSimulation();
    }

    public boolean isHealthy() {
        return healthy;
    }

    // only used for testing
    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    public int getSteps() {
        return steps;
    }

    //only used for testing
    public void setSteps(int setps) {
        this.steps = setps;
    }

    /**
     * Helper method to calculate a random time (between 5 and 50 msec) a colony waits between steps. NOTE:
     * Not used externally, but made public so it can be accessed by Test
     * 
     * Preconditions: None Postconditions: int value between 5 and 50 returned
     * 
     * @return a random int value between 5 and 50
     */
    public static final int calcWaitMsecs() {
        return 5 + (int) (Math.random() * 46);
    }

	public String toString(){
		return "Steps taken: "+steps;
	}
}
