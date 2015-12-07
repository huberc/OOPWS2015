import java.awt.*;

/**
 * Arbeitsaufteilung:
 *  Christoph Huber:
 *  Michael Langowksi:
 *  Ines Rieder:
 */

public class Test {

    public static void main(String[] args) {
        Test test = new Test();

        System.out.println(test.testForest());

       /* Point[] points = new Point[3];
        points[0] = new Point(1,0);
        points[1] = new Point(2,2);
        points[2] = new Point(2,0);
        Forest forest = new Forest(3,3,points);

        System.out.println(forest.toString()); */
    }

    private static boolean testForest() {
        Forest forest = new Forest(3,3);
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                ForestField tmp = forest.getFieldAt(new Point(x,y));
                if ((tmp == null) || (tmp.getColony() != null)) {
                    System.out.println("Forest(int width, int height) not working correctly.");
                    return false;
                }
            }
        }

        Point[] points = new Point[3];
        points[0] = new Point(0,0);
        points[1] = new Point(1,1);
        points[2] = new Point(2,2);
        Forest forest1 = new Forest(3,3, points);
        for(int i = 0; i < points.length; i++) {
            if ((forest1.getFieldAt(points[i])) == null) {
                System.out.println("Forest(int width, int height, Point... colonies) not working correctly.");
                return false;
            }
        }

        Forest forest2 = new Forest(3,3,3);
        int counter = 0;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                ForestField tmp = forest2.getFieldAt(new Point(x,y));
                if (tmp.getColony() != null) {
                    counter++;
                }
            }
        }
        if (counter != 3) {
            System.out.println("Forest(int width, int height, int numColonies) not working correctly.");
            return false;
        }

        return true;
    }

    private static boolean testForestField() {
        Forest forest = new Forest(4,4);

        Point tmp = new Point(0,3);
        BugColony colony = new BugColony(forest.getFieldAt(tmp));
        colony.setHealthy(false);
        forest.placeColony(colony, tmp);
        Point tmp2 = new Point(3,2);
        BugColony colony2 = new BugColony(forest.getFieldAt(tmp2));
        forest.placeColony(colony2, tmp2);

        System.out.println(forest.toString());

        if (forest.getFieldAt(new Point(1,1)).checkNeighborhoodFree() == true) {
            System.out.println("(1,1) true.");
        }
        if (forest.getFieldAt(new Point(2,1)).checkNeighborhoodFree() == true) {
            System.out.println("(3,0) true.");
        }
        if (forest.getFieldAt(new Point(1,2)).checkNeighborhoodFree() == false) {
            System.out.println("(1,2) false.");
        }
        if (forest.getFieldAt(new Point(2,2)).checkNeighborhoodFree() == false) {
            System.out.println("(2,2) false.");
        }

        if ((forest.getFieldAt(new Point(1,1)).checkNeighborhoodFree() == true) &&
                (forest.getFieldAt(new Point(3,0)).checkNeighborhoodFree() == true) &&
                (forest.getFieldAt(new Point(1,2)).checkNeighborhoodFree() == false) &&
                (forest.getFieldAt(new Point(2,2)).checkNeighborhoodFree() == false)) {
            return true;
        }

        return false;
    }
}
