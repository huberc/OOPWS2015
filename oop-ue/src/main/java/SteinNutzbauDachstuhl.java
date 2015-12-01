/**
 * Unterklasse von Dachstuhl
 * stellt einen Dachstuhl eines Nutzbaues aus Stein dar
 */

import java.util.ArrayList;
import java.util.List;

public class SteinNutzbauDachstuhl extends Dachstuhl{

    // Liste von Kantholz zur Verwaltung der im Dachstuhl verwendeten/gebrauchten Stuecke Bauholz
    private List<Kantholz> kantholzList = new ArrayList<>();

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
     * VB: kantholzList wurde initialisiert
     * NB: kantholzList wurde zurueckgegeben
     * @return  Liste mit allen Stuecken Kantholz die diesem Dachstuhl bereits ueber die get-Methode (in BauholzLager)
     *          hinzugefuegt wurden
     */
    public List<Kantholz> getHolz() {
        return kantholzList;
    }

    /**
     * VB: kantholzList wurde initialisiert, knatholz ist nicht null
     * NB: kantholz wurde der Liste kantholzList hinzugefuegt
     * @param kantholz  Stueck Kantholz das kantholzList hinzugefuegt werden soll
     */
    public void add(Kantholz kantholz){
        this.kantholzList.add(kantholz);
    }
}
