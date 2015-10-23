/**
 * Description of an action to perform on a <code>Wood</code>
 * 
 * @author michael
 *
 */
public class WoodUsageAction {

	/**
	 * The type of action to perform
	 */
	private ActionType type;

	/**
	 * The number of trees to perform the action on.
	 */
	private int numTreesToActOn;

	/**
	 * Creates a new <code>WoodUsageAction</code>
	 * 
	 * @param type
	 *            the action type
	 * @param numTrees
	 *            the affected trees
	 */
	public WoodUsageAction(ActionType type, int numTrees) {
		this.type = type;
		this.numTreesToActOn = numTrees;
	}

	public ActionType getType() {
		return type;
	}

	public int getNumTreesToActOn() {
		return numTreesToActOn;
	}

	/**
	 * Definition of possible action types to perform on a <code>Wood</code>
	 * 
	 * @author michael
	 *
	 */
	public enum ActionType {
		CUT_TREES, PLANT_TREES;
	}
}
