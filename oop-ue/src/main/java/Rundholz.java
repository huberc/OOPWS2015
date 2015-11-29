/**
 * Created by Christoph on 29.11.2015.
 */
public abstract class Rundholz extends Bauholz{
    
    private int durchmesser;

    public Rundholz(int laenge, int preis, int durchmesser) {
        super(laenge, preis);
        this.durchmesser = durchmesser;
    }
}
