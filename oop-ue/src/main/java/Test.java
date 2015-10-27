import java.util.HashMap;
import java.util.Map;

/**
 * Test class for the environment simulation.
 * 
 * TODO Who did what? Why did we do it?
 * 
 * @author Michael Langowski, e1426581@student.tuwien.ac.at
 *
 */
public class Test {

	private static final double CONSIDER_EQUAL_TRESHOLD = 0.0000001;

	private Simulator sim = new Simulator();

	public static void main(String[] args) {
		Test simulatorTest = new Test();
		System.out.println("TEST RUN OF WOODGROWTH SIMULATION:\n");
		System.out
				.println("1. Test result content with only initial state, no simulation done at all:");
		System.out.println("Test of initial state: "
				+ simulatorTest.testInitialState());
		simulatorTest.testEnergyWoodThreeDecades();

		/*
		 * System.out.println(
		 * "\n2. Test result content after a one-year simulation run:");
		 * System.out.println("Test of state after 1 year: " +
		 * simulatorTest.testOneYear()); System.out.println(
		 * "\n3. Test result content after a 4-year simulation run:");
		 * System.out.println("Test of state after 4 years: " +
		 * simulatorTest.testFourYears());*(
		 * 
		 * /* System.out.println(
		 * "-------------------------------------------------------");
		 * SimulationRequest req = new SimulationRequest();
		 * req.setStartDeadWood(0); req.setStartLivingWood(0);
		 * req.setAvgWoodGrowth(10); req.setAvgDeadWoodYearly(2);
		 * req.setAvgHarvestYearly(7); req.setAvgProcessedWoodYearly(0.8);
		 * req.setAvgDecompWoodYearly(0.2);
		 * 
		 * SimulationResult result = simulatorTest.sim.simulate(req, 20);
		 * System.out.println("Result after 20 years:\n" + result);
		 */

	}

	// simple "dummy-test" that just verifies if inital values are unchanged in
	// result
	public boolean testInitialState() {

		SimulationRequest req = new SimulationRequest();

		Map<Class<? extends AbstractTree>, Integer> trees = new HashMap<>();

		trees.put(Spruce.class, 10);
		trees.put(BlackAlder.class, 15);

		Forest forest = new Forest(100.0, trees);

		req.setAvgProcessedWoodYearly(0.5);
		req.setForest(forest);
		req.setFixCosts(10000);
		req.setVariableCosts(5);
		req.setPricePerMeter(10);
		req.setEconomicModel(new DummyEconomicModel());
		req.setWeatherModel(new DummyWeatherModel());
		req.setWoodUsageModel(new DummyWoodUsageModel());

		SimulationResult actual = this.sim.simulate(req, 0);

		// reference result
		SimulationResult expected = new SimulationResult(0);
		SimulationResult.SimulationRecord rec = expected.new SimulationRecord();
		rec.setTotalBoundCO2(0);
		rec.setTotalDeadWood(0);
		rec.setTotalHarvestedWood(0);
		rec.setTotalLivingWood(0);
		rec.setTotalProcessedWood(0);

		Map<Class<? extends AbstractTree>, Integer> treesByType = new HashMap<>();
		treesByType.put(Spruce.class, 10);
		treesByType.put(BlackAlder.class, 15);
		rec.setTreesByType(treesByType);
		expected.addSimulationRecordForYear(rec, 0);
		return Test.compareResults(actual, expected);
	}

