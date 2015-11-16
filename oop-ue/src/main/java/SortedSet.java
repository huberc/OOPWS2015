/**
 * 
 * Aufsteigend sortierte Single-Linked-List
 * 
 * @author Michael Langowski, e1426581@student.tuwien.ac.at
 *
 * @param <T>
 */
public class SortedSet<T extends Smaller<? super T>> extends BasicSet<T> {

	/**
	 * Fuegt ein Element so ein, dass die Liste aufsteigend sortiert bleibt.
	 * Nachdem kein Schreibzugriff ausser ueber add moeglich ist ist damit die
	 * korrekte Reihenfolge im Iterator gesichert.
	 */
	@Override
	public void add(T value) {
		ListElem<T> elem = new ListElem<>(value);
		if (this.head == null) {
			this.head = elem;
			return;
		}
		ListElem<T> previous = null;
		ListElem<T> current = this.head;
		do {
			if (!(current.getValue().smaller(value))) {
				elem.setNext(current);
				if (previous != null) {
					previous.setNext(elem);
				} else {
					this.head = elem;
				}
				return;
			}
			previous = current;
			current = current.getNext();
		} while (current != null);
		// element must be added at last position
		previous.setNext(elem);
	}

}
