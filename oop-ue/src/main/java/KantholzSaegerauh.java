/**
 * Unterklasse von Kantholz (und Bauholz)
 * fuer Dachstuehle von Nutzsteinbauten benoetigt
 */
public class KantholzSaegerauh extends Kantholz {

    /**
     * Erstellen eines neuen Stueckes saegerauhen Kantholzes
     * VB: laenge, preis, breite, hoehe sind nicht null
     * NB: ein neues Stueck saegerauhen Kantholzes mit den uebergebenen Parametern wurde erzeugt
     * @param laenge    Laenge des zu erzeugenden Stueckes saegerauhen Kantholzes
     * @param preis     Preis des zu erzeugenden Stueckes saegerauhen Kantholzes
     * @param breite    Breite des zu erzeugenden Stueckes saegerauhen Kantholzes
     * @param hoehe     Hoehe des zu erzeugenden Stueckes saegerauhen Kantholzes
     */
    public KantholzSaegerauh(int laenge, int preis, int breite, int hoehe) {
        super(laenge, preis, breite, hoehe);
    }

    /**
     * lagert dieses Stueck saegrauhen Kantholzes im uebergebenem bauholzLager ein
     * VB: bauholzLager ist nicht null
     * NB: dieses Stueck saegerauhen Kantholzes wurde dem bauholzLager hinzugefuegt
     * @param bauholzLager  Bauholzlager wo dieses Stueck saegerauhen Kantholzes hinzugefuegt werden soll
     */
    public void add(BauholzLager bauholzLager){
        bauholzLager.add(this);
    }
}
