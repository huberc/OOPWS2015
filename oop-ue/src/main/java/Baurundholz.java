/**
 * @author Christoph Huber e1427322@student.tuwien.ac.at
 */
public class Baurundholz extends Bauholz{

    private int diameter;

    public Baurundholz(int length, int diameter) {
        super(length);
        this.diameter = diameter;
    }

    @Override
    double festmeter() {
        return Double.valueOf((Math.pow((Double.valueOf(diameter)/2),2)* Math.PI)*this.getLength());
    }

    @Override
    public String toString() {
        return "Baurundholz{\n" +
                "\t\tLaenge:\t\t"+ this.getLength()+ "\n"+
                "\t\tDurchmesser:\t" + diameter +"\n"+
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
