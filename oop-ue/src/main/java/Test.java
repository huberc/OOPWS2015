import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Test class for the environment simulation.
 *
 * @author Michael Langowski, e1426581@student.tuwien.ac.at All Interfaces, WeatherConditions, WoodUsageAction, RecorveryWoodUsageModel, RealWeatherModel, EnergyWoodUsageModel, DummyWeatherModel
 * @author Christoph Huber, e1427322@student.tuwien.ac.at Simulator, SimulatorRequest, SimulationDisplay, LinearWeatherModel, ExponentialWeatherModel, LogarithmicWeathermodel, DummyEconomicModel
 * @author Ines Rieder, e1425000@student.tuwien.ac.at Forest, BlackAlder, Spruce, SimulationDisplay, AbstractTree
 *
 *
 * GOOD:
 * 		- the class cohesion overall the project is quite good
 * 		- good dynamic binding for example the <code>Simulator</code> and the <code>Weathermodels</code>
 * BAD:
 * 		- Apart from a few punctual cases (e.g. Evaluation of wood actions in simulator) we havent found any fundamental errors
 * 		 and believe the overall design to be OK. Cases where improvements could be implemented are noted as such in the code ("BAD")
 */
public class Test {

	private static final double CONSIDER_EQUAL_TRESHOLD = 0.001;


	public static void main(String[] args) {

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
	
	public static String formatDate(int year, int month, int day){
	    return ""; // TODO Michi
	}
}
