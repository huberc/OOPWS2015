
public class ForestField {

    private BugColony colony = null;
    private ForestField left = null;
    private ForestField right = null;
    private ForestField up = null;
    private ForestField down = null;

    /**
     * Verifies if all eight neighboring fields of this field are free in terms
     * of not being infested by bugs. If the field is at the edge of the
     * forest, i.e. has less than eight neighbors, the non-existing fields are
     * counted as non-free.
     * <p>
     * Preconditions: All field pointers (left, right, up and down) are properly intitialized, i.e. != null unless
     * this field is an edge field where some neighbors might not exist.
     * Postconditions: All neighboring fields checked for existence of bug colonies on them
     *
     * @return true if no forestField in an 8-neighborhood of this field is occupied (field.getColony() == null),
     * false otherwise
     */
    public boolean checkNeighborhoodFree() {
        boolean upperNeighbors = true;
        boolean middleNeighbors = true;
        boolean lowerNeighbors = true;

        if(this.up != null){
            if(this.up.getColony() == null){
                upperNeighbors = true;
            }
            else{
                upperNeighbors = false;
            }
            if(this.up.left != null && upperNeighbors == true){
                if(this.up.left.getColony() == null){
                    upperNeighbors = true;
                }
                else {
                    upperNeighbors = false;
                }
            }
            if(this.up.right != null && upperNeighbors == true){
                if(this.up.right.getColony() == null){
                    upperNeighbors = true;
                }else {
                    upperNeighbors = false;
                }
            }
        }
       if(this.left != null){
           if(this.left.getColony() == null){
               middleNeighbors = true;
           }else{
               middleNeighbors = false;
           }
       }
        if(this.right != null && middleNeighbors == true){
            if(this.right.getColony() == null){
                middleNeighbors = true;
            }else{
                middleNeighbors = false;
            }
        }

        if(this.down != null){
            if(this.down.getColony() == null){
                lowerNeighbors = true;
            }
            else{
                lowerNeighbors = false;
            }
            if(this.down.left != null && lowerNeighbors == true){
                if(this.down.left.getColony() == null){
                    lowerNeighbors = true;
                }
                else {
                    lowerNeighbors = false;
                }
            }
            if(this.down.right != null && lowerNeighbors == true){
                if(this.down.right.getColony() == null){
                    lowerNeighbors = true;
                }else {
                    lowerNeighbors = false;
                }
            }
        }

        return upperNeighbors && middleNeighbors && lowerNeighbors;
    }

    /**
     * Preconditions: All field pointers (left, right, up and down) are properly intitialized, i.e. != null unless
     * this field is an edge field where some neighbors might not exist.
     * <p>
     * Postconditions: All healthy neighbors are counted.
     *
     * @return number of healthy neighbors
     */
    public synchronized int getHealthyNeighbors() {
        int cntHealthyNeighbors = 0;

        if (this.up != null) {
            if (this.up.getColony() != null) {
                if (this.up.getColony().isHealthy()) { cntHealthyNeighbors++; }
            }
        }
        if (this.up.left != null) {
            if (this.up.left.getColony() != null) {
                if (this.up.left.getColony().isHealthy()) { cntHealthyNeighbors++; }
            }
        }
        if (this.up.right != null) {
            if (this.up.right.getColony() != null) {
                if (this.up.right.getColony().isHealthy()) { cntHealthyNeighbors++; }
            }
        }
        if (this.left != null) {
            if (this.left.getColony() != null) {
                if (this.left.getColony().isHealthy()) { cntHealthyNeighbors++; }
            }
        }
        if (this.down != null) {
            if (this.down.getColony() != null) {
                if (this.down.getColony().isHealthy()) { cntHealthyNeighbors++; }
            }
        }
        if (this.down.left != null) {
            if (this.down.left.getColony() != null) {
                if (this.down.left.getColony().isHealthy()) { cntHealthyNeighbors++; }
            }
        }
        if (this.down.right != null) {
            if (this.down.right.getColony() != null) {
                if (this.down.right.getColony().isHealthy()) { cntHealthyNeighbors++; }
            }
        }
        if (this.right != null) {
            if (this.right.getColony() != null) {
                if (this.right.getColony().isHealthy()) { cntHealthyNeighbors++; }
            }
        }

     /*   if (this.up != null && this.up.getColony().isHealthy()) {
            cntHealthyNeighbors++;
        }
        if (this.up.left != null && this.up.left.getColony().isHealthy()) {
            cntHealthyNeighbors++;
        }
        if (this.up.right != null && this.up.right.getColony().isHealthy()) {
            cntHealthyNeighbors++;
        }
        if (this.left != null && this.left.getColony().isHealthy()) {
            cntHealthyNeighbors++;
        }
        if (this.down != null && this.down.getColony().isHealthy()) {
            cntHealthyNeighbors++;
        }
        if (this.down.left != null && this.down.left.getColony().isHealthy()) {
            cntHealthyNeighbors++;
        }
        if (this.down.right != null && this.down.right.getColony().isHealthy()) {
            cntHealthyNeighbors++;
        }
        if (this.right != null && this.right.getColony().isHealthy()) {
            cntHealthyNeighbors++;
        }   */


        return cntHealthyNeighbors;
    }


