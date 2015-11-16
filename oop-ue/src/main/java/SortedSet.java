/**
 * 
 * @author Michael Langowski, e1426581@student.tuwien.ac.at
 *
 * @param <T>
 */
public class SortedSet<T extends Smaller> extends BasicSet<T> {

	private TreeNode<T> root;
	
	/**
	 * 
	 * Binary search tree
	 * 
	 * @author Michael Langowski, e1426581@student.tuwien.ac.at
	 *
	 * @param <T>
	 */
	private static class TreeNode<T extends Smaller>{
		
		private T value;
		private TreeNode<T> left;
		private TreeNode<T> right;
		
		public void insert(T val){
			if(val.s)
		}
	}
}
