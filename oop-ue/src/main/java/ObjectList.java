/**
 * @author Christoph Huber
 */
public class ObjectList {

    private ObjectListNode head = null;

    /**
     *
     * @param elem das einzufuegende Element in die "Liste"
     *
     */
    void insert(Object elem){
        if(elem == null){
            throw new NullPointerException("Das einzufuegende Element ist null und nicht erlaubt");
        }else{
            if(head == null)
                this.head = new ObjectListNode(elem);
            else if (!(contains(elem))) {
                ObjectListNode tmp = head;
                this.head = new ObjectListNode(elem);
                this.head.next = tmp;
            }
        }
    }

    public ObjectListNode getHead(){
        return this.head;
    }


    static class ObjectListNode{
        private ObjectListNode next=null;
        private Object value;

        public ObjectListNode(Object value){
            this.value = value;
        }

        public ObjectListNode getNext(){
            return this.next;
        }
    }

    /**
     *  Die Methode überprüft, ob das übergebene Element bereits in der "Liste" vorhanden ist.
     *
     * @param elem
     *          vom Typ Object
     *
     * @return true, falls das übergebene Element schon vorhanden ist, ansonsten false
     */
    boolean contains(Object elem){
        ObjectListNode cur = head;
        while((cur.getNext() != null)){
            if(cur.equals(elem)){
                return true;
            }
            else{
                cur = cur.getNext();
            }
        }
        return false;
    }

}
