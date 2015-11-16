/**
 * 
 * @author Michael Langowski, e1426581@student.tuwien.ac.at
 *
 * @param <T>
 */
public class SortedSet<T extends Smaller<? super T>> extends BasicSet<T> {

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

		// if(this.head.getNext() == null){
		// if(value.smaller(this.head.getValue())){
		// elem.setNext(this.head);
		// this.head = elem;
		// }else{
		// this.head.setNext(elem);
		// }
		// return;
		// }
		// ListElem<T> current = this.head;
		// while(current != null){
		// if(value.smaller(current.getValue())){
		// if(current.getNext() == null ||
		// current.getNext().getValue().smaller(value)){
		// // insert here
		// elem.setNext(current.getNext());
		// current.setNext(elem);
		// break;
		// }
		// current = current.getNext();
		// }
		// }
	}

}
