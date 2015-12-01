/**
 * Unterklasse von Rundholz (und Bauholz)
 * fuer Dachstuehle von Wohnholzbauten benoetigt (ggf. auch fuer Nutzholzbauten)
 */
public class RundholzGehobelt extends Rundholz {

    /**
     * Erstellen eines neuen Stueckes gehobelten Rundholzes
     * VB: laenge, preis, durchmesser sind nicht null
     * NB: ein neues Stueck gehobelten Rundholzes mit den uebergebenen Parametern wurde erzeugt
     * @param laenge    Laenge des zu erzeugenden Stueckes gehobelten Rundholzes
     * @param preis     Preis des zu erzeugenden Stueckes gehobelten Rundholzes
     * @param durchmesser    Breite des zu erzeugenden Stueckes gehobelten Rundholzess
     */
    public RundholzGehobelt(int laenge, int preis, int durchmesser) {
        super(laenge, preis, durchmesser);
    }

    public void add(BauholzLager l){
        l.add(this);
    }
}
