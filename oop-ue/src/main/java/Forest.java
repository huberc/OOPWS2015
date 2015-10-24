import java.util.List;
import java.util.Map;

/**
 * 
 * @author Ines
 *
 */
public class Forest {

	List<AbstractTree> trees;

	// @Ines - Eventuell hier statt der Liste eine Map verwenden (nachdem ja
	// harvest und plant types verwenden), zB:
	// Map<Class<? extends AbstractTree>, List<? extends AbstractTree>> trees;

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

	public double getTotalLivingWood() {
		// TODO - sum of living trees
		return 0.0;
	}

	public double getTotalDeadWood() {
		// TODO - sum of currently rotting trees
		return 0.0;
	}

	/**
	 * Gets the number of living trees (by tree type) currently in the forest
	 * 
	 * @return the number of living trees (by tree type) currently in the forest
	 */
	public Map<Class<? extends AbstractTree>, Integer> getNumberOfTreesByType() {
		return null;
	}
}
