import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Test class for the environment simulation.
 *
 * @author Michael Langowski, e1426581@student.tuwien.ac.at
 * @author Christoph Huber, e1427322@student.tuwien.ac.at
 * @author Ines Rieder, e1425000@student.tuwien.ac.at
 *
 *
 */
public class Test {

	private static final double CONSIDER_EQUAL_TRESHOLD = 0.001;


	public static void main(String[] args) {

	    System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()));
		System.out.println("Bauholzarten-Test: "+testBauHolzArten());
	}

	/**
	 * Wenn keine Exception geworfen wird, dann ist der Test falsch
	 *
	 * @return true wenn der Test OK ist
     */
	private static boolean testBauHolzArten(){

		try {
			Brett brett = new Brett(10, 1, 0);

			return false;
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}

		try {
			BauRundholz bauRundholz = new BauRundholz(10,10);
			return false;
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}

		try {
			Kantholz kantholz = new Kantholz(10,1,0);
			return false;
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		return true;
	}

	private static boolean testSaegen(){

		try {
			Rundholz rundholz = new Rundholz(100, 80);
			Schnittholz schnittholz = (Schnittholz) rundholz.neu(Schnittholz.class);
			Brett brett = (Brett) schnittholz.neu(Brett.class);

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
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
