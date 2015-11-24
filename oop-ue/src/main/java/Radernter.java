/**
 * Implementierung eines <code>Holzvollernter<code>s der sich auf Raedern bewegt.
 * Der zurueckgelegte Weg wird als Gleitkommazahl (<code>double</code>)in Metern gespeichert.
 * 
 * @author Michael Langowski, e1426581@student.tuwien.ac.at
 *
 */
public class Radernter extends Holzvollernter {

    /**
     * Addiert einen gegebenen Wert zur aktuell zurueckgelegten Distanz des Ernters. Die Distanz wird dabei
     * nicht ueberschrieben sondern erhoeht
     *
     * VB: distanceMoved ist ein double Wert
     * NB: der gegebene Wert wurde zu DistaceMoved hinzugefuegt
     * 
     * @param distanceMoved
     *            Gleitkommawert, der die seit dem letzten Aufruf von <code>addDistanceMoved</code>
     *            zurueckgelegte Distanz repraesentiert. Muss > 0 sein.
     * 
     * @throws IllegalArgumentException
     *             falls <code>distanceMoved</code> nicht der Spezifikation entspricht, d.h. <= 0 ist
     */
    @Override
    public void addDistanceMoved(Number distanceMoved) throws IllegalArgumentException {
        if (distanceMoved.doubleValue() <= 0.0) {
            throw new IllegalArgumentException("distanceMoved muss groesser 0 sein!");
        }
        double dist = this.distanceMoved.doubleValue();
        dist += distanceMoved.doubleValue();
        this.distanceMoved = dist;
    }

}
