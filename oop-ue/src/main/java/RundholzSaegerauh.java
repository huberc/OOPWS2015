/**
 * Unterklasse von Rundholz (und Bauholz)
 * fuer Dachstuehle von Nutzholzbauten benoetigt
 */
public class RundholzSaegerauh extends Rundholz {

    /**
     * Erstellen eines neuen Stueckes saegerauhen Rundholzes
     * VB: laenge, preis, durchmesser sind nicht null
     * NB: ein neues Stueck saegerauhen Rundholzes mit den uebergebenen Parametern wurde erzeugt
     * @param laenge    Laenge des zu erzeugenden Stueckes saegerauhen Rundholzes
     * @param preis     Preis des zu erzeugenden Stueckes saegerauhen Rundholzes
     * @param durchmesser    Breite des zu erzeugenden Stueckes saegerauhen Rundholzess
     */
    public RundholzSaegerauh(int laenge, int preis, int durchmesser) {
        super(laenge, preis, durchmesser);
    }

    /**
     * lagert dieses Stueck saegrauhen Rundholzes im uebergebenem bauholzLager ein
     * VB: bauholzLager ist nicht null
     * NB: dieses Stueck saegerauhen Rundholzes wurde dem bauholzLager hinzugefuegt
     * @param bauholzLager  Bauholzlager wo dieses Stueck saegerauhen Rundholzes hinzugefuegt werden soll
     */
    public void add(BauholzLager bauholzLager){
        bauholzLager.add(this);
    }

}
