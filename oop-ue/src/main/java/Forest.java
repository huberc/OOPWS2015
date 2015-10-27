import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * @author Ines
 *
 */
public class Forest implements Cloneable {

	/**
	 * Value to decide if a rotting (=dead) tree should be fully removed from
	 * the forest. If the tree's wood property is below this level, the tree is
	 * removed from the forest
	 */
	private static final double ROTTEN_TREE_REMOVE_TRESHOLD = 0.01;

	private Map<Class<? extends AbstractTree>, List<AbstractTree>> trees = new HashMap<>();

	public Forest(double sizeSqMeters,
			Map<Class<? extends AbstractTree>, Integer> trees) {
		this.forestSize = sizeSqMeters;
		for (Entry<Class<? extends AbstractTree>, Integer> entry : trees
				.entrySet()) {
			this.plantTrees(entry.getValue(), entry.getKey());
		}
		this.percentGroundShadowed = this.calculateShadowed();
	}

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
		Set<Entry<Class<? extends AbstractTree>, List<AbstractTree>>> mySet = trees
				.entrySet();
		List<AbstractTree> temp;
		double availableSpace = this.forestSize * (1 - percentGroundShadowed);
		List<AbstractTree> removeTreesList;
		for (Entry<Class<? extends AbstractTree>, List<AbstractTree>> t : mySet) {
			removeTreesList = new ArrayList<>();
			temp = t.getValue();
			for (AbstractTree i : temp) {
				if (i.getState() == AbstractTree.TreeState.LIVING) {
					i.grow(weather, availableSpace);
				} else {
					i.rot();
					if(i.getWood() <= Forest.ROTTEN_TREE_REMOVE_TRESHOLD){
						removeTreesList.add(i);
					}
				}
			}
			for(AbstractTree treeToRemove : removeTreesList){
				temp.remove(treeToRemove);
			}
		}
		this.percentGroundShadowed = this.calculateShadowed();
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
		double amount = 0;
		for (AbstractTree t : trees.get(preferredType)) {
			amount += t.harvest();
		}
		this.percentGroundShadowed = this.calculateShadowed();
		return amount;
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
		Constructor<? extends AbstractTree> treeConstructor = null;
		try {
			treeConstructor = type.getConstructor();
			for (int i = 0; i < numTrees; i++) {
				if (null == this.trees.get(type)) {
					this.trees.put(type, new ArrayList<>());
				}
				this.trees.get(type).add(treeConstructor.newInstance());
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Cannot plant trees of type "
					+ type.getName() + " -> exception is "
					+ e.getClass().getSimpleName() + ": " + e.getMessage());
		}
		this.percentGroundShadowed = calculateShadowed();
	}

	/**
	 * Calculates the total amount of living wood (in cubic meters) in the
	 * forest
	 * 
	 * @return the added-up <code>wood</code> properties of all living trees
	 */
	public double getTotalLivingWood() {
		Set<Entry<Class<? extends AbstractTree>, List<AbstractTree>>> mySet = trees
				.entrySet();
		List<AbstractTree> temp;
		double counter = 0;
		for (Entry<Class<? extends AbstractTree>, List<AbstractTree>> t : mySet) {
			temp = t.getValue();
			for (AbstractTree i : temp) {
				if (i.getState() == AbstractTree.TreeState.LIVING) {
					counter += i.getWood();
				}
			}
		}
		return counter;
	}

	/**
	 * Calculates the total amount of dead wood in the forest
	 * 
	 * @return the added-up <code>wood</code> properties of all dead trees
	 */
	public double getTotalDeadWood() {
		Set<Entry<Class<? extends AbstractTree>, List<AbstractTree>>> mySet = trees
				.entrySet();
		List<AbstractTree> temp;
		double counter = 0;
		for (Entry<Class<? extends AbstractTree>, List<AbstractTree>> t : mySet) {
			temp = t.getValue();
			for (AbstractTree i : temp) {
				if (i.getState() == AbstractTree.TreeState.DEAD) {
					counter += i.getWood();
				}
			}
		}
		return counter;
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
		Set<Entry<Class<? extends AbstractTree>, List<AbstractTree>>> mySet = trees
				.entrySet();
		Map<Class<? extends AbstractTree>, Integer> result = new HashMap<>();
		for (Entry<Class<? extends AbstractTree>, List<AbstractTree>> t : mySet) {
			result.put(t.getKey(), t.getValue().size());
		}
		return result;
	}

	public double getForestSize() {
		return this.forestSize;
	}

	private double calculateShadowed() {
		double usedSpace = 0.0;
		for (Entry<Class<? extends AbstractTree>, List<AbstractTree>> entry : this.trees
				.entrySet()) {
			for (AbstractTree t : entry.getValue()) {
				usedSpace += t.getUsedSpace();
			}
		}
		return usedSpace / this.forestSize;
	}

	public double getPercentGroundShadowed() {
		return percentGroundShadowed;
	}

}
