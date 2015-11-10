import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

    private static final double                                                                  CONSIDER_EQUAL_TRESHOLD = 0.001;

    private static final Map<Class<? extends AbstractHolz>, List<Class<? extends AbstractHolz>>> VALID_CONVERSIONS       = new HashMap<>();

    static {
        List<Class<? extends AbstractHolz>> rundholzTargetTypes = new ArrayList<>();
        rundholzTargetTypes.add(Rundholz.class);
        rundholzTargetTypes.add(Energieholz.class);
        rundholzTargetTypes.add(Saegerundholz.class);
        rundholzTargetTypes.add(BauRundholz.class);
        Test.VALID_CONVERSIONS.put(Rundholz.class, rundholzTargetTypes);

        List<Class<? extends AbstractHolz>> energieholzTargetTypes = new ArrayList<>();
        energieholzTargetTypes.add(Rundholz.class);
        energieholzTargetTypes.add(Energieholz.class);
        energieholzTargetTypes.add(Saegerundholz.class);
        energieholzTargetTypes.add(BauRundholz.class);
        Test.VALID_CONVERSIONS.put(Energieholz.class, energieholzTargetTypes);

        List<Class<? extends AbstractHolz>> schnittholzTargetTypes = new ArrayList<>();
        schnittholzTargetTypes.add(Schnittholz.class);
        schnittholzTargetTypes.add(Vollkantschnittholz.class);
        schnittholzTargetTypes.add(Brett.class);
        schnittholzTargetTypes.add(Kantholz.class);
        schnittholzTargetTypes.add(Energieholz.class);
        Test.VALID_CONVERSIONS.put(Schnittholz.class, schnittholzTargetTypes);
    }

    public static void main(String[] args) {

        System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()));
        System.out.println("Bauholzarten-Test: " + testBauHolzArten());
        testAllgemein();
        System.out.println();
        System.out.println("Test der Saegen-Methoden:" + testSaegen());
        System.out.println("Test der Neu-Methode ist: " + testNeu());
        System.out.println("Test der Schaelen-Methode ist: " + testSchaelen());
        System.out.println("Test der Fasen-Methode ist: " + testFasen());
        System.out.println("Test der Mahlen-Methode ist: " + testMahlen());
        System.out.println("Test der Hacken-Methode ist: " + testHacken());
    }

    /**
     * Wenn keine Exception geworfen wird, dann ist der Test falsch
     *
     * @return true wenn der Test OK ist
     */
    private static boolean testBauHolzArten() {

        try {
            Brett brett = new Brett(10, 1, 0);

            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            BauRundholz bauRundholz = new BauRundholz(10, 10);
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Kantholz kantholz = new Kantholz(10, 1, 0);
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    private static void testAllgemein() {

        try {
            Rundholz rundholz = new Rundholz(100, 80);
            System.out.println(rundholz.toString());
            Schnittholz schnittholz = new Schnittholz(100, 30, 10);
            System.out.println(schnittholz.toString());
            Saegerundholz saegerundholz = new Saegerundholz(100, 10, 0.05);
            System.out.println(saegerundholz);
            Industrieholz industrieholz = new Industrieholz(1000, 20);
            System.out.println(industrieholz);
            Brett brett = new Brett(100, 3, 10);
            System.out.println(brett);
            Vollkantschnittholz vollkantschnittholz = new Vollkantschnittholz(1000, 120, 78);
            System.out.println(vollkantschnittholz);
            Kantholz kantholz = new Kantholz(1000, 12, 20);
            System.out.println(kantholz);
            Energieholz energieholz = new Energieholz(100, 66.18);
            System.out.println(energieholz);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean testSaegen() {
        try {
            Saegerundholz saegerundholz = new Saegerundholz(100, 60);
            Etikett[] saegen = saegerundholz.saegen(Schnittholz.class, Schnittholz.class, Energieholz.class);
            Schnittholz tmp = new Schnittholz(100, 20, 60);
            if ((saegen.length != 3) || (saegen[0].equals(tmp)) || (saegen[1].equals(tmp))) {
                return false;
            }
            if (saegen[2] instanceof Energieholz) {
                if ((!areEqual(((Energieholz) saegen[2]).getVolumen(), 31415.92654))
                    || (saegen[2].laenge() != 100)) {
                    return false;
                }
            } else {
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Schnittholz schnittholz = new Schnittholz(100, 20, 20);
            Etikett[] saegen = schnittholz.saegen(Energieholz.class, Schnittholz.class);
            Energieholz tmp1 = new Energieholz(100, 20000);
            Schnittholz tmp2 = new Schnittholz(100, 10, 20);
            if ((saegen.length != 2) || (saegen[0] != tmp1) || (saegen[1] != tmp2)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     *
     * @return
     */
    private static boolean testNeu() {
        try {
            AbstractHolz tmp = null;
            for (Entry<Class<? extends AbstractHolz>, List<Class<? extends AbstractHolz>>> entry : Test.VALID_CONVERSIONS
                    .entrySet()) {
                if (entry.getKey() == Rundholz.class) {
                    tmp = new Rundholz(10, 33);

                } else if (entry.getKey() == Energieholz.class) {
                    tmp = new Energieholz(10, 100000);
                } else if (entry.getKey() == Schnittholz.class) {
                    tmp = new Schnittholz(10, 1, 9);
                }
                for (Class<? extends AbstractHolz> target : entry.getValue()) {
                    //                    try {
                    //                        System.err.println("Testing conversion of " + tmp.getClass() + " to " + target);
                        if (target == Kantholz.class) {
                            // bypass validation, this is about types only
                            AbstractHolz tmp1 = new Schnittholz(10, 5, 5);
                            tmp1.neu(target);
                        } else {
                            tmp.neu(target);
                        }
//                    } catch (IllegalArgumentException ex) {
//                        System.err.println("Got exception: " + ex.getMessage());
//                        throw ex;
//                    }
                }
            }
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    private static boolean testSchaelen() {
        Saegerundholz saegerundholz = new Saegerundholz(1000, 100, 0.1);
        BauRundholz bauRundholz = saegerundholz.schaelen();
        if (bauRundholz.getStaerke() == 100 * (1 - 0.1))
            return true;
        else
            return false;
    }

    private static boolean testFasen() {
        Industrieholz industrieholz = new Industrieholz(100, 10);

        try {
            industrieholz.fasen();
            industrieholz.neu(Energieholz.class);
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private static boolean testMahlen() {

        Industrieholz industrieholz = new Industrieholz(100, 10);

        try {
            industrieholz.mahlen();
            industrieholz.neu(Energieholz.class);
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }

    }

    private static boolean testHacken() {
        Energieholz energieholz = new Energieholz(100, 89.25);

        try {
            energieholz.hacken();
            energieholz.neu(Rundholz.class);
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    /**
     * Comparison method for <code>double</code> values which uses a treshold defined in
     * <code>Test.CONSIDER_EQUAL_TRESHOLD</code> for comparison. Doubles whose difference is below this
     * treshold are considered to be equal. Implementing this here rather than in
     * <code>SimulationResult.equals</code> because that would also require a <code>hashCode</code>
     * implementation which would be unnecessarily complex in htis case, as comparison of
     * <code>SimulationResult</code>s is at the moment only relevant for testing purposes.
     *
     * @param d1
     *            the first double
     * @param d2
     *            the second double
     * @return <code>true</code> if d1 and d2 are equal according to the criteria above, <code>false</code>
     *         otherwise.
     */
    private static boolean areEqual(double d1, double d2) {
        return (Math.abs(d1 - d2) < Test.CONSIDER_EQUAL_TRESHOLD) ? true : false;
    }

    public static String formatDate(int year, int month, int day) {
        return ""; // TODO Michi
    }
}
