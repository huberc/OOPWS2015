/**
 * @author Christoph Huber e1427322@student.tuwien.ac.at
 */
public class Baukantholz extends Bauholz{

    private int width, height;

    public Baukantholz(int length, int width, int height) {
        super(length);
        this.width = width;
        this.height = height;
    }

    @Override
    double festmeter() {
        return Double.valueOf(this.getLength() * height * width);
    }

    @Override
    public String toString() {
        return "Baukantholz{\n" +
                "\t\tLaenge:\t\t"+ this.getLength()+ "\n"+
                "\t\tHoehe:\t\t" + height + "\n" +
                "\t\tBreite:\t\t" + width +"\n"+
                "\t\tFestmeter:\t"+ this.festmeter()+"\n"+
                "\t}\n";
    }

    @Override
    public boolean smaller(Bauholz other) {
        if(this.festmeter() < other.festmeter())
            return true;
        else
            return false;
    }
}
