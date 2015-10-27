/**
 * Description of an action to perform on a <code>Wood</code>
 * 
 * @author michael
 *
 */
public class WoodUsageAction {

	/**
	 * Definition of possible action types to perform on a <code>Wood</code>
	 * 
	 * @author michael
	 *
	 */
	public enum ActionType {
		CUT_TREES("geerntet"), PLANT_TREES("gepflanzt");

		private String humanReadableName;

		private ActionType(String name) {
			this.humanReadableName = name;
		}

		public String getHumanReadableName() {
			return this.humanReadableName;
		}
	}

	/**
	 * The type of action to perform
	 */
	private ActionType type;

	/**
	 * The number of trees to perform the action on.
	 */
	private int numTreesToActOn;

	/**
	 * The kind of trees to cut or plant. Depends on the purpose of the wood.
	 */
	private Class<? extends AbstractTree> treeTypeToActOn;

	/**
	 * Creates a new <code>WoodUsageAction</code>
	 * 
	 * @param type
	 *            the action type
	 * @param numTrees
	 *            the affected trees
	 */
	public WoodUsageAction(ActionType type, int numTrees,
			Class<? extends AbstractTree> treeType) {
		this.type = type;
		this.numTreesToActOn = numTrees;
		this.treeTypeToActOn = treeType;
	}

	public ActionType getType() {
		return type;
	}

	public int getNumTreesToActOn() {
		return numTreesToActOn;
	}

	public Class<? extends AbstractTree> getTreeTypeToActOn() {
		return treeTypeToActOn;
	}
}
