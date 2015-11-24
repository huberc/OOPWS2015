/**
 * Eine Unterklasse von Listable um eine Liste aus Strings bilden zu koennen.
 *
 * @author Christoph Huber
 */
public class StringListable implements Listable {

    private String value;

    /**
     * Erzeugen eines neuen StringListable
     *
     * VB: value ist nicht null
     * NB: ein neues StringListable mit dem gegebenem value wurder erzeugt
     * @param value
     */
    public StringListable(String value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StringListable)) {
            return false;
        }
        return ((StringListable) o).getName().equals(this.getName());
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }
    
}
