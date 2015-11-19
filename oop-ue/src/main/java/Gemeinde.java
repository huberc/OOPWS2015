import java.io.FileOutputStream;

/**
 * @author Ines Rieder
 *
 * verwaltet Informationen aller Forstbetriebe einer Gemeinde
 * baut auf der ObjectList auf (verwendet sie um Betriebe zu verwalten/ hinzuzufuegen/ loeschen/ ausgeben)
 * Die liste selbst akzeptiert jede Art von Objekt aber die Parameter der Methoden dieser Klasse sind explizit auf Forstbetriebe
 */
public class Gemeinde {

    //unveraenderlicher Name - keine Set-Methode
    private String name;
    private CustomList betriebe;

    /**
     * Erzeugen einer Gemeinde
     * @param name  Name der zu erzeugende Gemeinde (String)
     *
     * VB: es existiert noch keine Gemeinde mit demselben Namen, name != null
     * NB: die Gemeinde wurde erstellt, der Name zugeteilt und eine neue Objectlist zur Verwaltung der Forstbetriebe erstellt
     */
    public Gemeinde(String name) {
        this.name = name;
        this.betriebe = new CustomList();
    }

    /**
     * Hinzufuegen von Forstbetrieben einer Gemeinde
     * @param betrieb   der zu hinzufuegende Betrieb als Parameter (Forstbetrieb)
     *
     * VB: betrieb != null
     * NB: betrieb ist Bestandteil der Liste (Gemeinde)
     */
    public void addBetrieb (Forstbetrieb betrieb) {
        betriebe.insert(betrieb);
    }

    /**
     * Entfernen von Forstbetrieben einer Gemeinde
     * @param betrieb   Name des zu entfernende Betrieb (String)
     * @return  null (falls nicht enthalten) oder Forstbetrieb
     *
     * VB: betrieb != null
     * NB: betrieb ist KEIN Bestandteil der Liste (Gemeinde)
     */
    public Forstbetrieb deleteBetrieb (String betrieb) {
        //kann auf Forstbetrieb Casten, da in der Gemeinde nur Forstbetriebe eingefuegt werden
        return (Forstbetrieb) betriebe.removeByName(betrieb);
    }

    /**
     * Anzeigen aller Forstbetriebe einer Gemeinde auf dem Bildschirm
     *
     * VB:
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

}
