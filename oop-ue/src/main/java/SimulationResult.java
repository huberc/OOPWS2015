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
		
        public String toString() {
            int livingWoodspace = 15;
            int deadWoodspace = 23;
            int harvestedWoodspace = 20;
            int processedWoodspace = 20;
            int boundCO2space = 20;

            String line = "";
            
            line += "|" + totalLivingWood;
            if(String.valueOf(totalLivingWood).length() < livingWoodspace) {
                for(int i = String.valueOf(totalLivingWood).length(); i < livingWoodspace; i++) {
                    line += " ";
                }
            }

            line += "|" + totalDeadWood;
            if(String.valueOf(totalDeadWood).length() < deadWoodspace) {
                for(int i = String.valueOf(totalDeadWood).length(); i < deadWoodspace; i++) {
                    line += " ";
                }
            }

            line += "|" + totalHarvestedWood;
            if(String.valueOf(totalHarvestedWood).length() < harvestedWoodspace) {
                for(int i = String.valueOf(totalHarvestedWood).length(); i < harvestedWoodspace; i++) {
                    line += " ";
                }
            }

            line += "|" + totalProcessedWood;
            if(String.valueOf(totalProcessedWood).length() < processedWoodspace) {
                for(int i = String.valueOf(totalProcessedWood).length(); i < processedWoodspace; i++) {
                    line += " ";
                }
            }

            line += "|" + totalBoundCO2;
            if(String.valueOf(totalBoundCO2).length() < boundCO2space) {
                for(int i = String.valueOf(totalBoundCO2).length(); i < boundCO2space; i++) {
                    line += " ";
                }
            }

            return line + "| \n";
		}

	}

	@Override
	public String toString() {
		int yearSpace = 6;
		
        String output;

        output = "\n" + "--------------------------------------------------------------------------------------------------------------- \n";
        output += "| Jahr | lebendes Holz | verbleibendes Totholz |   geerntets Holz   |  verwertetes Holz  |   gebundenes CO2   | \n";
        String line;
        for(int i = 0; i < this.dataPerYears.length; i++){
            line = "|" + i;
            for(int j = String.valueOf(i).length(); j < yearSpace; j++) {
                line += " ";
            }
            line += this.dataPerYears[i].toString();
            output += line;
        }
        output += "---------------------------------------------------------------------------------------------------------------";

        return output;
	}

}
