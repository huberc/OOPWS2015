import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * dummy implementation - cut 1 tree per year
 * @author michael
 *
 */
public class DummyWoodUsageModel implements IWoodUsageModel{

	@Override
	public List<WoodUsageAction> calcAction(final Map<Class<? extends AbstractTree>, Integer> currentTrees,
			double avgSpacePerTree, double avgGroundShadowing) {
		List<WoodUsageAction> retVal = new ArrayList<>();
		retVal.add(new WoodUsageAction(WoodUsageAction.ActionType.CUT_TREES, 1, null));
		return retVal;
	}

}
