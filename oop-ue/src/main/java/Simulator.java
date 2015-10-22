

public abstract class Simulator {

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
	public abstract SimulationResult simulate(SimulationRequest req, int years) {

		double totalLivingWoodpast = 0;
		double totalDeadWoodpast = 0;
		double totalHarvestedWoodpast = 0;
		double totalProcessedWoodpast = 0;

		SimulationResult retVal = new SimulationResult(years);
		SimulationResult.SimulationRecord rec;

		for(int i=0;i<=years;i++){

			 rec = retVal.new SimulationRecord();

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
				// BUGFIX - living wood must also be reduced by dead wood (-> dead wood doesn't just grow)
				//rec.setTotalLivingWood(totalLivingWoodpast + req.getAvgWoodGrowth() - req.getAvgHarvestYearly());
				rec.setTotalLivingWood(totalLivingWoodpast + req.getAvgWoodGrowth() - req.getAvgHarvestYearly() - req.getAvgDeadWoodYearly());
				totalLivingWoodpast = totalLivingWoodpast + req.getAvgWoodGrowth() - req.getAvgHarvestYearly() - req.getAvgDeadWoodYearly();

				// BUGFIX - deadwood should only start rotting after 1 year
				rec.setTotalDeadWood((totalDeadWoodpast * (1-req.getAvgDecompWoodYearly()) + req.getAvgDeadWoodYearly()));
				totalDeadWoodpast = (totalDeadWoodpast  * (1-req.getAvgDecompWoodYearly()) + req.getAvgDeadWoodYearly());

				// BUGFIX - need to consider previously harvested wood
				//rec.setTotalHarvestedWood(req.getAvgHarvestYearly() * (1-req.getAvgProcessedWoodYearly()));
				rec.setTotalHarvestedWood(totalHarvestedWoodpast + req.getAvgHarvestYearly() * (1-req.getAvgProcessedWoodYearly()));
				totalHarvestedWoodpast = totalHarvestedWoodpast + req.getAvgHarvestYearly() * (1-req.getAvgProcessedWoodYearly());

				rec.setTotalProcessedWood(totalProcessedWoodpast + (req.getAvgHarvestYearly()*req.getAvgProcessedWoodYearly()));
				totalProcessedWoodpast = totalProcessedWoodpast + (req.getAvgHarvestYearly()*req.getAvgProcessedWoodYearly());

				rec.setTotalBoundCO2(totalLivingWoodpast + totalDeadWoodpast + totalHarvestedWoodpast);
			}

			retVal.addSimulationRecordForYear(rec,i);
		}

		return retVal;
	}
}
