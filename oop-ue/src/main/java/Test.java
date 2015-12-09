import java.awt.*;

/**
 * Arbeitsaufteilung:
 *  Christoph Huber: Forest, ForestField
 *  Michael Langowksi: BugColony
 *  Ines Rieder: Test und Zusicherungen
 */

public class Test {

    public static void main(String[] args) {

        Test test = new Test();
        System.out.println("testSim: " + test.testSim());
        System.out.println("testForest: " + test.testForest());
        System.out.println("testForestField: " + test.testForestField());
        System.out.println("testColonyRandom: " + test.testColonyRandomNum());
        System.out.println("testBugColony: " + test.testBugColony());
        Test.testSim();
    }

    private static boolean testSim(){
        Forest.init(10, 10, 3);
        Forest.getInstance().startSimulation();
        return true;
    }
    
    private static boolean testForest() {
        Forest.init(3, 3);
        Forest forest = Forest.getInstance();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                ForestField tmp = forest.getFieldAt(new Point(x, y));
                if ((tmp == null) || (tmp.getColony() != null)) {
                    System.out.println("Forest(int width, int height) not working correctly.");
                    return false;
                }
            }
        }

        Point[] points = new Point[3];
        points[0] = new Point(0, 0);
        points[1] = new Point(1, 1);
        points[2] = new Point(2, 2);
        Forest.init(3, 3, points);
        forest = Forest.getInstance();
        for (int i = 0; i < points.length; i++) {
            if ((forest.getFieldAt(points[i])) == null) {
                System.out.println("Forest(int width, int height, Point... colonies) not working correctly.");
                return false;
            }
        }

        Forest.init(3, 3, 3);
        forest = Forest.getInstance();
        int counter = 0;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                ForestField tmp = forest.getFieldAt(new Point(x, y));
                if (tmp.getColony() != null) {
                    counter++;
                }
            }
        }
        if (counter != 3) {
            System.out.println("Forest(int width, int height, int numColonies) not working correctly.");
            return false;
        }

        forest.placeColony(points[0]);
        forest.placeColony(points[1]);
        forest.placeColony(points[2]);
        for (int i = 0; i < 3; i++) {
            if ((forest.getFieldAt(points[i])) == null) {
                System.out.println("placeColony(Point pos) not working correctly.");
                return false;
            }
        }

        return true;
    }

    private static boolean testForestField() {
        Forest.init(4, 4);
        Forest forest = Forest.getInstance();

        Point tmp = new Point(0, 3);
        BugColony colony = new BugColony(forest.getFieldAt(tmp));
        colony.setHealthy(false);
        forest.placeColony(colony, tmp);
        forest.placeColony(new Point(3, 2));

        if ((!forest.getFieldAt(new Point(1, 1)).checkNeighborhoodFree())
            || (!forest.getFieldAt(new Point(3, 0)).checkNeighborhoodFree())
            || (forest.getFieldAt(new Point(1, 2)).checkNeighborhoodFree())
            || (forest.getFieldAt(new Point(2, 2)).checkNeighborhoodFree())) {
            return false;
        }

        Point tmp1 = new Point(2, 1);
        BugColony colony1 = new BugColony(forest.getFieldAt(tmp1));
        colony1.setHealthy(false);
        forest.placeColony(colony1, tmp1);
        forest.placeColony(new Point(2, 3));
        forest.placeColony(new Point(0, 2));

        if ((forest.getFieldAt(new Point(1, 2)).getNumInfectedNeighbors() != 2)
            || (forest.getFieldAt(new Point(1, 2)).getNumHealthyNeighbors() != 2)
            || (forest.getFieldAt(new Point(2, 2)).getNumInfectedNeighbors() != 1)
            || (forest.getFieldAt(new Point(2, 2)).getNumHealthyNeighbors() != 2)
            || (forest.getFieldAt(new Point(3, 3)).getNumHealthyNeighbors() != 2)) {
            return false;
        }

        return true;
    }

    private static boolean testColonyRandomNum() {
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = BugColony.calcWaitMsecs();
        }
        for (int i : numbers) {
            if (i < 5 || i > 50) {
                return false;
            }
        }
        return true;
    }

    private static boolean testBugColony() {
        Point[] points = new Point[8];
        int counter = 0;
        for (int x = 0; x < 3; x ++) {
            points[counter] = new Point(x, 0);
            counter++;
        }
        for (int x = 0; x < 3; x ++) {
            points[counter] = new Point(x, 2);
            counter++;
        }
        points[6] = new Point(0,1);
        points[7] = new Point(2,1);
        Forest.init(4, 4, points);
        Forest forest = Forest.getInstance();

        Point tmp = new Point(1,1);
        BugColony colony = new BugColony(forest.getFieldAt(tmp));
        Point tmp1 = new Point(3, 2);
        BugColony colony1 = new BugColony(forest.getFieldAt(tmp1));

        if ((colony.isHealthy()) || (!colony1.isHealthy())) {
            System.out.println("BugColony(ForestField home) is not working correctly.");
            return false;
        }

        Point tmp2 = new Point(0,3);
        colony.setSteps(12);
        BugColony colony2 = new BugColony(forest.getFieldAt(tmp2), colony);
        Point tmp3 = new Point(3,3);
        BugColony colony3 = new BugColony(forest.getFieldAt(tmp3), colony2);

        if ((colony2.getSteps() != 12) || (colony3.getSteps() != 12) || (!colony2.isHealthy()) || (!colony3.isHealthy())) {
            System.out.println("BugColony(ForestField home, BugColony origin) is not working correctly.");
            return false;
        }

        Forest.init(2,1);
        forest = Forest.getInstance();
        Point point = new Point(0,0);
        BugColony colony4 = new BugColony(forest.getFieldAt(point));
        forest.placeColony(colony4, point);
        colony4.run();

        if (forest.getFieldAt(new Point(1,0)).getColony() == null) {
            System.out.println("run() is not working correctly.");
            return false;
        }

        Forest.init(2,1);
        forest = Forest.getInstance();
        BugColony colony5 = new BugColony(forest.getFieldAt(point));
        colony5.setHealthy(false);
        forest.placeColony(colony5, point);
        colony5.run();

        if (forest.getFieldAt(new Point(1,0)).getColony() != null) {
            System.out.println("run() is not working correctly.");
            return false;
        }

        return true;
    }
}
