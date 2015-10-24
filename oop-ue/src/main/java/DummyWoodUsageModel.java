/**
 * 
 * dummy implementation - cut 1 tree per year
 * @author michael
 *
 */
public class DummyWoodUsageModel implements IWoodUsageModel{

	@Override
	public WoodUsageAction calcAction(int numTrees, double avgSpacePerTree,
			double avgGroundShadowing) {
		return new WoodUsageAction(WoodUsageAction.ActionType.CUT_TREES, 1);
	}

}
