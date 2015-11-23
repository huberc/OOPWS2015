/**
 * Created by Christoph on 23.11.2015.
 */
public class StringListable implements Listable {

    private String value;

    public StringListable(String value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Holzvollernter)) {
            return false;
        }
        return ((StringListable) o).getName().equals(this.getName());
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }
    
}
