/**
 * @author Christoph Huber e1427322@student.tuwien.ac.at
 */
public abstract class Bauholz implements Smaller<Bauholz> {

    private int length;

    public Bauholz(int length){
        this.length = length;
    }

    abstract double festmeter();

    public int getLength() {
        return length;
    }

    @Override
    public abstract String toString();
}
