/**
 * 
 * @author Ines
 *
 */
public abstract class AbstractTree {

	/**
	 * The age of a tree. (necessary for grow function)
     * tree height
     * diameter of the tree trunk in 1.3m height
	 * wood amount when state has been changed
	 */
	private int age;
	private double height;
	private double diameter;
	private double deathwood;

	/**
	 * Possible states of a tree. A living tree grows, a dead one rots.	 *
	 */
	public enum TreeState {
		LIVING, DEAD;
	}

	/**
	 * The current state of the tree
	 */
	private TreeState state = TreeState.LIVING;

	/**
	 * The amount of wood on this tree.
	 */
	private double wood;

	/**
	 * The percentage of wood from this tree that can be used when harvested.
	 * (e.g. thinner branches + base of the tree typically remain)
	 */
	private double useablePercentage;

	/**
	 * The space (in square meters) of ground floor this tress uses or shadows,
	 * i.e. an oak with a crown of 5 meters in width would have 5 here. Changes
	 * when the tree grows (assuming there is enough space available)
	 */
	private double usedSpace;

	/**
	 * Lets the tree grow. Growth is influenced by weather conditions, the
	 * tree's age and the space available (for the tree to grow in width). When
	 * a tree grows, it's <code>wood</code> and <code>usedSpace</code>
	 * properties change. Exact growth function is implementation-specific.
	 *
	 * @param weather
	 *            the current <code>WeatherConditions</code>
	 * @param spaceAvailable
	 *            the space (in square meters) by which this tree can grow
	 *            before touching another tree. If zero, the tree cannot grow in
	 *            width anymore (but may still grow in height, i.e. amount of
	 *            wood can still change)
	 */
	public abstract void grow(WeatherConditions weather, double spaceAvailable);

	/**
	 * Lets the tree "rot", i.e. the amount of wood reduces according to an
	 * implementation specific function. Note: For the sake of simplicity all
	 * trees rot according to the same function
	 */
	public void rot() {
		this.age++;
		this.setWood(this.getDeathwood()
				* Math.pow(Math.E, -0.1 * this.getAge()));
	}

    /**
     * Lets the trees be "harvested" (changes state and wood of tree).
     * The remaining wood is the amount which couldn't be harvested (branches and stub).
     * @return the amount of harvested wood (profit bringing wood)
     */
	public double harvest() {
		this.state = TreeState.DEAD;
		double retVal = this.useablePercentage * this.wood;
		this.wood = this.wood - retVal;
		this.deathwood = this.wood;
		this.usedSpace = 0;
		this.age = 0; // to hit start point of rot function
		return retVal;
	}

	/** 
     * BAD: This method was initially planned to be used for e.g. natural events such as thunderstorms.
     * As this feature was not implemented, the method should be deleted.
	 */
    public void destroy() {
		// NOTE: assumption: if a tree is destroyed,
		// the percentage of dead wood remaining is the same as when it is
		// harvested
		this.harvest();
	}

	public TreeState getState() {
		return state;
	}

	public double getWood() {
		return wood;
	}

	public double getUseablePercentage() {
		return useablePercentage;
	}

	public double getUsedSpace() {
		return usedSpace;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public double getDeathwood() {
		return deathwood;
	}

	public void setDeathwood(double deathwood) {
		this.deathwood = deathwood;
	}

	public void setState(TreeState state) {
		this.state = state;
	}

	public void setWood(double wood) {
		this.wood = wood;
	}

	public void setUseablePercentage(double useablePercentage) {
		this.useablePercentage = useablePercentage;
	}

	public void setUsedSpace(double usedSpace) {
		this.usedSpace = usedSpace;
	}
}
