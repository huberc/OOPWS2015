
public class ForestField {

	private BugColony colony;
	private ForestField left;
	private ForestField right;
	private ForestField up;
	private ForestField down;

	/**
	 * Verifies if all eight neighboring fields of this field are free in terms
	 * of not being infested by bugs. If the field is at the edge of the
	 * forest, i.e. has less than eight neighbors, the non-existing fields are
	 * counted as non-free.
	 * 
	 * Preconditions: All field pointers (left, right, up and down) are properly intitialized, i.e. != null unless
	 * this field is an edge field where some neighbors might not exist.
	 * Postconditions: All neighboring fields checked for existence of bug colonies on them
	 *
	 * @return true if no forestField in an 8-neighborhood of this field is occupied (field.getColony() == null), 
	 * false otherwise
	 */
	public boolean checkNeighborhoodFree() {
		boolean upperNeighbors =
				((this.up != null) && (this.up.colony == null)
				&& (this.up.left != null)) && (this.up.left.colony == null)
				&& (this.up.right != null) && (this.up.right.colony == null);
		boolean middleNeighbors =
				(this.left != null) && (this.left.colony == null)
				&& (this.right != null) && (this.right.colony == null);
		boolean lowerNeighbors =
				(this.down != null) && (this.down.colony == null)
				&& (this.down.left != null) && (this.down.left.colony == null)
				&& (this.down.right != null) && (this.down.right.colony == null);
		return upperNeighbors && middleNeighbors && lowerNeighbors;
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
