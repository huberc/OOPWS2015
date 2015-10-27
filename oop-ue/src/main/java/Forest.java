import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 
 * @author Ines
 *
 */
public class Forest implements Cloneable {

    private List<AbstractTree> blackAlderList;
    private List<AbstractTree> spruceList;
    private Map<Class<? extends AbstractTree>, List<AbstractTree>> trees;
    private double sizeSqMeters;
    private Integer numTrees;

    public Forest(double sizeSqMeters, Map<Class<? extends AbstractTree>, Integer> trees) {
        this.sizeSqMeters = sizeSqMeters;
        //this.trees = trees;

        this.numTrees = numTrees;
    }

	// @Ines - Eventuell hier statt der Liste eine Map verwenden (nachdem ja
	// harvest und plant types verwenden), zB:
	// Map<Class<? extends AbstractTree>, List<? extends AbstractTree>> trees;

	/**
	 * The size of the forest (in square meters)
	 */
	private double forestSize;

	/**
	 * The percentage of space on the forest floor that is shadowed by trees.
	 * Assumption for shadowing is the exact mid of day at equatorial latitude,
	 * i.e. the sun comes from directly above and the space shadowed by an
	 * individual tree is exactly it's <code>spaceUsed</code> property.
	 */
	private double percentGroundShadowed;

    private int amountTrees() {
        int counter = 0;
        Set<Entry<Class<? extends AbstractTree>, List<AbstractTree>>> mySet = trees.entrySet();
        List<AbstractTree> temp = null;
        for (Entry<Class<? extends AbstractTree>, List<AbstractTree>> t : mySet) {
            counter += temp.size();
        }
        return counter;
    }

	/**
	 * Lets the wood grow.
	 * 
	 * @param weather
	 *            the <code>WeatherConditions</code> of the current simulation
	 *            year
	 */
	public void grow(WeatherConditions weather) {
        Set<Entry<Class<? extends AbstractTree>, List<AbstractTree>>> mySet = trees.entrySet();
        List<AbstractTree> temp;
        double availableSpace = sizeSqMeters *(1-percentGroundShadowed);
        for (Entry<Class<? extends AbstractTree>, List<AbstractTree>> t : mySet) {
            temp = t.getValue();
            for (AbstractTree i : temp) {
                i.grow(weather, availableSpace);
            }
        }
        setForestSize();
    }

	/**
	 * Harvests trees from the forest.
	 * 
	 * @param numTrees
	 *            the number of trees to harvest
	 * @param preferredType
	 *            the preferred type to harvest. If no (or not enough trees of
	 *            the specified type exist), any tree can be harvested
	 * @return the amount of wood harvested (that can be actually used, i.e. not
	 *         including wood that remains as dead wood in the forest)
	 */
	public double harvestTrees(int numTrees,
			Class<? extends AbstractTree> preferredType) {

        double amount = 0;
        for(AbstractTree t : trees.get(preferredType)) {
            amount += t.harvest();
        }
        setForestSize();
		return amount;
	}

	/**
	 * Destroys trees (e.g. as a result of a thunderstorm etc)
	 * 
	 * @param numTrees
	 *            the number of trees to destroy
	 */
	public void destroyTrees(int numTrees) {
		// TODO
		// to be called when trees are destroyed, e.g. by lightning strikes

        setForestSize();
	}

	/**
	 * Plants new trees in the forest
	 * 
	 * @param numTrees
	 *            the number of trees to plant
	 * @param type
	 *            the type of trees to plant
	 */
	public void plantTrees(int numTrees, Class<? extends AbstractTree> type) {
		// TODO
        // @Ines: Basierend auf einer Class Bäume dieses Types erzeugen geht wie
        // folgt:
        //AbstractTree t = type.getDeclaredConstructor(null).newInstance(null);
        // siehe auch java API
        // https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html


        setForestSize();

	}

	/**
	 * Calculates the total amount of living wood (in cubic meters) in the
	 * forest
	 * 
	 * @return the added-up <code>wood</code> properties of all living trees
	 */
	public double getTotalLivingWood() {
        Set<Entry<Class<? extends AbstractTree>, List<AbstractTree>>> mySet = trees.entrySet();
        List<AbstractTree> temp;
        double counter = 0;
        for (Entry<Class<? extends AbstractTree>, List<AbstractTree>> t : mySet) {
            temp = t.getValue();
            for (AbstractTree i : temp) {
                if (i.getState() == AbstractTree.TreeState.LIVING) {
                    counter += i.getWood();
                }
            }
        }
		return counter;
	}

	/**
	 * Calculates the total amount of dead wood in the forest
	 * 
	 * @return the added-up <code>wood</code> properties of all dead trees
	 */
	public double getTotalDeadWood() {
        Set<Entry<Class<? extends AbstractTree>, List<AbstractTree>>> mySet = trees.entrySet();
        List<AbstractTree> temp;
        double counter = 0;
        for (Entry<Class<? extends AbstractTree>, List<AbstractTree>> t : mySet) {
            temp = t.getValue();
            for (AbstractTree i : temp) {
                if (i.getState() == AbstractTree.TreeState.DEAD) {
                    counter += i.getWood();
                }
            }
        }
        return counter;
	}

	/**
	 * Performs a deep copy of this <code>Forest</code>
	 */
	@Override
	public Forest clone() {
		// @Ines - hier musst nix machen, die brauch ich für den Test, schreib
		// ich mir dann selber
		return null;
	}

	/**
	 * Gets the number of living trees (by tree type) currently in the forest
	 * 
	 * @return the number of living trees (by tree type) currently in the forest
	 */
	public Map<Class<? extends AbstractTree>, Integer> getNumberOfTreesByType() {
        Set<Entry<Class<? extends AbstractTree>, List<AbstractTree>>> mySet = trees.entrySet();
        List<AbstractTree> temp;
        Map<Class<? extends AbstractTree>, Integer> result;
        for (Entry<Class<? extends AbstractTree>, List<AbstractTree>> t : mySet) {
            result.put(temp ,temp.size());
        }
		return result;
	}

	public double getForestSize() {
		return forestSize;
	}

    private double setForestSize() {
        Set<Entry<Class<? extends AbstractTree>, List<AbstractTree>>> mySet = trees.entrySet();
        List<AbstractTree> temp;
        double counter = 0;
        for (Entry<Class<? extends AbstractTree>, List<AbstractTree>> t : mySet) {
            temp = t.getValue();
            for (AbstractTree i : temp) {
                if (i.getState() == AbstractTree.TreeState.DEAD) {
                    counter += i.getUsedSpace();
                }
            }
        }
        setPercentGroundShadowed();
        return counter;
    }

	public double getPercentGroundShadowed() {
		return percentGroundShadowed;
	}

    private double setPercentGroundShadowed() {
        return (forestSize*100/sizeSqMeters);
    }
}
