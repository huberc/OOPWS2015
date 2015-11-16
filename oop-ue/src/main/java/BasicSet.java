import java.util.Iterator;



public class BasicSet<T> implements Iterable<T>{

    private ListElem<T> head;
    
    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public void add(T elem) {
        
    }
    
    private static class ListElem<T> {
        
        private ListElem<T> next;
        private T value;
        
    }
    
    private class BasicSetIterator implements Iterator<T>{

        private ListElem<T> currentElem = head;
        
        @Override
        public boolean hasNext() {
            return currentElem.next != null;
        }

        @Override
        public T next() {
            ListElem<T> tmp = currentElem;
            currentElem = currentElem.next;
            return tmp.value;
        }
        
        public void remove() {
            
        }
        
    }

}
