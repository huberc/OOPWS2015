/**
 * @author Christoph Huber
 */
public class CustomList {

    private CustomListNode head = null;

    /**
     * VB: elem darf nicht null sein NB: elem ist Bestandteil der Liste
     *
     * @param elem
     *            das einzufuegende Element in die "Liste"
     */
    public void insert(Listable elem) {

        if (head == null)
            this.head = new CustomListNode(elem);
        else if (!(contains(elem))) {
            if (head.getValue() instanceof Holzvollernter) {
                if (elem instanceof Holzvollernter) {
                    internInster(elem);
                }
            } else if (head.getValue() instanceof Forstbetrieb) {
                if (elem instanceof Forstbetrieb) {
                    internInster(elem);
                }
            } else if (head.getValue() instanceof KeyValueListable) {
                if (elem instanceof KeyValueListable) {
                    internInster(elem);
                }
            } else if (head.getValue() instanceof StringListable) {
                if (elem instanceof StringListable) {
                    internInster(elem);
                }
            }
        }

    }

    private void internInster(Listable elem) {
        CustomListNode tmp = head;
        this.head = new CustomListNode(elem);
        this.head.next = tmp;
    }

    /**
     * VB: name darf nicht null sein NB: null oder das entsprechende Objekt wird dem Client zurueckgegeben.
     *
     * @param name
     *            String in der Liste
     * @return Object oder null fals der Name nicht vorhanden ist
     */
    public Listable removeByName(String name) {
        if (this.isEmpty()) {
            return null;
        }

        if(this.head.next == null){
            // nur ein Element in der Liste
            Listable retVal = this.head.getValue();
            this.head = null;
            return retVal;
        }
        
        CustomListNode cur = head.next;
        CustomListNode tmp = head;
        
        while (cur != null) {
            if (cur.value.getName().equals(name)) {
                tmp.next = cur.next;
                return cur.value;
            } else {
                tmp = cur;
                cur = cur.next;
            }
        }
        return null;
    }

    public Listable getElement(String name) {
        if (this.isEmpty()) {
            return null;
        }

        CustomListNode cur = head;

        while (cur != null) {
            if (cur.getValue().getName().equals(name)) {
                return cur.getValue();
            } else {
                cur = cur.next;
            }
        }
        return null;
    }

    public CustomListNode getHead() {
        return this.head;
    }

    class CustomListNode {

        private CustomListNode next = null;
        private Listable       value;

        public CustomListNode(Listable value) {
            this.value = value;
        }

        public CustomListNode getNext() {
            return this.next;
        }

        public Listable getValue() {
            return this.value;
        }
    }

    /**
     * Die Methode ueberprueft, ob das uebergebene Element bereits in der "Liste" vorhanden ist.
     * <p>
     * VB: elem darf nicht null sein
     *
     * @param elem
     *            vom Typ Listable
     * @return true, falls das uebergebene Element schon vorhanden ist, ansonsten false
     */
    public boolean contains(Listable elem) {
        if (head == null) {
            return false;
        }

        CustomListNode cur = head;
        while ((cur != null)) {
            if (cur.getValue().equals(elem)) {
                return true;
            } else {
                cur = cur.next;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        if (this.head == null)
            return true;
        else
            return false;
    }

}
