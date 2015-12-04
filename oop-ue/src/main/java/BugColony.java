
public class BugColony implements Runnable{

	/**
	 * The field where the bug colony has settled
	 */
	private ForestField home;
	
	public BugColony(ForestField home){
		this.home = home;
	}
	
	public BugColony(ForestField home, BugColony origin){
		this(home);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