	// basic test for one year simulation based on hardcoded values
	/*
	 * public boolean testOneYear() { SimulationRequest req = new
	 * SimulationRequest(); req.setStartDeadWood(10);
	 * req.setStartLivingWood(10); req.setAvgWoodGrowth(10);
	 * req.setAvgProcessedWoodYearly(0.5); req.setAvgHarvestYearly(10);
	 * req.setAvgDecompWoodYearly(0.2); req.setAvgDeadWoodYearly(2);
	 * SimulationResult actual = this.sim.simulate(req, 1);
	 * 
	 * // reference result SimulationResult expected = new SimulationResult(1);
	 * 
	 * SimulationResult.SimulationRecord rec = expected.new SimulationRecord();
	 * rec.setTotalBoundCO2(20); rec.setTotalDeadWood(10);
	 * rec.setTotalHarvestedWood(0); rec.setTotalLivingWood(10);
	 * rec.setTotalProcessedWood(0); expected.addSimulationRecordForYear(rec,
	 * 0);
	 * 
	 * SimulationResult.SimulationRecord rec1 = expected.new SimulationRecord();
	 * rec1.setTotalDeadWood(10.0 * 0.8 + 2); rec1.setTotalHarvestedWood(10 -
	 * 0.5 * 10); rec1.setTotalLivingWood(20 - 10 - 2);
	 * rec1.setTotalProcessedWood(5);
	 * rec1.setTotalBoundCO2(rec1.getTotalLivingWood() + rec1.getTotalDeadWood()
	 * + rec1.getTotalHarvestedWood());
	 * expected.addSimulationRecordForYear(rec1, 1);
	 * 
	 * return Test.compareResults(actual, expected); }
	 * 
	 * // blackbox test of calculations in simulator in order to verify if the
	 * simulator works according to specification public boolean testFourYears()
	 * { SimulationRequest req = new SimulationRequest();
	 * req.setStartDeadWood(15); req.setStartLivingWood(30);
	 * req.setAvgWoodGrowth(8); req.setAvgProcessedWoodYearly(0.5);
	 * req.setAvgHarvestYearly(1); req.setAvgDecompWoodYearly(0.5);
	 * req.setAvgDeadWoodYearly(2);
	 * 
	 * SimulationResult actual = this.sim.simulate(req, 4);
	 * 
	 * // reference result SimulationResult expected = new SimulationResult(4);
	 * 
	 * SimulationResult.SimulationRecord rec = expected.new SimulationRecord();
	 * rec.setTotalBoundCO2(req.getStartDeadWood() + req.getStartLivingWood());
	 * rec.setTotalDeadWood(req.getStartDeadWood());
	 * rec.setTotalHarvestedWood(0);
	 * rec.setTotalLivingWood(req.getStartLivingWood());
	 * rec.setTotalProcessedWood(0); expected.addSimulationRecordForYear(rec,
	 * 0);
	 * 
	 * SimulationResult.SimulationRecord rec1 = expected.new SimulationRecord();
	 * rec1.setTotalDeadWood((rec.getTotalDeadWood() * (1 -
	 * req.getAvgDecompWoodYearly()) + req.getAvgDeadWoodYearly()));
	 * rec1.setTotalHarvestedWood(rec.getTotalHarvestedWood() +
	 * (req.getAvgHarvestYearly() * (1 - req.getAvgProcessedWoodYearly())));
	 * rec1.setTotalLivingWood(rec.getTotalLivingWood() + req.getAvgWoodGrowth()
	 * - req.getAvgDeadWoodYearly() - req.getAvgHarvestYearly());
	 * rec1.setTotalProcessedWood(rec.getTotalProcessedWood() +
	 * req.getAvgHarvestYearly() * req.getAvgProcessedWoodYearly());
	 * rec1.setTotalBoundCO2(rec1.getTotalLivingWood() + rec1.getTotalDeadWood()
	 * + rec1.getTotalHarvestedWood());
	 * expected.addSimulationRecordForYear(rec1, 1);
	 * 
	 * SimulationResult.SimulationRecord rec2 = expected.new SimulationRecord();
	 * rec2.setTotalDeadWood((rec1.getTotalDeadWood() * (1 -
	 * req.getAvgDecompWoodYearly()) + req.getAvgDeadWoodYearly()));
	 * rec2.setTotalHarvestedWood(rec1.getTotalHarvestedWood() +
	 * (req.getAvgHarvestYearly() * (1 - req.getAvgProcessedWoodYearly())));
	 * rec2.setTotalLivingWood(rec1.getTotalLivingWood() +
	 * req.getAvgWoodGrowth() - req.getAvgDeadWoodYearly() -
	 * req.getAvgHarvestYearly());
	 * rec2.setTotalProcessedWood(rec1.getTotalProcessedWood() +
	 * req.getAvgHarvestYearly() * req.getAvgProcessedWoodYearly());
	 * rec2.setTotalBoundCO2(rec2.getTotalLivingWood() + rec2.getTotalDeadWood()
	 * + rec2.getTotalHarvestedWood());
	 * expected.addSimulationRecordForYear(rec2, 2);
	 * 
	 * SimulationResult.SimulationRecord rec3 = expected.new SimulationRecord();
	 * rec3.setTotalDeadWood((rec2.getTotalDeadWood() * (1 -
	 * req.getAvgDecompWoodYearly()) + req.getAvgDeadWoodYearly()));
	 * rec3.setTotalHarvestedWood(rec2.getTotalHarvestedWood() +
	 * (req.getAvgHarvestYearly() * (1 - req.getAvgProcessedWoodYearly())));
	 * rec3.setTotalLivingWood(rec2.getTotalLivingWood() +
	 * req.getAvgWoodGrowth() - req.getAvgDeadWoodYearly() -
	 * req.getAvgHarvestYearly());
	 * rec3.setTotalProcessedWood(rec2.getTotalProcessedWood() +
	 * req.getAvgHarvestYearly() * req.getAvgProcessedWoodYearly());
	 * rec3.setTotalBoundCO2(rec3.getTotalLivingWood() + rec3.getTotalDeadWood()
	 * + rec3.getTotalHarvestedWood());
	 * expected.addSimulationRecordForYear(rec3, 3);
	 * 
	 * SimulationResult.SimulationRecord rec4 = expected.new SimulationRecord();
	 * rec4.setTotalDeadWood((rec3.getTotalDeadWood() * (1 -
	 * req.getAvgDecompWoodYearly()) + req.getAvgDeadWoodYearly()));
	 * rec4.setTotalHarvestedWood(rec3.getTotalHarvestedWood() +
	 * (req.getAvgHarvestYearly() * (1 - req.getAvgProcessedWoodYearly())));
	 * rec4.setTotalLivingWood(rec3.getTotalLivingWood() +
	 * req.getAvgWoodGrowth() - req.getAvgDeadWoodYearly() -
	 * req.getAvgHarvestYearly());
	 * rec4.setTotalProcessedWood(rec3.getTotalProcessedWood() +
	 * req.getAvgHarvestYearly() * req.getAvgProcessedWoodYearly());
	 * rec4.setTotalBoundCO2(rec4.getTotalLivingWood() + rec4.getTotalDeadWood()
	 * + rec4.getTotalHarvestedWood());
	 * expected.addSimulationRecordForYear(rec4, 4);
	 * 
	 * return Test.compareResults(actual, expected); }
	 */

