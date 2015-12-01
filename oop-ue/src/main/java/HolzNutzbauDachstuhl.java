/**
 * Unterklasse von Dachstuhl
 * stellt einen Dachstuhl eines Nutzbaues aus Holz dar
 */

import java.util.ArrayList;
import java.util.List;

public class HolzNutzbauDachstuhl extends Dachstuhl{

    // Liste von Rundholz zur Verwaltung der im Dachstuhl verwendeten/gebrauchten Stuecke Bauholz
    private List<Rundholz> rundholzList = new ArrayList<>();

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
     * VB: rundholzList wurde initialisiert
     * NB: rundholzList wurde zurueckgegeben
     * @return  Liste mit allen Stuecken Rundholz die diesem Dachstuhl bereits ueber die get-Methode (in BauholzLager)
     *          hinzugefuegt wurden
     */
    public List<Rundholz> getHolz() {
        return rundholzList;
    }

    /**
     * VB: rundholzList wurde initialisiert, rundholz ist nicht null
     * NB: rundholz wurde der Liste rundholzList hinzugefuegt
     * @param rundholz  Stueck Rundholz das rundholzList hinzugefuegt werden soll
     */
    public void add(Rundholz rundholz){
        rundholzList.add(rundholz);
    }
}
