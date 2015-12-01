/**
 * Unterklasse von Bauholz
 * fuer Dachstuehle von Steinbauten benoetigt
 */
public abstract class Kantholz extends Bauholz{
    
    // Breite und Hoehe dieses Stueckes Kantholzes
    private int breite;
    private int hoehe;

    /**
     * Erstellen eines neuen Stueckes Kantholz
     * VB: laenge, preis, breite, hoehe sind nicht null
     * NB: ein neues Stueck Kantholz mit den uebergebenen Parametern wurde erzeugt
     * @param laenge    Laenge des zu erzeugenden Kantholzes
     * @param preis     Preis des zu erzeugenden Kantholzes
     * @param breite    Breite des zu erzeugenden Kantholzes
     * @param hoehe     Hoehe des zu erzeugenden Kantholzes
     */
    public Kantholz(int laenge, int preis, int breite, int hoehe) {
        super(laenge, preis);
        this.breite = breite;
        this.hoehe = hoehe;
    }
}
