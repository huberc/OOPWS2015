/**
 * Unterklasse von Bauholz
 * fuer Dachstuehle von Holzbauten benoetigt
 */
public abstract class Rundholz extends Bauholz{
    
    // Durchmesser dieses Stueck Rundholzes
    private int durchmesser;

    /**
     * Erstellen eines neuen Stueckes Rundholzes
     * VB: laenge, preis, durchmesser sind nicht null
     * NB: ein neues Stueck Rundholz mit den uebergebenen Parametern wurde erzeugt
     * @param laenge    Laenge des zu erzeugenden Rundholzes
     * @param preis     Preis des zu erzeugenden Rundholzes
     * @param durchmesser   Durchmesser des zu erzeugenden Rundholzes
     */
    public Rundholz(int laenge, int preis, int durchmesser) {
        super(laenge, preis);
        this.durchmesser = durchmesser;
    }
}
