/**
 * 
 * @author Michael Langowski, e1426581@student.tuwien.ac.at
 *
 * @param <T>
 */
public class SortedSet<T extends Smaller<T>> extends BasicSet<T> {

	@Override
	public void add(T value) {
		ListElem<T> current = this.head;
		while(current != null){
			if(value.smaller(current.getValue())){
				if(current.getNext() == null || current.getNext().getValue().smaller(value)){
					// insert here
					ListElem<T> elem = new ListElem<>(value);
					elem.setNext(current.getNext());
					current.setNext(elem);
					break;
				}
				current = current.getNext();
			}
		}
	}

}
