import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <code>IWoodUsageModel</code> aimed at creating a light-flooded forest of
 * medium density. Trees are cut when the ground shadowing precentage reaches a
 * treshold value, the number of trees kept constant based on the tree count on
 * first invocation of the model. When trees are cut, the model tries to cut
 * distribute the cut count as evenly as possible across all tree types in the
 * forest. Note: The model only uses tree types already in the forest - i.e.
 * using it on a monoculture won't diversify the forest
 * 
 * @author michael
 *
 */
public class RecoveryWoodUsageModel implements IWoodUsageModel {

	private double groundShadowedTreshold;
	private int targetTreeCount = -1;

	/**
	 * Creates a new <code>RecoveryWoodUsageModel</code>
	 * 
	 * @param shadowTreshold
	 *            the treshold value (in percent of the forest ground floor)
	 *            over which trees are cut. must be a positive value between 0
	 *            and 1
	 */
	public RecoveryWoodUsageModel(double shadowTreshold) {
		this.groundShadowedTreshold = shadowTreshold;
	}

	/**
	 * @see IWoodUsageModel#calcAction(java.util.Map, double, double)
	 */
	@Override
	public List<WoodUsageAction> calcAction(
			Map<Class<? extends AbstractTree>, Integer> currentTrees,
			double avgSpacePerTree, double avgGroundShadowing) {
		int totalTrees = 0;
		for (Entry<Class<? extends AbstractTree>, Integer> entry : currentTrees
				.entrySet()) {
			totalTrees += entry.getValue();
		}
		if (this.targetTreeCount == -1) {
			// NOTE: no tree count set yet
			this.targetTreeCount = totalTrees;
		}
		if (totalTrees > this.targetTreeCount) {
			// NOTE: too many trees, cut them and return
			return this.calcDistributedCuttingAction(totalTrees
					- this.targetTreeCount, false, currentTrees);
		} else if (totalTrees == this.targetTreeCount) {
			if (avgGroundShadowing > this.groundShadowedTreshold) {
				// NOTE: cut a few trees and replant them
				int treesToCut = (int) Math.round((double) totalTrees
						* (1 - this.groundShadowedTreshold));
				return this.calcDistributedCuttingAction(treesToCut, true,
						currentTrees);
			}
		}
		return new ArrayList<>();
	}

	@SuppressWarnings("unchecked")
	private List<WoodUsageAction> calcDistributedCuttingAction(int numTrees,
			boolean replant,
			Map<Class<? extends AbstractTree>, Integer> currentTrees) {
		@SuppressWarnings("unchecked")
		Object[] entryArr = currentTrees.entrySet().toArray();
		List<WoodUsageAction> retVal = new ArrayList<>();
		int rand;
		for (int i = 0; i < numTrees; i++) {
			rand = (int) (Math.random() * entryArr.length);
			retVal.add(new WoodUsageAction(
					WoodUsageAction.ActionType.CUT_TREES,
					1,
					((Entry<Class<? extends AbstractTree>, Integer>) entryArr[rand])
							.getKey()));
			if (replant) {
				retVal.add(new WoodUsageAction(
						WoodUsageAction.ActionType.PLANT_TREES,
						1,
						((Entry<Class<? extends AbstractTree>, Integer>) entryArr[rand])
								.getKey()));
			}
		}
		return retVal;
	}

}
