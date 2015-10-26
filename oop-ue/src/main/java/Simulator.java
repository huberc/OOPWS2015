import java.util.List;

/**
 *
 *
 * @author Christoph
 *
 */


public class Simulator {

	/**
	 * Executes a simulation run based on a given <code>SimulationRequest</code>
	 * for a given number of years.
	 * 
	 * @param req
	 *            the request holding all simulation input params
	 * @param years
	 *            the number of years to simulate
	 * @return a <code>SimulationResult</code> describing the state of the wood
	 *         after <code>years</code> years
	 */
	public SimulationResult simulate(SimulationRequest req, int years) {

		double totalLivingWoodpast = 0;
		double totalDeadWoodpast = 0;
		double totalHarvestedWoodpast = 0;
		double totalProcessedWoodpast = 0;
		Forest forest = req.getForest();

		SimulationResult retVal = new SimulationResult(years);
		SimulationResult.SimulationRecord rec;

		for(int i=0;i<=years;i++){

			 rec = retVal.new SimulationRecord();

			// Intials values saved for displaying it.
			if(i==0){
				rec.setTotalLivingWood(forest.getTotalLivingWood());

				rec.setTotalDeadWood(forest.getTotalDeadWood());

				rec.setTotalHarvestedWood(0.0);
				rec.setTotalProcessedWood(0.0);

				rec.setTotalBoundCO2(forest.getTotalLivingWood()+forest.getTotalDeadWood());
			}
			else{

				//due to the results of the models the specific forest methode have to be called
				forest.grow(req.getWeatherModel().calcWeatherForYear(i));

				List<WoodUsageAction> woodUsageActionList = req.getWoodUsageModel().calcAction(forest.getNumberOfTreesByType(), forest.getForestSize(), forest.getPercentGroundShadowed());

				for (int j = 0; i < woodUsageActionList.size(); j++) {
					if(woodUsageActionList.get(j).getType().compareTo(WoodUsageAction.ActionType.CUT_TREES) == 0){
						rec.setTotalHarvestedWood(forest.harvestTrees(woodUsageActionList.get(j).getNumTreesToActOn(), woodUsageActionList.get(j).getTreeTypeToActOn()));
					}
					else{
						forest.plantTrees(woodUsageActionList.get(j).getNumTreesToActOn(),woodUsageActionList.get(j).getTreeTypeToActOn());
						rec.setTotalHarvestedWood(0.0);
					}
				}

				rec.setTotalLivingWood(forest.getTotalLivingWood());

				rec.setTotalDeadWood(forest.getTotalDeadWood());

				rec.setTotalProcessedWood(totalProcessedWoodpast + (rec.getTotalHarvestedWood()*req.getAvgProcessedWoodYearly()));
				totalProcessedWoodpast = totalProcessedWoodpast + (rec.getTotalHarvestedWood()*req.getAvgProcessedWoodYearly());

				rec.setTotalBoundCO2(forest.getTotalLivingWood()+forest.getTotalDeadWood()+rec.getTotalHarvestedWood());

				rec.setProfitMade(req.getEconomicModel().calcGuV(req.getVariableCosts(),rec.getTotalHarvestedWood(),req.getFixCosts()));

				rec.setTreesByType(forest.getNumberOfTreesByType());
			}

			retVal.addSimulationRecordForYear(rec,i);
		}

		return retVal;
	}
}
