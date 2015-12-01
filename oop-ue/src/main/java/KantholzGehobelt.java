/**
 * Unterklasse von Kantholz (und Bauholz)
 * fuer Dachstuehle von Wohnsteinbauten benoetigt (ggf. auch fuer Nutzsteinbauten)
 */
public class KantholzGehobelt extends Kantholz {

    /**
     * Erstellen eines neuen Stueckes gehobelten Kantholzes
     * VB: laenge, preis, breite, hoehe sind nicht null
     * NB: ein neues Stueck gehobelten Kantholzes mit den uebergebenen Parametern wurde erzeugt
     * @param laenge    Laenge des zu erzeugenden Stueckes gehobelten Kantholzes
     * @param preis     Preis des zu erzeugenden Stueckes gehobelten Kantholzes
     * @param breite    Breite des zu erzeugenden Stueckes gehobelten Kantholzes
     * @param hoehe     Hoehe des zu erzeugenden Stueckes gehobelten Kantholzes
     */
    public KantholzGehobelt(int laenge, int preis, int breite, int hoehe) {
        super(laenge, preis, breite, hoehe);
    }

    /**
     * lagert dieses Stueck gehobelten Kantholzes im uebergebenem bauholzLager ein
     * VB: bauholzLager ist nicht null
     * NB: dieses Stueck gehobelten Kantholzes wurde dem bauholzLager hinzugefuegt
     * @param bauholzLager  Bauholzlager wo dieses Stueck gehobelten Kantholzes hinzugefuegt werden soll
     */
    public void add(BauholzLager bauholzLager){
        bauholzLager.add(this);
    }
}
