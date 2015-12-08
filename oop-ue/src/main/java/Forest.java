import java.awt.Point;

/**
 * forest consisting of ForestFields layed out in a grid pattern
 */
public class Forest {

    private ForestField topLeft = new ForestField();
    private int width,height;

    /**
     * generating a new Forest
     * Precondition: width and height are not null and > 0
     * Postcondition: a new Forest (incl. its ForestFields) with the given width and height has been created
     * @param width     width of new forest
     * @param height    height of new forest
     */
    public Forest(int width, int height) {
        this.width = width;
        this.height = height;
        this.initFields(width, height);
    }

    /**
     * generating a new Forest
     * Precondition: width, height and colonies are not null and width and height are > 0
     * Postcondition: a new Forest (incl. its ForestFields) with the given width and height has been created
     *  and colonies placed on the given points
     * @param width     width of new forest
     * @param height    height of new forest
     * @param colonies  List of Points where new colonies should be created
     */
    public Forest(int width, int height, Point... colonies) {
        this.width = width;
        this.height = height;
        this.initFields(width, height);
        for (int i = 0; i < colonies.length; i++) {
            placeColony(colonies[i]);
        }
    }

    /**
     * generating a new Forest
     * Precondition: width, height and numColonies are not null and > 0
     * Postcondition: a new Forest (incl. its ForestFields) with the given width and height has been created
     *  and the given number of colonies have been placed in the forest
     * @param width     width of new forest
     * @param height    height of new forest
     * @param numColonies   number of colonies that should be placed in this forest
     */
    public Forest(int width, int height, int numColonies) {
        this.width = width;
        this.height = height;
        this.initFields(width, height);
        for (int i = 0; i < numColonies; i++) {
            int randomNumberX = (int) (Math.random() * width);
            int randomNumberY = (int) (Math.random() * height);

            ForestField current = getFieldAt(new Point(randomNumberX, randomNumberY));

            while (current.getColony() != null) {
                randomNumberX = (int) (Math.random() * width);
                randomNumberY = (int) (Math.random() * height);
                current = getFieldAt(new Point(randomNumberX, randomNumberY));
            }

           current.setColony(new BugColony(current));
        }
    }

    /**
     * Precondition: pos is not null and lays in the forest (x/y not bigger than width/height)
     * Postcondition: a new BugColony has been placed on the given position
     * @param pos position with x- and y-coordinates where a new colony should be placed
     */
    public void placeColony(Point pos) {

        ForestField current = getFieldAt(pos);

        if(current.getColony() == null) {
            current.setColony(new BugColony(current));
        }
    }

    /**
     * used for testing
     * Preconditions: bugColony and point are not null, point lays in the Forest
     * Postconditions: bugColony has been set on the given point
     * @param bugColony colony to be placed at point
     * @param point position with x- and y-coordinates where bugColony should be placed
     */
    public void placeColony(BugColony bugColony, Point point) {
        getFieldAt(point).setColony(bugColony);
    }

    /**
     * Precondition: pos is not null and lays in the forest (x/y not bigger than width/height)
     * Postcondition: ForestField at the given position has been returned
     * @param pos   position with x- and y-coordinates which ForestField should be returned
     * @return      ForestField at given position
     */
    public ForestField getFieldAt(Point pos) {
        ForestField current = topLeft;
        for (int i = 0; i < pos.getY(); i++) {
            current = current.getDown();
        }
        for (int i = 0; i < pos.getX(); i++) {
            current = current.getRight();
        }

        return current;
    }

    /**
     * Precondition: Forest, width, height and all ForestFields of this Forest have been initialized
     * Postcondition: an illustration of this forest in form of a String has been returned
     * @return  illustration of this forest in form of a String
     */
    public synchronized String toString() {
        StringBuilder result = new StringBuilder();
        result.append("+");
        for(int i=0;i<width;i++){
            result.append("-");
        }
        result.append("+\n");
        for (int y=0;y<height;y++){
            result.append("|");
            for (int x=0;x<width;x++){
                ForestField current = getFieldAt(new Point(x,y));
                if(current.getColony() != null){
                    if(current.getColony().isHealthy()){
                        result.append("o");
                    }else{
                        result.append("x");
                    }
                }else{
                    result.append(" ");
                }
            }
            result.append("|\n");
        }
        result.append("+");
        for(int i=0;i<width;i++){
            result.append("-");
        }
        result.append("+\n");
        return String.valueOf(result);
    }

    // starts all simulations
    public void start() {
        for (int y=0;y<height;y++){
            for (int x=0;x<width;x++){
                ForestField current = getFieldAt(new Point(x,y));
                if(current.getColony() != null){
                    current.getColony().run();
                }
            }
        }
    }

    /**
     * Precondition: width and height are not null and > 0
     * Postcondition: ForestFields for the given width and height have been initialized for this forest
     * @param width     width of new forest which ForestFields should be initialized
     * @param height    height of new forest which ForestFields should be initialized
     */
    public void initFields(int width, int height) {

        ForestField currentY = topLeft;
        ForestField current = topLeft;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (y == 0) {
                    if (x != 0) {
                        current.setLeft(this.getFieldAt(new Point(x - 1, y)));
                    }
                    if(x != width-1) {
                        current.setRight(new ForestField());
                    }
                    current.setDown(new ForestField());

                    current = current.getRight();
                } else {
                    if (x != 0) {
                        current.setLeft(this.getFieldAt(new Point(x - 1, y)));
                    }
                    current.setUp(this.getFieldAt(new Point(x, y - 1)));

                    if(x != width-1) {
                       current.setRight(current.getUp().getRight().getDown());
                    }
                    if(y != height-1){
                        current.setDown(new ForestField());
                    }

                    current = current.getRight();
                }
            }
            current = currentY.getDown();
            currentY = currentY.getDown();
        }
    }

}
