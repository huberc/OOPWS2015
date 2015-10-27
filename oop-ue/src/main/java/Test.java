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

	private static final double CONSIDER_EQUAL_TRESHOLD = 0.001;

	private Simulator sim = new Simulator();

	public static void main(String[] args) {
		Test simulatorTest = new Test();
		System.out.println("TEST RUN OF WOODGROWTH SIMULATION:\n");
		System.out
				.println("1. Test result content with only initial state, no simulation done at all:");
		System.out.println("Test of initial state: "
				+ simulatorTest.testInitialState());
		simulatorTest.testEnergyWoodThreeDecades();
		System.out.println("Test des linearen Wetter Models:");
		System.out.println("Teststatus für 3 Jahre und zwei unterschiedliche Simulationen: "+simulatorTest.testLinearWeahterModel());
		System.out.println("Test des exponentialen Wetter Models:");
		System.out.println("Teststatus für 3 Jahre und zwei unterschiedliche Simulationen: "+simulatorTest.testExponentialWeatherModel());
		System.out.println("Test des logarithmischen Wetter Models:");
		System.out.println("Teststatus für 3 Jahre und zwei unterschiedliche Simulationen: "+simulatorTest.testLogarithmicWeatherModel());

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
		rec.setLivingTreesByType(treesByType);
		expected.addSimulationRecordForYear(rec, 0);
		return Test.compareResults(actual, expected);
	}

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
		req.setWoodUsageModel(new DummyWoodUsageModel());
		//req.setWoodUsageModel(new EnergyWoodUsageModel(0.95, Spruce.class));

		SimulationResult actual = this.sim.simulate(req, 30);
		System.out.println("Result = "
				+ SimulationDisplay.formatAsTable(actual));
		return false;
	}
	public boolean testLogarithmicWeatherModel(){

		LogarithmicWeatherModel logarithmicWeatherModel= new LogarithmicWeatherModel(3,0.5,3,0.5);

		if(!(areEqual(logarithmicWeatherModel.calcWeatherForYear(1).getRainfall(),0.5) &&areEqual(logarithmicWeatherModel.calcWeatherForYear(1).getAvgTemperature(),0.5)))
			return  false;
		if(!(areEqual(logarithmicWeatherModel.calcWeatherForYear(2).getRainfall(),2.5794) && areEqual(logarithmicWeatherModel.calcWeatherForYear(2).getAvgTemperature(),2.5794)))
			return false;
		if(!(areEqual(logarithmicWeatherModel.calcWeatherForYear(3).getRainfall(),3.7958) && areEqual(logarithmicWeatherModel.calcWeatherForYear(3).getAvgTemperature(),3.7958)))
			return false;

		LogarithmicWeatherModel logarithmicWeatherModel1= new LogarithmicWeatherModel(4,1,6,3);

		if(!(areEqual(logarithmicWeatherModel1.calcWeatherForYear(1).getAvgTemperature(),1.0) &&areEqual(logarithmicWeatherModel1.calcWeatherForYear(1).getRainfall(),3.0)))
			return  false;
		if(!(areEqual(logarithmicWeatherModel1.calcWeatherForYear(2).getAvgTemperature(),3.7725) && areEqual(logarithmicWeatherModel1.calcWeatherForYear(2).getRainfall(),7.1588)))
			return false;
		if(!(areEqual(logarithmicWeatherModel1.calcWeatherForYear(3).getAvgTemperature(),5.3944) && areEqual(logarithmicWeatherModel1.calcWeatherForYear(3).getRainfall(),9.59167)))
			return false;

		return true;
	}
	public boolean testExponentialWeatherModel(){

		ExponentialWeatherModel exponentialWeatherModel = new ExponentialWeatherModel(3,0.00005,3,0.00005);

		if(!(areEqual(exponentialWeatherModel.calcWeatherForYear(1).getRainfall(),3.00015) &&areEqual(exponentialWeatherModel.calcWeatherForYear(1).getAvgTemperature(),3.00015)))
			return  false;
		if(!(areEqual(exponentialWeatherModel.calcWeatherForYear(2).getRainfall(),3.0003) && areEqual(exponentialWeatherModel.calcWeatherForYear(2).getAvgTemperature(),3.0003)))
			return false;
		if(!(areEqual(exponentialWeatherModel.calcWeatherForYear(3).getRainfall(),3.00045) && areEqual(exponentialWeatherModel.calcWeatherForYear(3).getAvgTemperature(),3.00045)))
			return false;

		ExponentialWeatherModel exponentialWeatherModel1 = new ExponentialWeatherModel(4,0.00002,2,0.00003);

		if(!(areEqual(exponentialWeatherModel1.calcWeatherForYear(1).getAvgTemperature(),4.00008) &&areEqual(exponentialWeatherModel1.calcWeatherForYear(1).getRainfall(),2.00006)))
			return  false;
		if(!(areEqual(exponentialWeatherModel1.calcWeatherForYear(2).getAvgTemperature(),4.00016) && areEqual(exponentialWeatherModel1.calcWeatherForYear(2).getRainfall(),2.00012)))
			return false;
		if(!(areEqual(exponentialWeatherModel1.calcWeatherForYear(3).getAvgTemperature(),4.00024) && areEqual(exponentialWeatherModel1.calcWeatherForYear(3).getRainfall(),2.00018)))
			return false;

		return true;
	}
	public boolean testLinearWeahterModel(){

		LinearWeatherModel linearWeatherModel = new LinearWeatherModel(0.5,8,0.5,8);

		if(!(areEqual(linearWeatherModel.calcWeatherForYear(1).getRainfall(),8.5) &&areEqual(linearWeatherModel.calcWeatherForYear(1).getAvgTemperature(),8.5)))
			return  false;
		if(!(areEqual(linearWeatherModel.calcWeatherForYear(2).getRainfall(),9.0) && areEqual(linearWeatherModel.calcWeatherForYear(2).getAvgTemperature(),9.0)))
			return false;
		if(!(areEqual(linearWeatherModel.calcWeatherForYear(3).getRainfall(),9.5) && areEqual(linearWeatherModel.calcWeatherForYear(3).getAvgTemperature(),9.5)))
			return false;

		LinearWeatherModel linearWeatherModel1 = new LinearWeatherModel(0.4,7.5,0.6,10);

		if(!(areEqual(linearWeatherModel1.calcWeatherForYear(1).getAvgTemperature(),7.9) &&areEqual(linearWeatherModel1.calcWeatherForYear(1).getRainfall(),10.6)))
			return  false;
		if(!(areEqual(linearWeatherModel1.calcWeatherForYear(2).getAvgTemperature(),8.3) && areEqual(linearWeatherModel1.calcWeatherForYear(2).getRainfall(),11.2)))
			return false;
		if(!(areEqual(linearWeatherModel1.calcWeatherForYear(3).getAvgTemperature(),8.7) && areEqual(linearWeatherModel1.calcWeatherForYear(3).getRainfall(),11.8)))
			return false;

		return true;
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

		if (!actual.getLivingTreesByType().equals(expected.getLivingTreesByType())) {
			return false;
		}
		
		if (!actual.getDeadTreesByType().equals(expected.getDeadTreesByType())) {
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
