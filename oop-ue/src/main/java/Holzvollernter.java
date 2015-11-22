/**
 * Abstrakte Definition eines "Holzvollernters". Ein Holzvollernter kann mit verschiedenen Arbeitskoepfen (@see
 * <code>AbstractArbeitskopf</code>) ausgeruestet werden, die die Art der Verarbeitung von geerntetem Holz
 * festlegen. Weiters gibt es unterschideliche Arten von Holzvollernten, die sich unterschiedlich fortbewegen.
 * Implementierungen muessen abhaengig von der jeweiligen Art der Fortbewegung <code>addDistanceMoved</code>
 * entsprechend implementieren
 * 
 * @author Michael Langowski, e1426581@student.tuwien.ac.at
 */
public abstract class Holzvollernter implements Listable {

    private static Integer idSequence = 1;

    /**
     * Ensure uniqueness of IDs by making it only accessible through this method
     * 
     * @return the current value of the id sequence, i.e. the next id to assign to a new "Vollernter"
     *         (1-based). After the current id value was fetched, the sequence is incremented. This method is
     *         thread-safe
     */
    private static final int fetchId() {
        int retVal;
        synchronized (Holzvollernter.idSequence) {
            retVal = Holzvollernter.idSequence++;
        }
        return retVal;
    }

    private int                 id;
    private AbstractArbeitskopf arbeitskopf;
    protected Number            distanceMoved   = 0;
    private int                 betriebsstunden = 0;

    /**
     * Legt einen neuen Holzvollernter mit einer global eindeutigen Id an. Die zurueckgelegten Schritte
     * (distanceMoved) sowie die Betriebsstunden des Ernters werden mit 0 initialisiert. Der Konstruktor setzt
     * keine Arbeitskopf, dieser muss von der aufrufenden Komponente separat gesetzt werden.
     */
    public Holzvollernter() {
        this.id = Holzvollernter.fetchId();
    }

    public AbstractArbeitskopf getArbeitskopf() {
        return arbeitskopf;
    }

    public void setArbeitskopf(AbstractArbeitskopf arbeitskopf) {
        this.arbeitskopf = arbeitskopf;
    }

    public Number getDistanceMoved() {
        return distanceMoved;
    }

    /**
     * Implementation-defined method to add a distance value to the total distance this
     * <code>Holzvollernter</code> moved. Depending on the manner of moving of this vollernter,
     * implementations my treat the passed-in number differently.
     * 
     * @param distanceMoved
     *            a <code>Number</code> describing the distance this vollernter moved during its time in
     *            service. Depending on the actual distance unit used by the implementation loss of precision
     *            in input number is possible. The value passed here is added to the current total distance
     *            the vollernter moved
     */
    public abstract void addDistanceMoved(Number distanceMoved);

    public int getId() {
        return id;
    }

    public int getBetriebsstunden() {
        return betriebsstunden;
    }

    public void setBetriebsstunden(int betriebsstunden) {
        this.betriebsstunden = betriebsstunden;
    }

    @Override
    public String getName() {
        return Integer.toString(this.id);
    }

}
