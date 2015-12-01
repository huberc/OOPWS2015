/**
 * Unterklasse von Dachstuhl
 * stellt einen Dachstuhl eines Wohnbaues aus Holz dar
 */
import java.util.ArrayList;
import java.util.List;

public class HolzWohnbauDachstuhl extends Dachstuhl{

    // Liste von gehobeltem Rundholz zur Verwaltung der im Dachstuhl verwendeten/gebrauchten Stuecke Bauholz
    private List<RundholzGehobelt> gehobeltList = new ArrayList<>();

    /**
     * VB: bauholzLager ist nicht null
     * NB: ein passendes Bauholz fuer diesen Dachstuhl aus dem uebergebenem Lager wurde zuruckgegeben
     * (oder null wenn keines vorhanden ist)
     * @param bauholzLager  BauholzLager von dem ein passendes Bauholz fuer diesen Dachstuhl gesucht wird
     * @return  passendes Bauholz aus dem uebergebenem Lager (oder null, wenn keines vorhanden ist), das
     *          fuer diesen Dachstuhl (dieses Objekt) passt
     */
    public Bauholz get(BauholzLager bauholzLager) {
        return bauholzLager.get(this);
    }

    /**
     * VB: gehobeltList wurde initialisiert
     * NB: gehobeltList wurde zurueckgegeben
     * @return  Liste mit allen Stuecken gehobelten Rundholzes die diesem Dachstuhl bereits ueber die get-Methode
     *          (in BauholzLager) hinzugefuegt wurden
     */
    public List<RundholzGehobelt> getHolz() {
        return gehobeltList;
    }

    /**
     * VB: gehobeltList wurde initialisiert, rundholzGehobelt ist nicht null
     * NB: rundholzGehobelt wurde der Liste gehobeltList hinzugefuegt
     * @param rundholzGehobelt  Stueck gehobelten Rundholzes das gehobeltList hinzugefuegt werden soll
     */
    public void add(RundholzGehobelt rundholzGehobelt){
        gehobeltList.add(rundholzGehobelt);
    }
}
