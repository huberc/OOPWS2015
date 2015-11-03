import java.util.List;

/**
 *
 * GOOD: Replacability: All weather-, wood usage-, and economic models are
 * encapsulated through the used interfaces, <code>Simulator</code> does not
 * have to deal with internal workings of any specific model
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
	 *            the request holding all simulation input params BAD: actions
	 *            are performed on the forest, without taking a further copy to
	 *            ensure the statelessness of the Request
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

		for (int i = 0; i <= years; i++) {

			rec = retVal.new SimulationRecord();

			if (i == 0) {

				/**
				 * Set the total amount of living wood in the record for one
				 * year Get current amount of living wood from the client
				 * (forest) the
				 */
				rec.setTotalLivingWood(forest.getTotalLivingWood());
				totalLivingWoodpast = forest.getTotalLivingWood();

				/**
				 * Set the total amount of dead wood in the forest in the
				 * simulation record for one year Get the current amount of dead
				 * wood from the client (forest)
				 */
				rec.setTotalDeadWood(forest.getTotalDeadWood());
				totalDeadWoodpast = forest.getTotalDeadWood();

				/**
				 * At the initial state of the simulation cant be a already
				 * harvested wood
				 */
				rec.setTotalHarvestedWood(0.0);
				totalHarvestedWoodpast = 0.0;

				/**
				 * At the initial state of the simulation cant be a already
				 * processed wood
				 */
				rec.setTotalProcessedWood(0.0);
				totalProcessedWoodpast = 0.0;

				/**
				 * Set the total bound CO2 in the record for one year Get the
				 * current amount of living and dead wood from the forest
				 */
				rec.setTotalBoundCO2(forest.getTotalLivingWood()
						+ forest.getTotalDeadWood());
				rec.setLivingTreesByType(forest
						.getNumberOfTreesByType(AbstractTree.TreeState.LIVING));
				rec.setDeadTreesByType(forest
						.getNumberOfTreesByType(AbstractTree.TreeState.DEAD));

				rec.setWeather(req.getWeatherModel().calcWeatherForYear(i));
			} else {

				// NOTE: due to the results of the models the specific forest
				// methode
				// have to be called
				rec.setWeather(req.getWeatherModel().calcWeatherForYear(i));
				forest.grow(req.getWeatherModel().calcWeatherForYear(i));

				List<WoodUsageAction> woodUsageActionList = req
						.getWoodUsageModel()
						.calcAction(
								forest.getNumberOfTreesByType(AbstractTree.TreeState.LIVING),
								forest.getForestSize(),
								forest.getPercentGroundShadowed());

				rec.setWoodActions(woodUsageActionList);

				double harvestedWood = 0.0;
				for (WoodUsageAction action : woodUsageActionList) {

					/**
					 * BAD: minor issues: the logic which action should be
					 * performed should better be in the forest
					 */
					if (action.getType() == WoodUsageAction.ActionType.CUT_TREES) {
						harvestedWood += forest.harvestTrees(
								action.getNumTreesToActOn(),
								action.getTreeTypeToActOn());
					} else {
						forest.plantTrees(action.getNumTreesToActOn(),
								action.getTreeTypeToActOn());
					}
				}
				rec.setTotalHarvestedWood(totalHarvestedWoodpast
						+ harvestedWood);
				totalHarvestedWoodpast += harvestedWood;

				rec.setTotalLivingWood(totalLivingWoodpast
						+ forest.getTotalLivingWood());
				totalLivingWoodpast = totalLivingWoodpast
						+ forest.getTotalLivingWood();

				rec.setTotalDeadWood(forest.getTotalDeadWood());
				totalDeadWoodpast = totalDeadWoodpast
						+ forest.getTotalDeadWood();

				rec.setTotalProcessedWood(totalProcessedWoodpast
						+ (rec.getTotalHarvestedWood() * req
								.getAvgProcessedWoodYearly()));
				totalProcessedWoodpast = totalProcessedWoodpast
						+ (rec.getTotalHarvestedWood() * req
								.getAvgProcessedWoodYearly());

				rec.setTotalBoundCO2(rec.getTotalLivingWood()
						+ rec.getTotalDeadWood() + rec.getTotalHarvestedWood());

				rec.setProfitMade(req.getEconomicModel()
						.calcProfit(
								req.getEconomicModel().calcCosts(
										req.getVariableCosts(),
										rec.getTotalHarvestedWood(),
										req.getFixCosts()),
								req.getEconomicModel().calcProfitPerMeter(
										rec.getTotalHarvestedWood(),
										req.getPricePerMeter())));

				rec.setLivingTreesByType(forest
						.getNumberOfTreesByType(AbstractTree.TreeState.LIVING));
				rec.setDeadTreesByType(forest
						.getNumberOfTreesByType(AbstractTree.TreeState.DEAD));
			}

			retVal.addSimulationRecordForYear(rec, i);
		}

		return retVal;
	}
}
