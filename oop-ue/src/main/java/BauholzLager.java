import java.util.ArrayList;
import java.util.List;

/**
 * In einem Bauholzlager werden werden vier Arten von Bauholz gelagert/verwaltet
 */
public class BauholzLager {

    // vier Listen zur Verwaltungen der verschiedenen Bauholztypen
    private List<RundholzGehobelt> listRundholzGehobelt = new ArrayList<>();
    private List<RundholzSaegerauh> listRundholzSaegerauh = new ArrayList<>();
    private List<KantholzGehobelt> listKantholzGehobelt = new ArrayList<>();
    private List<KantholzSaegerauh> listKantholzSaegerauh = new ArrayList<>();

    /**
     * lagert ein Stueck Bauholz im Lager ein
     * VB: bauholz ist nicht null
     * NB: bauholz wurde dem Bauholzlager hinzugefuegt (der entsprechenden Liste)
     * @param bauholz   hinzuzufuegendes Bauholz
     */
    public void add(Bauholz bauholz) {
        bauholz.add(this);
    }

    /**
     * lagert ein Stueck gehobeltes Rundholz im Lager ein
     * VB: rundholzGehobelt ist ein Objekt der Klasse RundholzGehobelt und nicht null, verwendete Liste muss initialisiert sein
     * NB: rundholzGehobelt wurde der Liste ListRundholzGehobelt hinzugefuegt
     * @param rundholzGehobelt  hinzuzufuegendes gehobeltes Rundholz
     */
    public void add(RundholzGehobelt rundholzGehobelt) {
        listRundholzGehobelt.add(rundholzGehobelt);
    }

    /**
     * lagert ein Stueck saegerauhes Rundholz im Lager ein
     * VB: rundholzSaegerauh ist ein Objekt der Klasse RundholzSaegerauh und nicht null, verwendete Liste muss initialisiert sein
     * NB: rundholzSaegerauh wurde der Liste ListRundholzSaegerauh hinzugefuegt
     * @param rundholzSaegerauh  hinzuzufuegendes saegerauhes Rundholz
     */
    public void add(RundholzSaegerauh rundholzSaegerauh) {
        listRundholzSaegerauh.add(rundholzSaegerauh);
    }

    /**
     * lagert ein Stueck gehobeltes Kantholz im Lager ein
     * VB: kantholzGehobelt ist ein Objekt der Klasse KantholzGehobelt und nicht null, verwendete Liste muss initialisiert sein
     * NB: kantholzGehobelt wurde der Liste ListKantholzGehobelt hinzugefuegt
     * @param kantholzGehobelt  hinzuzufuegendes gehobeltes Kantholz
     */
    public void add(KantholzGehobelt kantholzGehobelt) {
        listKantholzGehobelt.add(kantholzGehobelt);
    }

    /**
     * lagert ein Stueck saegerauhes Kantholz im Lager ein
     * VB: kantholzSaegerauh ist ein Objekt der Klasse KantholzSaegerauh und nicht null, verwendete Liste muss initialisiert sein
     * NB: kantholzSaegerauh wurde der Liste ListKantholzSaegerauh hinzugefuegt
     * @param kantholzSaegerauh  hinzuzufuegendes saegerauhes Kantholz
     */
    public void add(KantholzSaegerauh kantholzSaegerauh) {
        listKantholzSaegerauh.add(kantholzSaegerauh);
    }

    /**
     * liefert ein passendes Stueck Bauholz fuer einen Dachstuhl und entfernt dieses aus dem Lager
     * VB: dachstuhl ist nicht null
     * NB: ein passendes Stueck Bauholz (oder null, wenn kein Passendes vorhanden ist) wurde zurueckgegeben
     * SIDE EFFECT: dem Dachstuhl wird das zurueckgegebene Stueck Bauholz hinzugefuegt
     * @param dachstuhl Dachstuhl fuer den ein passendes Bauholz gesucht wird
     * @return  passendes Stueck Bauholz fuer den uebergebenen Dachstuhl, wenn kein passendes vorhanden ist wird null zurueckgegeben
     */
    public Bauholz get(Dachstuhl dachstuhl) {

        return dachstuhl.get(this);
    }

