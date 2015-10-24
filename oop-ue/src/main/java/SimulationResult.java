import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This class describes the result of a simulation. The state of the environment
 * is stored in a snapshot for each simulated year, i.e. the result has one
 * <code>SimulatedRecord</code> for each year, including year zero, i.e. the
 * initial state
 * 
 * @author Michael Langowski, e1426581student.tuwien.ac.at
 *
 */
public class SimulationResult {

	/**
	 * internal storage for yearly snapshots.
	 */
	private SimulationRecord[] dataPerYears;

	private int yearsSimulated;

	/**
	 * Creates a new <code>SimulationResult</code> with a pre-initialized
	 * storage for <code>yearsSimulated + 1</code> years where the general
	 * contract is that the "0-th" record holds the initial state.
	 * 
	 * @param yearsSimulated
	 *            the number of years simulated
	 */
	public SimulationResult(int yearsSimulated) {
		this.yearsSimulated = yearsSimulated;
		this.dataPerYears = new SimulationRecord[yearsSimulated + 1];
	}

	/**
	 * Adds a new simulation record (i.e. environment snapshot after the
	 * <code>year</code>-th year) to this <code>SimulationResult</code>
	 * 
	 * @param rec
	 *            the <code>SimulationRecord</code> to add
	 * @param year
	 *            the number of years elapsed in the simulation (where 0 would
	 *            mean the initial state)
	 */
	public void addSimulationRecordForYear(SimulationRecord rec, int year) {
		this.dataPerYears[year] = rec;
	}

	/**
	 * Retrieves the <code>SimulationRecord</code> representing the environment
	 * state after <code>year</code> years.
	 * 
	 * @param year
	 *            the year in the simulation scenario that should be retrieved
	 * @return the <code>SimulationRecord</code> representing the environment
	 *         state after <code>year</code>
	 */
	public SimulationRecord getRecordForYear(int year) {
		return this.dataPerYears[year];
	}

	public int getYearsSimulated() {
		return yearsSimulated;
	}

	/**
	 * A <code>SimulationRecord</code> represents the state of the simulated
	 * environment at a specific point in time.
	 * 
	 * @author Michael Langowski, e142658@student.tuwien.ac.at
	 *
	 */
	public class SimulationRecord {

		/**
		 * A map of tree counts by type (e.g. Oak=3; Maple=5, ...)
		 */
		private Map<Class<? extends Tree>, Integer> treesByType = new HashMap<>();
		
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
		 * understanding not done here in order to centralize all calculations.
		 */
		private double totalBoundCO2;
		
		/**
		 * The money that was made from selling wood.
		 */
		private double profitMade;

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

		public Map<Class<? extends Tree>, Integer> getTreesByType() {
			return treesByType;
		}

		public void setTreesByType(Map<Class<? extends Tree>, Integer> treesByType) {
			this.treesByType = treesByType;
		}
		
		public double getProfitMade() {
			return profitMade;
		}

		public void setProfitMade(double profitMade) {
			this.profitMade = profitMade;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("SimulationRecord [treesByType=");
			builder.append(treesByType);
			builder.append(", totalLivingWood=");
			builder.append(totalLivingWood);
			builder.append(", totalDeadWood=");
			builder.append(totalDeadWood);
			builder.append(", totalHarvestedWood=");
			builder.append(totalHarvestedWood);
			builder.append(", totalProcessedWood=");
			builder.append(totalProcessedWood);
			builder.append(", totalBoundCO2=");
			builder.append(totalBoundCO2);
			builder.append(", profitMade=");
			builder.append(profitMade);
			builder.append("]\n");
			return builder.toString();
		}
		

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SimulationResult [dataPerYears=\n");
		builder.append(Arrays.toString(dataPerYears));
		builder.append(", yearsSimulated=");
		builder.append(yearsSimulated);
		builder.append("]");
		return builder.toString();
	}

}
