public class KeyValueListable implements Listable {

    private String key;
    private double value;

    public KeyValueListable(String key, double value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getName() {
        return this.key;
    }

    public String getKey() {
        return key;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof KeyValueListable)) {
            return false;
        }
        return this.getName().equals(((KeyValueListable) o).getName());
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

}
