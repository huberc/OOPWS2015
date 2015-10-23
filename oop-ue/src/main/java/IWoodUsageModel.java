/**
 * Definition of a usage model (e.g. wood used for energy, public space,
 * tourism, etc.) The <code>IWoodUsageModel</code> defines a
 * <code>WoodUsageAction</code> based on input parameters supplied by the
 * simulation environment. The <code>WoodUsageAction</code> is the action that
 * is best suited to serve the purpose of the wood - e.g. if the forest should
 * be public recovery space, cut trees before they grow too dense
 * 
 * @author michael
 *
 */
public interface IWoodUsageModel {

	/**
	 * Calculates the action to perform on the forest
	 * 
	 * @param numTrees
	 *            the number of trees in the forest
	 * @param avgSpacePerTree
	 *            the space each tree uses (and/or shadows) in square meters
	 * @param avgGroundShadowing
	 *            the percentage of forest floor that is shadowed by trees (i.e
	 *            cannot be reached by the sun)
	 * @return a <code>WoodUsageAction</code> calculated based on above params
	 */
	WoodUsageAction calcAction(int numTrees, double avgSpacePerTree,
			double avgGroundShadowing);

}
