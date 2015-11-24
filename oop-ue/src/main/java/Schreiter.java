/**
 * Implementierung eines <code>Holzvollernter</code>, der sich auf Schreitbeinen bewegt. Die zurueckgelegte
 * Distanz ist dabei eine gaze Zahl und stellt die Anzahl der bisherigen Schritte des Ernters dar.
 * 
 * @author Michael Langowski, e1426581@student.tuwien.ac.at
 *
 */
public class Schreiter extends Holzvollernter {

    /**
     * Addiert einen gegebenen Wert zur aktuell zurueckgelegten Distanz des Ernters. Die Distanz wird dabei
     * nicht ueberschrieben sondern erhoeht
     *
     * VB: distanceMpved ist ein int groesser 0
     * NB: distancedMoved wurde der aktuell zurueckgelegten Distanz hinzugefuegt
     * 
     * @param distanceMoved
     *            Ganze Zahl, der die seit dem letzten Aufruf von <code>addDistanceMoved</code> zurueckgelegte
     *            Distanz repraesentiert. Muss > 0 sein.
     * 
     * @throws IllegalArgumentException
     *             falls <code>distanceMoved</code> nicht der Spezifikation entspricht, d.h. <= 0 ist
     */
    @Override
    public void addDistanceMoved(Number distanceMoved) throws IllegalArgumentException {
        if (distanceMoved.intValue() <= 0) {
            throw new IllegalArgumentException("Zurueckgelegte Distanz muss groesser 0 sein");
        }
        int dist = this.distanceMoved.intValue();
        dist += distanceMoved.intValue();
        this.distanceMoved = dist;
    }

}