    /**
     * liefert ein gehobeltes Kantholz fuer einen Dachstuhl eines Wohnbaues aus Stein zurueck
     * VB: steinWohnbauDachstuhl ist nicht null, verwendeten Listen muessen initialisiert sein
     * NB: ein gehobeltes Kantholz (oder null, wenn kein gehobeltes Kantholz vorhanden ist) wurde zurueckgegeben
     * SIDE EFFECT: dem Dachstuhl wird das zurueckgegebene Stueck Bauholz hinzugefuegt
     * @param steinWohnbauDachstuhl Dachstuhl eines Wohnbaues aus Stein fuer den ein gehobeltes Kantholz gesucht wird
     * @return ein gehobeltes Kantholz fuer den uebergebenem Dachstuhl wird zurueckgegeben, wenn keines vorhanden ist wird null zurueckgegeben
     */
    public KantholzGehobelt get(SteinWohnbauDachstuhl steinWohnbauDachstuhl) {

        KantholzGehobelt kantholzGehobelt=null;

        if(!(listKantholzGehobelt.isEmpty())) {
            kantholzGehobelt = listKantholzGehobelt.get(0);
            listKantholzGehobelt.remove(kantholzGehobelt);
            steinWohnbauDachstuhl.add(kantholzGehobelt);
        }
        return kantholzGehobelt;
    }

    /**
     * liefert ein passendes Steuck Kantholz fuer einen Dachstuhl eines Nutzbaues mit Steinbau
     * VB: steinNutzbauDachstuhl ist nicht null, verwendeten Listen muessen initialisiert sein
     * NB: ein passendes Kantholz (oder null, wenn kein passendes vorhanden ist) wurde zurueckgegeben
     * SIDE EFFECT: dem Dachstuhl wird das zurueckgegebene Stueck Bauholz hinzugefuegt
     * @param steinNutzbauDachstuhl Dachstuhl eines Nutzbaues aus Stein fuer den ein passendes Kantholz gesucht wird
     * @return ein passendes Stueck Kantholz fuer den uebergebenem Dachstuhl, wenn kein passendes vorhanden ist wird null zurueckgegeben
     */
    public Kantholz get(SteinNutzbauDachstuhl steinNutzbauDachstuhl) {
        Kantholz kantholz =null;
        if(!(listKantholzSaegerauh.isEmpty())) {
            kantholz = listKantholzSaegerauh.get(0);
            listKantholzSaegerauh.remove(kantholz);
            steinNutzbauDachstuhl.add(kantholz);
        }else if(!(listKantholzGehobelt.isEmpty())){
            kantholz = listKantholzGehobelt.get(0);
            listKantholzGehobelt.remove(kantholz);
            steinNutzbauDachstuhl.add(kantholz);
        }
        return kantholz;
    }

    /**
     * liefert ein gehobeltes Rundholz fuer einen Dachstuhl eines Wohnbaues aus Holz zurueck
     * VB: holzWohnbauDachstuhl ist nicht null, verwendeten Listen muessen initialisiert sein
     * NB: ein gehobeltes Rundholz (oder null, wenn kein gehobeltes Rundholz vorhanden ist) wurde zurueckgegeben
     * SIDE EFFECT: dem Dachstuhl wird das zurueckgegebene Stueck Bauholz hinzugefuegt
     * @param holzWohnbauDachstuhl Dachstuhl eines Wohnbaues aus Holz fuer den ein gehobeltes Rundholz gesucht wird
     * @return ein gehobeltes Rundholz fuer den uebergebenem Dachstuhl wird zurueckgegeben, wenn keines vorhanden ist wird null zurueckgegeben
     */
    public RundholzGehobelt get(HolzWohnbauDachstuhl holzWohnbauDachstuhl) {
        RundholzGehobelt rundholzGehobelt =null;
        if(!(listRundholzGehobelt.isEmpty())) {
            rundholzGehobelt = listRundholzGehobelt.get(0);
            listRundholzGehobelt.remove(rundholzGehobelt);
            holzWohnbauDachstuhl.add(rundholzGehobelt);
        }
        return rundholzGehobelt;
    }

