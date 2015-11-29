/**
 * Created by Christoph on 29.11.2015.
 */
public abstract class Kantholz extends Bauholz{
    
    private int breite;
    private int hoehe;

    public Kantholz(int laenge, int preis, int breite, int hoehe) {
        super(laenge, preis);
        this.breite = breite;
        this.hoehe = hoehe;
    }
}
