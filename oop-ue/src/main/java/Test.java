import java.awt.*;

/**
 * Arbeitsaufteilung: Christoph Huber: Forest, ForestField Michael Langowksi: BugColony Ines Rieder: Test und
 * Zusicherungen
 */

public class Test {

    public static void main(String[] args) {

//        System.out.println("testForest: " + Test.testForest());
//        System.out.println("testForestField: " + Test.testForestField());
//        System.out.println("testBugColonyRandomNumbers: " + Test.testColonyRandomNum());
        /* Point[] points = new Point[3];
         points[0] = new Point(1,0);
         points[1] = new Point(2,2);
         points[2] = new Point(2,0);
         Forest forest = new Forest(3,3,points);

         System.out.println(forest.toString()); */
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

        if ((forest.getFieldAt(new Point(1, 1)).checkNeighborhoodFree() != true)
            || (forest.getFieldAt(new Point(3, 0)).checkNeighborhoodFree() != true)
            || (forest.getFieldAt(new Point(1, 2)).checkNeighborhoodFree() != false)
            || (forest.getFieldAt(new Point(2, 2)).checkNeighborhoodFree() != false)) {
            return false;
        }

        //getHealthyNeighbours
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
            //System.out.println("randNr = " + i);
            if (i < 5 || i > 50) {
                return false;
            }
        }
        return true;
    }
}
