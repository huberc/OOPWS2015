import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Implementation of <code>IWoodUsageModel</code> with the goal of maximizing
 * output of the <code>Forest</code> in terms of cubic meters of wood. This
 * means that pinewood is preferred over broadleaf trees in general. Trees of
 * undesired types are cut down and replaced with newly planted preferred ones
 * Trees are cut when a certain (high) percentage of ground is shadowed, i.e.
 * trees don´t have much space left to grow. If trees of preferred types are
 * cut, new ones are planted.
 * 
 * @author michael
 *
 */
public class EnergyWoodUsageModel implements IWoodUsageModel {

	private List<Class<? extends AbstractTree>> preferredTrees;
	private double groundShadowedTreshold;

	@SafeVarargs
	public EnergyWoodUsageModel(double shadowTreshold,
			Class<? extends AbstractTree>... clazzez) {
		this.preferredTrees = Arrays.asList(clazzez);
		this.groundShadowedTreshold = shadowTreshold;
	}

	@Override
	public List<WoodUsageAction> calcAction(
			Map<Class<? extends AbstractTree>, Integer> currentTrees,
			double avgSpacePerTree, double avgGroundShadowing) {
		Set<Class<? extends AbstractTree>> types = currentTrees.keySet();
		final List<WoodUsageAction> retVal = new ArrayList<>();
		for (Class<? extends AbstractTree> clazz : types) {
			if (!this.preferredTrees.contains(clazz)) {
				// "undesired" tree type - cut down
				retVal.add(new WoodUsageAction(
						WoodUsageAction.ActionType.CUT_TREES, currentTrees
								.get(clazz), clazz));
				retVal.add(new WoodUsageAction(
						WoodUsageAction.ActionType.PLANT_TREES, currentTrees
								.get(clazz), this.preferredTrees
								.get((int) (Math.random() * this.preferredTrees
										.size()))));
			}
		}
		if (avgGroundShadowing >= this.groundShadowedTreshold) {
			int totalTrees = 0;
			for (Entry<Class<? extends AbstractTree>, Integer> entry : currentTrees
					.entrySet()) {
				totalTrees += entry.getValue();
			}
			int treesToCut = (int) Math.round((double) totalTrees
					* (1 - this.groundShadowedTreshold));
			// starting with the first tree type in the preferred list,
			// cut trees until the total is reached
			int treesOfType;
			for (Class<? extends AbstractTree> clazz : this.preferredTrees) {
				treesOfType = currentTrees.get(clazz);
				if (treesOfType < treesToCut) {
					retVal.add(new WoodUsageAction(
							WoodUsageAction.ActionType.CUT_TREES, treesOfType,
							clazz));
					retVal.add(new WoodUsageAction(
							WoodUsageAction.ActionType.PLANT_TREES,
							treesOfType, clazz));
					treesToCut -= treesOfType;
				} else {
					retVal.add(new WoodUsageAction(
							WoodUsageAction.ActionType.CUT_TREES, treesToCut,
							clazz));
					retVal.add(new WoodUsageAction(
							WoodUsageAction.ActionType.PLANT_TREES, treesToCut,
							clazz));
					break;
				}
			}
		}
		return retVal;
	}

}
