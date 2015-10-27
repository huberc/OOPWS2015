import java.util.List;
import java.util.Map;

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
	 * Calculates the action(s) to perform on the forest
	 * 
	 * @param currentTrees
	 *            the number of living trees currently in the forest by type
	 * @param avgSpacePerTree
	 *            the space each tree uses (and/or shadows) in square meters
	 * @param avgGroundShadowing
	 *            the percentage of forest floor that is shadowed by trees (i.e
	 *            cannot be reached by the sun)
	 * @return a list of <code>WoodUsageAction</code>s calculated based on above
	 *         params
	 */
	List<WoodUsageAction> calcAction(
			final Map<Class<? extends AbstractTree>, Integer> currentTrees,
			double avgSpacePerTree, double avgGroundShadowing);

}
