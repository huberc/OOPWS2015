/**
 * Implementierung eines <code>Holzvollernter<code>s der sich auf Raedern bewegt.
 * Der zurueckgelegte Weg wird als Gleitkommazahl (<code>double</code>)in Metern gespeichert.
 * 
 * @author Michael Langowski, e1426581@student.tuwien.ac.at
 *
 */
public class Radernter extends Holzvollernter {

    /**
     * Addiert einen gegebenen Wert zur aktuell zurueckgelegten Distanz des Ernters
     */
    @Override
    public void addDistanceMoved(Number distanceMoved) {
        double dist = (double) this.distanceMoved;
        dist += (double) distanceMoved;
        this.distanceMoved = dist;
    }

}