    /**
     * liefert ein passendes Steuck Rundholz fuer einen Dachstuhl eines Nutzbaues aus
     * VB: holzNutzbauDachstuhl ist nicht null, verwendeten Listen muessen initialisiert sein
     * NB: ein passendes Rundholz (oder null, wenn kein passendes vorhanden ist) wurde zurueckgegeben
     * SIDE EFFECT: dem Dachstuhl wird das zurueckgegebene Stueck Bauholz hinzugefuegt
     * @param holzNutzbauDachstuhl Dachstuhl eines Nutzbaues aus Holz fuer den ein passendes Rundholz gesucht wird
     * @return ein passendes Stueck Rundholz fuer den uebergebenem Dachstuhl, wenn kein passendes vorhanden ist wird null zurueckgegeben
     */
    public Rundholz get(HolzNutzbauDachstuhl holzNutzbauDachstuhl) {
        Rundholz rundholz = null;
        if(!(listRundholzSaegerauh.isEmpty())){
            rundholz = listRundholzSaegerauh.get(0);
            listRundholzSaegerauh.remove(rundholz);
            holzNutzbauDachstuhl.add(rundholz);
        }else if(!(listRundholzGehobelt.isEmpty())){
            rundholz = listRundholzGehobelt.get(0);
            listRundholzGehobelt.remove(rundholz);
            holzNutzbauDachstuhl.add(rundholz);
        }

        return rundholz;
    }

    /**
     * zeigt die Laenge aller Stuecke von Bauholz eines Lagers auf dem Bildschirm an
     * VB: verwendeten Listen muessen initialisiert sein
     * NB: die Laengen aller Stuecke von Bauholz des Lagers wurden ausgegeben
     */
    public void list() {
        int cnt=0;
        System.out.println("\tRundholzGehobelt:");
        for (RundholzGehobelt h : this.listRundholzGehobelt) {
            System.out.println("\t\tStueck "+ ++cnt +": " + h.getLaenge()+" cm");
        }
        cnt=0;
        System.out.println("\tRundholzSaegerauh:");
        for (RundholzSaegerauh h : this.listRundholzSaegerauh) {
            System.out.println("\t\tStueck "+ ++cnt +": " + h.getLaenge()+" cm");
        }
        cnt=0;
        System.out.println("\tKantholzGehobelt:");
        for (KantholzGehobelt h : this.listKantholzGehobelt) {
            System.out.println("\t\tStueck "+ ++cnt +": " + h.getLaenge()+" cm");
        }
        cnt=0;
        System.out.println("\tKantholzSaegerauh:");
        for (KantholzSaegerauh h : this.listKantholzSaegerauh) {
            System.out.println("\t\tStueck "+ ++cnt +": " + h.getLaenge()+" cm");
        }
    }

    /**
     * zeigt die Laenge aller Stuecke von Bauholz eines Dachstuhls auf dem Bildschirm an
     * VB: Dachstuhl ist nicht null
     * NB: die Laeinge aller Stuecke von Bauholz des uebergebenem Dachstuhls wurden ausgegeben
     * @param d Dachstuhl dessen Holzlaengen augegeben werden sollen
     */
    public void list(Dachstuhl d) {
        System.out.println("\tAktueller Lagerbestand fuer " + d.getClass().getSimpleName() + ":");
        int cnt=0;

        for (Bauholz b : d.getHolz()) {
            System.out.println("\t\tStueck "+ ++cnt +": " + b.getLaenge()+" cm");
        }
    }

    /**
     * zeigt den Preis des Holzes fuer einen kompletten Dachstuhl auf dem Bildschirm an
     * VB: Dachstuhl d ist nicht null
     * NB: Preis des Holzes fuer den uebergebenem Dachstuhl wurde ausgegeben
     * @param d Dachstuhl dessen Preis gefragt ist
     */
    public void price(Dachstuhl d) {
        int price = 0;
        for (Bauholz h : d.getHolz()) {
            price += h.getPreis();
        }
        System.out.println("\tDachstuhl " + d.getClass().getSimpleName() + " kostet: "+price+" cent");
    }

}
