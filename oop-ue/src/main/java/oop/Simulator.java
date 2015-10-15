package oop;

import oop.SimulationResult.SimulationRecord;

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
		double totalBoundCO2past = 0;

		double startlivingWood = req.getStartLivingWood();
		double startDeadWood = req.getStartDeadWood();
		double avgHarvestYearly = req.getAvgHarvestYearly();
		double avgWoodGrowth = req.getAvgWoodGrowth();

		SimulationResult retVal = new SimulationResult(years);
		SimulationRecord rec = retVal.new SimulationRecord();

		for(int i=0;i<=years;i++){

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
				rec.setTotalLivingWood(totalLivingWoodpast + req.getAvgWoodGrowth() - req.getAvgHarvestYearly() - req.getAvgDeadWoodYearly());
				totalLivingWoodpast = totalLivingWoodpast + req.getAvgWoodGrowth() - req.getAvgHarvestYearly() - req.getAvgDeadWoodYearly();

				rec.setTotalDeadWood((totalDeadWoodpast + req.getAvgDeadWoodYearly()) *(1-req.getAvgDecompWoodYearly()));
				totalDeadWoodpast = (totalDeadWoodpast + req.getAvgDeadWoodYearly()) *(1-req.getAvgDecompWoodYearly());

				rec.setTotalHarvestedWood(req.getAvgHarvestYearly() * (1-req.getAvgProcessedWoodYearly()));
				totalHarvestedWoodpast = req.getAvgHarvestYearly() * (1-req.getAvgProcessedWoodYearly());

				rec.setTotalProcessedWood(totalProcessedWoodpast + (req.getAvgHarvestYearly()*req.getAvgProcessedWoodYearly()));
				totalProcessedWoodpast = totalProcessedWoodpast + (req.getAvgHarvestYearly()*req.getAvgProcessedWoodYearly());

				rec.setTotalBoundCO2(totalLivingWoodpast + totalDeadWoodpast + totalHarvestedWoodpast);
			}

			retVal.addSimulationRecordForYear(rec,i);
		}

		return retVal;
	}
}
