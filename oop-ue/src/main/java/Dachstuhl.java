import java.util.List;

public abstract class Dachstuhl {

    /**
     * VB: bauholzLager ist nicht null
     * NB: ein fuer diesen Dachstuhl passendes Bauholz (oder null, wenn kein passendes im bauholzLager vorhanden ist) wurde zurueckgegeben
     * @param bauholzLager  BauholzLager von dem passendes Bauholz fuer diesen Dachstuhl gesucht wird
     * @return  Bauholz aus dem bauholzLager, das den Anforderungen dieses Dachstuhls entspricht
     */
    public abstract Bauholz get(BauholzLager bauholzLager);

    /**
     * VB: Liste wurde initialisiert
     * NB: Liste mit Stuecken von Bauholz die dieser Dachstuhl enthaehlt wurde zurueckgegeben
     * @return Liste mit Stuecken von Bauholz die dieser Dachstuhl enthaehlt
     */
    public abstract List<? extends Bauholz> getHolz();

}
