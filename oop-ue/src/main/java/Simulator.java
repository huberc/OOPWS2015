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

				rec.setTotalLivingWood(req.getStartLivingWood());
				totalLivingWoodpast = req.getStartLivingWood();

				rec.setTotalDeadWood(req.getStartDeadWood());
				totalDeadWoodpast = req.getStartDeadWood();

				rec.setTotalHarvestedWood(0);

				rec.setTotalProcessedWood(0);
				totalProcessedWoodpast = 0;

				rec.setTotalBoundCO2(req.getStartLivingWood() + req.getStartDeadWood());
			}
			else{

				//due to the results of the models the specific forest methode have to be called
				// TODO zuerst action auf den wald oder zuerst wachsen ?
				// A: Erst wachsen würd ich sagen
				forest.grow(req.getWeatherModel().calcWeatherForYear(i));

				List<WoodUsageAction> woodUsageActionList = req.getWoodUsageModel().calcAction(forest.getNumberOfTreesByType(), forest.getForestSize(), forest.getPercentGroundShadowed());

				for (int j = 0; i < woodUsageActionList.size(); j++) {
					if(woodUsageActionList.get(j).getType().compareTo(WoodUsageAction.ActionType.CUT_TREES) == 0){
						rec.setTotalHarvestedWood(forest.harvestTrees(woodUsageActionList.get(j).getNumTreesToActOn(), woodUsageActionList.get(j).getTreeTypeToActOn()));
					}
					else{
						forest.plantTrees(woodUsageActionList.get(j).getNumTreesToActOn(),woodUsageActionList.get(j).getTreeTypeToActOn());
					}
				}

				// BUGFIX - living wood must also be reduced by dead wood (-> dead wood doesn't just grow)
				//rec.setTotalLivingWood(totalLivingWoodpast + req.getAvgWoodGrowth() - req.getAvgHarvestYearly());
				// TODO what to do with startliving and startdeadwood ?
				// in jahr null aus dem forest holen, in Jahr 0 keine Aktionen, also kein grow oder cut machen
				rec.setTotalLivingWood(forest.getTotalLivingWood());

				// BUGFIX - deadwood should only start rotting after 1 year
				rec.setTotalDeadWood(forest.getTotalDeadWood());

				// BUGFIX - need to consider previously harvested wood
				//rec.setTotalHarvestedWood(req.getAvgHarvestYearly() * (1-req.getAvgProcessedWoodYearly()));
				// harvesting according to the result of the models
				//rec.setTotalHarvestedWood(totalHarvestedWoodpast + req.getAvgHarvestYearly() * (1-req.getAvgProcessedWoodYearly()));

				rec.setTotalProcessedWood(totalProcessedWoodpast + (rec.getTotalHarvestedWood()*req.getAvgProcessedWoodYearly()));
				totalProcessedWoodpast = totalProcessedWoodpast + (rec.getTotalHarvestedWood()*req.getAvgProcessedWoodYearly());

				rec.setTotalBoundCO2(forest.getTotalLivingWood()+forest.getTotalDeadWood()+rec.getTotalHarvestedWood());

				rec.setProfitMade(req.getEconomicModel().calcGuV(req.getVariableCosts(),rec.getTotalHarvestedWood(),req.getFixCosts()));
			}

			retVal.addSimulationRecordForYear(rec,i);
		}

		return retVal;
	}
}
