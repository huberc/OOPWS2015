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
            ListElem<T> tmp = head;
            for (;tmp.getNext() != null; tmp = tmp.getNext()) {
                if (tmp.getValue() == elem){
                    return;
                }
            }
            tmp.setNext(new ListElem<T>(elem));
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

        private ListElem<T> nextElem = head;
        private ListElem<T> previousElem = null;
        
        @Override
        public boolean hasNext() {
            return nextElem != null;
        }

        @Override
        public T next() {
            T retVal = nextElem.value;
            previousElem = nextElem;
            nextElem = nextElem.next;
            return retVal;
        }
        
        public void remove() {
            previousElem.setNext((nextElem != null) ? nextElem.getNext() : null);
        }
        
    }
    
    public String toString() {
        
        StringBuilder result = new StringBuilder();
        for(T tmp : this) {
            result.append(tmp.toString()+"\t");
        }
        return result.toString();
    }

}
