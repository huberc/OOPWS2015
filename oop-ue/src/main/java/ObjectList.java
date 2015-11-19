/**
 * @author Christoph Huber
 */
public class ObjectList {

    private ObjectListNode head = null;

    /**
     * VB: elem darf nicht null sein
     * NB: elem ist Bestandteil der Liste
     *
     * @param elem das einzufuegende Element in die "Liste"
     */
    void insert(Object elem) {

        if (head == null)
            this.head = new ObjectListNode(elem);
        else if (!(contains(elem))) {
            ObjectListNode tmp = head;
            this.head = new ObjectListNode(elem);
            this.head.next = tmp;
        }

    }


    /**
     * VB: name darf nicht null sein
     * NB: null oder das entsprechende Objekt wird dem Client zurueckgegeben.
     *
     * @param name String in der Liste
     * @return Object oder null fals der Name nicht vorhanden ist
     */
    Object removeByName(String name){

        ObjectListNode cur = head;

        while (cur.next != null){
            if(cur.value.equals(name)){
                return cur.value;
            }
            else{
                cur = cur.next;
            }
        }
        return null;
    }


    public ObjectListNode getHead() {
        return this.head;
    }


    class ObjectListNode {
        private ObjectListNode next = null;
        private Object value;

        public ObjectListNode(Object value) {
            this.value = value;
        }
    }

    /**
     * Die Methode ueberprueft, ob das uebergebene Element bereits in der "Liste" vorhanden ist.
     *
     * VB: elem darf nicht null sein
     *
     * @param elem vom Typ Object
     * @return true, falls das uebergebene Element schon vorhanden ist, ansonsten false
     */
    boolean contains(Object elem) {
        ObjectListNode cur = head;
        while ((cur.next != null)) {
            if (cur.equals(elem)) {
                return true;
            } else {
                cur = cur.next;
            }
        }
        return false;
    }

}
