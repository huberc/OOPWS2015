/**
 * Unterklasse von Dachstuhl
 * stellt einen Dachstuhl eines Wohnbaues aus Stein dar
 */

import java.util.ArrayList;
import java.util.List;

public class SteinWohnbauDachstuhl extends Dachstuhl{

    // Liste von gehobeltem Kantholz zur Verwaltung der im Dachstuhl verwendeten/gebrauchten Stuecke Bauholz
    private List<KantholzGehobelt> kantholzGehobeltList = new ArrayList<>();

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
     * VB: kantholzGehobeltList wurde initialisiert
     * NB: kantholzGehobeltList wurde zurueckgegeben
     * @return  Liste mit allen Stuecken gehobelten Kantholzes die diesem Dachstuhl bereits ueber die get-Methode
     *          (in BauholzLager) hinzugefuegt wurden
     */
    public List<KantholzGehobelt> getHolz() {
        return kantholzGehobeltList;
    }

    /**
     * VB: kantholzGehobeltList wurde initialisiert, kantholzGehobelt ist nicht null
     * NB: kantholzGehobelt wurde der Liste kantholzGehobeltList hinzugefuegt
     * @param kantholzGehobelt  Stueck gehobelten Kantholzes das kantholzGehobeltList hinzugefuegt werden soll
     */
    public void add(KantholzGehobelt kantholzGehobelt){
        this.kantholzGehobeltList.add(kantholzGehobelt);
    }
}
