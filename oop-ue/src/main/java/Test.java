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
        Point[] points = new Point[14];
        int counter = 0;
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 2; y++) {
                points[counter] = new Point(x, y);
                counter++;
            }
        }
        points[12] = new Point(1,3);
        points[13] = new Point(2,3);
        Forest forest = new Forest(4,4, points);
        Point tmp = new Point(0,3);
        BugColony colony = new BugColony(forest.getFieldAt(tmp));
        forest.placeColony(colony, tmp);

        if ((forest.getFieldAt(new Point(1,1)).checkNeighborhoodFree() == true) &&
                (forest.getFieldAt(new Point(3,0)).checkNeighborhoodFree() == true) &&
                (forest.getFieldAt(new Point(1,2)).checkNeighborhoodFree() == false) &&
                (forest.getFieldAt(new Point(2,2)).checkNeighborhoodFree() == false)) {
            return true;
        }

        return false;
    }
}
