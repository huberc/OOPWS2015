/**
 * @author Ines Rieder
 *
 *         verwaltet Informationen aller Forstbetriebe einer Gemeinde baut auf der ObjectList auf (verwendet
 *         sie um Betriebe zu verwalten/ hinzuzufuegen/ loeschen/ ausgeben) Die liste selbst akzeptiert jede
 *         Art von Objekt aber die Parameter der Methoden dieser Klasse sind explizit auf Forstbetriebe
 */
public class Gemeinde {

    private static final UniqueNameProvider NAME_PROVIDER = new UniqueNameProvider();

    //unveraenderlicher Name - keine Set-Methode
    //einzigartiger Name - uniqueNameProvider testem beim Erstellen ob Name bereits vorhanden
    private String                          name;                                    // TODO Ines
    private CustomList                      betriebe      = new CustomList();

    /**
     * Erzeugen einer Gemeinde
     * 
     * VB: es existiert noch keine Gemeinde mit demselben Namen, name != null NB: die Gemeinde wurde erstellt,
     * der Name zugeteilt und eine neue Liste zur Verwaltung der Forstbetriebe erstellt
     * 
     * @param name
     *            Name der zu erzeugende Gemeinde (String)
     * 
     * @throws IllegalArgumentException
     *             falls der angegebene name bereits fuer eine andere <code>Gemeinde</code> in Verwendung ist
     */
    public Gemeinde(String name) {
        if (Gemeinde.NAME_PROVIDER.nameUsed(name)) {
            throw new IllegalArgumentException("Name " + name + " ist bereits in Verwendung!");
        }
        this.name = name;
        Gemeinde.NAME_PROVIDER.registerName(name);
    }

    /**
     * Hinzufuegen von Forstbetrieben einer Gemeinde
     * 
     * @param betrieb
     *            der zu hinzufuegende Betrieb als Parameter (Forstbetrieb)
     *
     *            VB: betrieb != null NB: betrieb ist Bestandteil der Liste (Gemeinde)
     */
    public void addBetrieb(String betrieb) {
        Forstbetrieb result = new Forstbetrieb(betrieb);
        betriebe.insert(result);
    }

    /**
     * Entfernen von Forstbetrieben einer Gemeinde
     * 
     * @param betrieb
     *            Name des zu entfernende Betrieb (String)
     * @return null (falls nicht enthalten) oder Forstbetrieb
     *
     *         VB: betrieb != null NB: betrieb ist KEIN Bestandteil der Liste (Gemeinde)
     */
    public Forstbetrieb deleteBetrieb(String betrieb) {
        //kann auf Forstbetrieb Casten, da in der Gemeinde nur Forstbetriebe eingefuegt werden
        return (Forstbetrieb) betriebe.removeByName(betrieb);
    }

    /**
     * Anzeigen aller Forstbetriebe einer Gemeinde auf dem Bildschirm
     *
     * NB: alle beinhalteten Betriebe wurden ausgegeben
     */
    public void show() {
        if (betriebe.getHead() == null) {
            return;
        }
        StringBuilder result = new StringBuilder();
        CustomList.CustomListNode head = betriebe.getHead();
        result.append(head.getValue().toString());
        while (betriebe.getHead().getNext() != null) {
            head = head.getNext();
            result.append(head.getValue().toString());
        }
        System.out.println(result.toString());
    }

    public Forstbetrieb getBetriebByName(String betrieb) {
        return (Forstbetrieb) betriebe.getElement(betrieb);
    }

    public boolean containsBetrieb(Forstbetrieb betrieb) { System.out.println(betrieb.getName() + betriebe.contains(betrieb)); return betriebe.contains(betrieb); }

}
