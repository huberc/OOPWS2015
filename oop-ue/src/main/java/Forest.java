import java.awt.Point;


public class Forest {

    private ForestField topLeft = new ForestField();
    private int width,height;

    public Forest(int width, int height) {
        this.width = width;
        this.height = height;
        this.initFields(width, height);
    }

    public Forest(int width, int height, Point... colonies) {
        this.width = width;
        this.height = height;
        this.initFields(width, height);
        for (int i = 0; i < colonies.length; i++) {
            placeColony(colonies[i]);
        }
    }

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
     *
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
                       current.setRight(new ForestField());
                        //-> hast du bereits durch setDown erzeugt, mein versuch es zu aendern ist gescheitert ^^
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
