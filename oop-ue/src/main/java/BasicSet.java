import java.util.Iterator;



public class BasicSet<T> implements Iterable<T>{

    protected ListElem<T> head;
    
    @Override
    public Iterator<T> iterator() {
        
        Iterator<T> tmp = new BasicSetIterator();
        return tmp;
    }
    
    public void add(T elem) {
        if (head == null) {
            head = new ListElem<T>(elem);
        }
        else {
            ListElem<T> last = head;
            for (ListElem<T> tmp = head; tmp.getNext() != null; tmp = tmp.getNext()) {
                if (tmp.getValue() == elem){
                    return;
                }
                last = tmp;
            }
            last.setNext(new ListElem(elem));
        }
        
        
    }
    
    protected static class ListElem<T> {
        
        private ListElem<T> next;
        private T value;
        
        public ListElem(T val){
        	this.value = val;
        }
        
        public T getValue(){
        	return this.value;
        }
        
        public ListElem<T> getNext(){
        	return this.next;
        }
        
        public void setNext(ListElem<T> next){
        	this.next = next;
        }
        
    }
    
    private class BasicSetIterator implements Iterator<T>{

        private ListElem<T> currentElem = head;
        private ListElem<T> priviousElem = null;
        
        @Override
        public boolean hasNext() {
            return currentElem.next != null;
        }

        @Override
        public T next() {
            priviousElem = currentElem;
            currentElem = currentElem.next;
            return priviousElem.value;
        }
        
        public void remove() {
            priviousElem.next = currentElem.next;
        }
        
    }
    
    public String toString() {
        
        StringBuilder result = new StringBuilder();
        for(T tmp : this) {
            result.append(tmp.toString());
        }
        
        return result.toString();
    }

}
