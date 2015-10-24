import java.util.List;
import java.util.Map;

/**
 * 
 * @author Ines
 *
 */
public class Forest implements Cloneable {

	private List<AbstractTree> trees;

	// @Ines - Eventuell hier statt der Liste eine Map verwenden (nachdem ja
	// harvest und plant types verwenden), zB:
	// Map<Class<? extends AbstractTree>, List<? extends AbstractTree>> trees;

	/**
	 * The size of the forest (in square meters)
	 */
	private double forestSize;

	/**
	 * The percentage of space on the forest floor that is shadowed by trees.
	 * Assumption for shadowing is the exact mid of day at equatorial latitude,
	 * i.e. the sun comes from directly above and the space shadowed by an
	 * individual tree is exactly it's <code>spaceUsed</code> property.
	 */
	private double percentGroundShadowed;

	/**
	 * Lets the wood grow.
	 * 
	 * @param weather
	 *            the <code>WeatherConditions</code> of the current simulation
	 *            year
	 */
	public void grow(WeatherConditions weather) {
		// TODO
	}

	/**
	 * Harvests trees from the forest.
	 * 
	 * @param numTrees
	 *            the number of trees to harvest
	 * @param preferredType
	 *            the preferred type to harvest. If no (or not enough trees of
	 *            the specified type exist), any tree can be harvested
	 * @return the amount of wood harvested (that can be actually used, i.e. not
	 *         including wood that remains as dead wood in the forest)
	 */
	public double harvestTrees(int numTrees,
			Class<? extends AbstractTree> preferredType) {
		// TODO
		return 0.0;
	}

	/**
	 * Destroys trees (e.g. as a result of a thunderstorm etc)
	 * 
	 * @param numTrees
	 *            the number of trees to destroy
	 */
	public void destroyTrees(int numTrees) {
		// TODO
		// to be called when trees are destroyed, e.g. by lightning strikes
	}

	/**
	 * Plants new trees in the forest
	 * 
	 * @param numTrees
	 *            the number of trees to plant
	 * @param type
	 *            the type of trees to plant
	 */
	public void plantTrees(int numTrees, Class<? extends AbstractTree> type) {
		// TODO
		// @Ines: Basierend auf einer Class Bäume dieses Types erzeugen geht wie
		// folgt:
		// AbstractTree t = type.getDeclaredConstructor(null).newInstance(null)
		// siehe auch java API
		// https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html
	}

	/**
	 * Calculates the total amount of living wood (in cubic meters) in the
	 * forest
	 * 
	 * @return the added-up <code>wood</code> properties of all living trees
	 */
	public double getTotalLivingWood() {
		// TODO - sum of living trees
		return 0.0;
	}

	/**
	 * Calculates the total amount of dead wood in the forest
	 * 
	 * @return the added-up <code>wood</code> properties of all dead trees
	 */
	public double getTotalDeadWood() {
		// TODO - sum of currently rotting trees
		return 0.0;
	}

	/**
	 * Performs a deep copy of this <code>Forest</code>
	 */
	@Override
	public Forest clone() {
		// @Ines - hier musst nix machen, die brauch ich für den Test, schreib
		// ich mir dann selber
		return null;
	}

	/**
	 * Gets the number of living trees (by tree type) currently in the forest
	 * 
	 * @return the number of living trees (by tree type) currently in the forest
	 */
	public Map<Class<? extends AbstractTree>, Integer> getNumberOfTreesByType() {
		// TODO
		return null;
	}

	public double getForestSize() {
		return forestSize;
	}

	public double getPercentGroundShadowed() {
		return percentGroundShadowed;
	}
}
