import java.util.ArrayList;
import java.util.List;

/**
 * one Field of the grid pattern of a forest
 */
public class ForestField {

    private BugColony   colony = null;
    private ForestField left   = null;
    private ForestField right  = null;
    private ForestField up     = null;
    private ForestField down   = null;

    /**
     * Verifies if at least one of the eight neighboring fields of this field are free in terms of not being
     * infested by bugs. If the field is at the edge of the forest, i.e. has less than eight neighbors, the
     * non-existing fields are counted as non-free.
     * <p>
     * Preconditions: All field pointers (left, right, up and down) are properly initialized, i.e. != null
     * unless this field is an edge field where some neighbors might not exist. Postconditions: All
     * neighboring fields checked for existence of bug colonies until one is found that's free
     *
     * @return true if at least one forestField in an 8-neighborhood of this field is free (field.getColony()
     *         == null), false otherwise
     */
    public boolean checkNeighborhoodFree() {
        boolean upperNeighbors = false;
        boolean middleNeighbors = false;
        boolean lowerNeighbors = false;

        if (this.up != null) {
            upperNeighbors = this.up.colony == null || (this.up.left != null && this.up.left.colony == null)
                             || (this.up.right != null && this.up.right.colony == null);
        }
        if (this.down != null) {
            lowerNeighbors = this.down.colony == null
                             || (this.down.left != null && this.down.left.colony == null)
                             || (this.down.right != null && this.down.right.colony == null);
        }
        middleNeighbors = (this.left != null && this.left.colony == null)
                          || (this.right != null && this.right.colony == null);
        return upperNeighbors || middleNeighbors || lowerNeighbors;
    }

    /**
     * Returns a randomly selected neighbor field out of this field's 8-neighborhood that is not yet occupied by bugs
     * 
     * Preconditions: All field pointers (left, right, up and down) are properly initialized, i.e. != null
     * unless this field is an edge field where some neighbors might not exist. 
     * Postconditions: Randomly selected existing neighbor returned
     * 
     * @return a randomly selected neighboring field of this field that is not null and has no bug colony set
     */
    public ForestField getRandomFreeNeighbor() {
        int rand = (int) Math.random() * 8;
        ForestField retVal = null;
        do {
            switch (rand) {
                case 0:
                    retVal = (this.up != null) ? this.up.left : null;
                    break;
                case 1:
                    retVal = this.up;
                    break;
                case 2:
                    retVal = (this.up != null) ? this.up.right : null;
                    break;
                case 3:
                    retVal = this.right;
                    break;
                case 4:
                    retVal = (this.down != null) ? this.down.right : null;
                    break;
                case 5:
                    retVal = this.down;
                    break;
                case 6:
                    retVal = (this.down != null) ? this.down.left : null;
                    break;
                case 7:
                    retVal = this.left;
                    break;
                default:
                    // should not happen
                    throw new IllegalStateException("Not expected random number: " + rand);
            }
            rand = (int) Math.random() * 8;
        } while (retVal == null || retVal.colony != null);
        return retVal;
    }

    /**
     * Returns a randomly selected field out of this field's neighborhood
     * 
     * Preconditions: All field pointers (left, right, up and down) are properly initialized, i.e. != null
     * unless this field is an edge field where some neighbors might not exist. 
     * Postconditions: Randomly selected existing neighbor
     * 
     * @return Randomly selected existing neighbor
     */
    public ForestField getRandomNeighbor(){
        int rand = (int) Math.random() * 8;
        ForestField retVal = null;
        do {
            switch (rand) {
                case 0:
                    retVal = (this.up != null) ? this.up.left : null;
                    break;
                case 1:
                    retVal = this.up;
                    break;
                case 2:
                    retVal = (this.up != null) ? this.up.right : null;
                    break;
                case 3:
                    retVal = this.right;
                    break;
                case 4:
                    retVal = (this.down != null) ? this.down.right : null;
                    break;
                case 5:
                    retVal = this.down;
                    break;
                case 6:
                    retVal = (this.down != null) ? this.down.left : null;
                    break;
                case 7:
                    retVal = this.left;
                    break;
                default:
                    // should not happen
                    throw new IllegalStateException("Not expected random number: " + rand);
            }
            rand = (int) Math.random() * 8;
        } while (retVal == null);
        return retVal;        
    }
    
