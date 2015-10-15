package oop;

public class SimulationResult {

	private SimulationRecord[] dataPerYears;

	/**
	 * Creates a new <code>SimulationResult</code>
	 * 
	 * @param yearsSimulated
	 */
	public SimulationResult(int yearsSimulated) {
		this.dataPerYears = new SimulationRecord[yearsSimulated];
	}

	public void addSimulationRecordForYear(SimulationRecord rec, int year) {

	}

	public class SimulationRecord {

		/**
		 * Formats the properties of this <code>SimulationResult</code> as an
		 * ASCII-Table suitable for printing to a console.
		 * 
		 * @return a <code>String</code> holding formatted table.
		 */
		public String createOutputTable() {

			String output;
			int livingWoodspace = 15;
			int deadWoodspace = 23;
			int harvestedWoodspace = 16;
			int processedWoddspace = 18;
			int boundCO2space = 16;

			output = "-----------------------------------------------------------------------------------------------------";
			output += "| Jahr | lebendes Holz | verbleibendes Totholz | geerntets Holz | verwertetes Holz | gebundenes CO2 |";
			output += "|  1   | 2,90908       | 0,89789               | 15,897234      | 18,7238409       | 2              |";
			output += "-----------------------------------------------------------------------------------------------------";
			return null;
		}

		/**
		 * Total amount of living wood in the wood.
		 */
		private double totalLivingWood;

		/**
		 * Total amount of deadwood.
		 */
		private double totalDeadWood;

		/**
		 * The total amount of already harvested (but not yet processed) wood.
		 */
		private double totalHarvestedWood;

		/**
		 * The total amount of already processed wood.
		 */
		private double totalProcessedWood;

		/**
		 * Total amount of carbon dioxide bound by the wood at the current point
		 * in time.
		 * 
		 * NOTE: Could be calculated in the <code>Result</code>, for ease of
		 * understanding not done here in order to cantralize all calculations.
		 */
		private double totalBoundCO2;

		public double getTotalLivingWood() {
			return totalLivingWood;
		}

		public void setTotalLivingWood(double totalLivingWood) {
			this.totalLivingWood = totalLivingWood;
		}

		public double getTotalDeadWood() {
			return totalDeadWood;
		}

		public void setTotalDeadWood(double totalDeadWood) {
			this.totalDeadWood = totalDeadWood;
		}

		public double getTotalHarvestedWood() {
			return totalHarvestedWood;
		}

		public void setTotalHarvestedWood(double totalHarvestedWood) {
			this.totalHarvestedWood = totalHarvestedWood;
		}

		public double getTotalProcessedWood() {
			return totalProcessedWood;
		}

		public void setTotalProcessedWood(double totalProcessedWood) {
			this.totalProcessedWood = totalProcessedWood;
		}

		public double getTotalBoundCO2() {
			return totalBoundCO2;
		}

		public void setTotalBoundCO2(double totalBoundCO2) {
			this.totalBoundCO2 = totalBoundCO2;
		}

	}

}
