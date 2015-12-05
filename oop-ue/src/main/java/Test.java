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
        Point[] points = new Point[3];
        points[0] = new Point(1,0);
        points[1] = new Point(2,2);
        points[2] = new Point(2,0);
        Forest forest = new Forest(3,3,points);

        System.out.println(forest.toString());
    }
}