    /**
     * Preconditions: All field pointers (left, right, up and down) are properly initialized, i.e. != null
     * unless this field is an edge field where some neighbors might not exist.
     * <p>
     * Postconditions: All healthy neighbors are counted.
     *
     * @return number of healthy neighbors
     */
    public int getNumHealthyNeighbors() {
        int cntHealthyNeighbors = 0;

        if (this.up != null) {
            if (this.up.getColony() != null) {
                if (this.up.getColony().isHealthy()) {
                    cntHealthyNeighbors++;
                }
            }
            if (this.up.left != null) {
                if (this.up.left.getColony() != null) {
                    if (this.up.left.getColony().isHealthy()) {
                        cntHealthyNeighbors++;
                    }
                }
            }
            if (this.up.right != null) {
                if (this.up.right.getColony() != null) {
                    if (this.up.right.getColony().isHealthy()) {
                        cntHealthyNeighbors++;
                    }
                }
            }
        }
        if (this.left != null) {
            if (this.left.getColony() != null) {
                if (this.left.getColony().isHealthy()) {
                    cntHealthyNeighbors++;
                }
            }
        }
        if (this.down != null) {
            if (this.down.getColony() != null) {
                if (this.down.getColony().isHealthy()) {
                    cntHealthyNeighbors++;
                }
            }
            if (this.down.left != null) {
                if (this.down.left.getColony() != null) {
                    if (this.down.left.getColony().isHealthy()) {
                        cntHealthyNeighbors++;
                    }
                }
            }
            if (this.down.right != null) {
                if (this.down.right.getColony() != null) {
                    if (this.down.right.getColony().isHealthy()) {
                        cntHealthyNeighbors++;
                    }
                }
            }
        }
        if (this.right != null) {
            if (this.right.getColony() != null) {
                if (this.right.getColony().isHealthy()) {
                    cntHealthyNeighbors++;
                }
            }
        }

        return cntHealthyNeighbors;
    }

    /**
     * Preconditions: All field pointers (left, right, up and down) are properly initialized, i.e. != null
     * unless this field is an edge field where some neighbors might not exist.
     * <p>
     * Postconditions: All healthy neighbors are counted.
     *
     * @return number of healthy neighbors
     */
    public List<ForestField> getHealthyNeighbors() {
        List<ForestField> retVal = new ArrayList<>();

        if (this.up != null) {
            if (this.up.getColony() != null) {
                if (this.up.getColony().isHealthy()) {
                    retVal.add(this.up);
                }
            }
            if (this.up.left != null) {
                if (this.up.left.getColony() != null) {
                    if (this.up.left.getColony().isHealthy()) {
                        retVal.add(this.up.left);
                    }
                }
            }
            if (this.up.right != null) {
                if (this.up.right.getColony() != null) {
                    if (this.up.right.getColony().isHealthy()) {
                        retVal.add(this.up.right);
                    }
                }
            }
        }
        if (this.left != null) {
            if (this.left.getColony() != null) {
                if (this.left.getColony().isHealthy()) {
                    retVal.add(this.left);
                }
            }
        }
        if (this.down != null) {
            if (this.down.getColony() != null) {
                if (this.down.getColony().isHealthy()) {
                    retVal.add(this.down);
                }
            }
            if (this.down.left != null) {
                if (this.down.left.getColony() != null) {
                    if (this.down.left.getColony().isHealthy()) {
                        retVal.add(this.down.left);
                    }
                }
            }
            if (this.down.right != null) {
                if (this.down.right.getColony() != null) {
                    if (this.down.right.getColony().isHealthy()) {
                        retVal.add(this.down.right);
                    }
                }
            }
        }
        if (this.right != null) {
            if (this.right.getColony() != null) {
                if (this.right.getColony().isHealthy()) {
                    retVal.add(this.right);
                }
            }
        }

        return retVal;
    }
    
    
    /**
     * Preconditions: All field pointers (left, right, up and down) are properly initialized, i.e. != null
     * unless this field is an edge field where some neighbors might not exist.
     * <p>
     * Postconditions: All infected neighbors are counted.
     *
     * @return number of infected neighbors
     */
    public int getNumInfectedNeighbors() {
        int cntInfectedNeighbors = 0;

        if (this.up != null) {
            if (this.up.getColony() != null) {
                if (!this.up.getColony().isHealthy()) {
                    cntInfectedNeighbors++;
                }
            }
            if (this.up.left != null) {
                if (this.up.left.getColony() != null) {
                    if (!this.up.left.getColony().isHealthy()) {
                        cntInfectedNeighbors++;
                    }
                }
            }
            if (this.up.right != null) {
                if (this.up.right.getColony() != null) {
                    if (!this.up.right.getColony().isHealthy()) {
                        cntInfectedNeighbors++;
                    }
                }
            }
        }
        if (this.left != null) {
            if (this.left.getColony() != null) {
                if (!this.left.getColony().isHealthy()) {
                    cntInfectedNeighbors++;
                }
            }
        }
        if (this.down != null) {
            if (this.down.getColony() != null) {
                if (!this.down.getColony().isHealthy()) {
                    cntInfectedNeighbors++;
                }
            }
            if (this.down.left != null) {
                if (this.down.left.getColony() != null) {
                    if (!this.down.left.getColony().isHealthy()) {
                        cntInfectedNeighbors++;
                    }
                }
            }
            if (this.down.right != null) {
                if (this.down.right.getColony() != null) {
                    if (!this.down.right.getColony().isHealthy()) {
                        cntInfectedNeighbors++;
                    }
                }
            }
        }
        if (this.right != null) {
            if (this.right.getColony() != null) {
                if (!this.right.getColony().isHealthy()) {
                    cntInfectedNeighbors++;
                }
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
