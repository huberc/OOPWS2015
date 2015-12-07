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

        System.out.println(test.testForestField());

       /* Point[] points = new Point[3];
        points[0] = new Point(1,0);
        points[1] = new Point(2,2);
        points[2] = new Point(2,0);
        Forest forest = new Forest(3,3,points);

        System.out.println(forest.toString()); */
    }

    private static boolean testForestField() {
        Forest forest = new Forest(4,4);

      /*  Point tmp = new Point(0,3);
        BugColony colony = new BugColony(forest.getFieldAt(tmp));
        colony.setHealthy(false);
        forest.placeColony(colony, tmp);
        Point tmp2 = new Point(3,2);
        BugColony colony2 = new BugColony(forest.getFieldAt(tmp2));
        forest.placeColony(colony2, tmp2); */

        System.out.println(forest.toString());

        if (forest.getFieldAt(new Point(1,1)).checkNeighborhoodFree() == true) {
            System.out.println("(1,1) true.");
        }
        if (forest.getFieldAt(new Point(3,0)).checkNeighborhoodFree() == true) {
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