    /**
     * Preconditions: All field pointers (left, right, up and down) are properly intitialized, i.e. != null unless
     * this field is an edge field where some neighbors might not exist.
     * <p>
     * Postconditions: All infected neighbors are counted.
     *
     * @return number of infected neighbors
     */
    public synchronized int getInfectedNeighbors() {
        int cntInfectedNeighbors = 0;

        if (this.up != null) {
            if (this.up.getColony() != null) {
                if (!this.up.getColony().isHealthy()) { cntInfectedNeighbors++; }
            }
        }
        if (this.up.left != null) {
            if (this.up.left.getColony() != null) {
                if (!this.up.left.getColony().isHealthy()) { cntInfectedNeighbors++; }
            }
        }
        if (this.up.right != null) {
            if (this.up.right.getColony() != null) {
                if (!this.up.right.getColony().isHealthy()) { cntInfectedNeighbors++; }
            }
        }
        if (this.left != null) {
            if (this.left.getColony() != null) {
                if (!this.left.getColony().isHealthy()) { cntInfectedNeighbors++; }
            }
        }
        if (this.down != null) {
            if (this.down.getColony() != null) {
                if (!this.down.getColony().isHealthy()) { cntInfectedNeighbors++; }
            }
        }
        if (this.down.left != null) {
            if (this.down.left.getColony() != null) {
                if (!this.down.left.getColony().isHealthy()) { cntInfectedNeighbors++; }
            }
        }
        if (this.down.right != null) {
            if (this.down.right.getColony() != null) {
                if (!this.down.right.getColony().isHealthy()) { cntInfectedNeighbors++; }
            }
        }
        if (this.right != null) {
            if (this.right.getColony() != null) {
                if (!this.right.getColony().isHealthy()) { cntInfectedNeighbors++; }
            }
        }

       /* if (this.up != null && !this.up.getColony().isHealthy()) {
            cntInfectedNeighbors++;
        }
        if (this.up.left != null && !this.up.left.getColony().isHealthy()) {
            cntInfectedNeighbors++;
        }
        if (this.up.right != null && !this.up.right.getColony().isHealthy()) {
            cntInfectedNeighbors++;
        }
        if (this.left != null && !this.left.getColony().isHealthy()) {
            cntInfectedNeighbors++;
        }
        if (this.down != null && !this.down.getColony().isHealthy()) {
            cntInfectedNeighbors++;
        }
        if (this.down.left != null && !this.down.left.getColony().isHealthy()) {
            cntInfectedNeighbors++;
        }
        if (this.down.right != null && !this.down.right.getColony().isHealthy()) {
            cntInfectedNeighbors++;
        }
        if (this.right != null && !this.right.getColony().isHealthy()) {
            cntInfectedNeighbors++;
        }   */

        return cntInfectedNeighbors;
    }

    public BugColony getColony() {
        return colony;
    }

    public void setColony(BugColony colony) {
        this.colony = colony;
    }

    public ForestField getLeft() {
        return left;
    }

    public void setLeft(ForestField left) {
        this.left = left;
    }

    public ForestField getRight() {
        return right;
    }

    public void setRight(ForestField right) {
        this.right = right;
    }

    public ForestField getUp() {
        return up;
    }

    public void setUp(ForestField up) {
        this.up = up;
    }

    public ForestField getDown() {
        return down;
    }

    public void setDown(ForestField down) {
        this.down = down;
    }

}