	/**
	 * Tests an energy wood usage over 30 years
	 * 
	 * 
	 * @return
	 */
	public boolean testEnergyWoodThreeDecades() {
		SimulationRequest req = new SimulationRequest();

		Map<Class<? extends AbstractTree>, Integer> trees = new HashMap<>();

		trees.put(Spruce.class, 5);
		trees.put(BlackAlder.class, 15);

		Forest forest = new Forest(100.0, trees);

		req.setAvgProcessedWoodYearly(0.5);
		req.setForest(forest);
		req.setFixCosts(10000);
		req.setVariableCosts(5);
		req.setPricePerMeter(10);
		req.setEconomicModel(new DummyEconomicModel());
		req.setWeatherModel(new DummyWeatherModel());
		req.setWoodUsageModel(new EnergyWoodUsageModel(0.95, Spruce.class));

		SimulationResult actual = this.sim.simulate(req, 30);
		System.out.println("Result = "
				+ SimulationDisplay.formatAsTable(actual));
		return false;
	}

	private static boolean compareResults(SimulationResult actual,
			SimulationResult expected) {
		System.out.println("Actual = "
				+ SimulationDisplay.formatAsTable(actual));
		System.out.println("Expected = "
				+ SimulationDisplay.formatAsTable(expected));
		if (actual.getYearsSimulated() != expected.getYearsSimulated()) {
			return false;
		}
		for (int i = 0; i <= expected.getYearsSimulated(); i++) {
			if (!Test.compareRecords(actual.getRecordForYear(i),
					expected.getRecordForYear(i))) {
				return false;
			}
		}
		return true;
	}

	private static boolean compareRecords(
			SimulationResult.SimulationRecord actual,
			SimulationResult.SimulationRecord expected) {
		if (!(Test.areEqual(actual.getTotalBoundCO2(),
				expected.getTotalBoundCO2()))) {
			return false;
		}
		if (!Test.areEqual(actual.getTotalDeadWood(),
				expected.getTotalDeadWood())) {
			return false;
		}
		if (!Test.areEqual(actual.getTotalHarvestedWood(),
				expected.getTotalHarvestedWood())) {
			return false;
		}
		if (!Test.areEqual(actual.getTotalLivingWood(),
				expected.getTotalLivingWood())) {
			return false;
		}

		if (!actual.getTreesByType().equals(expected.getTreesByType())) {
			return false;
		}

		return Test.areEqual(actual.getTotalProcessedWood(),
				expected.getTotalProcessedWood());
	}

	/**
	 * Comparison method for <code>double</code> values which uses a treshold
	 * defined in <code>Test.CONSIDER_EQUAL_TRESHOLD</code> for comparison.
	 * Doubles whose difference is below this treshold are considered to be
	 * equal. Implementing this here rather than in
	 * <code>SimulationResult.equals</code> because that would also require a
	 * <code>hashCode</code> implementation which would be unnecessarily complex
	 * in htis case, as comparison of <code>SimulationResult</code>s is at the
	 * moment only relevant for testing purposes.
	 * 
	 * @param d1
	 *            the first double
	 * @param d2
	 *            the second double
	 * @return <code>true</code> if d1 and d2 are equal according to the
	 *         criteria above, <code>false</code> otherwise.
	 */
	private static boolean areEqual(double d1, double d2) {
		return (Math.abs(d1 - d2) < Test.CONSIDER_EQUAL_TRESHOLD) ? true
				: false;
	}
}
