/**
 * Implementierung eines <code>AbstractArbeitskopf</code>, der Holz zu Hackschnitzeln verarbeitet. Es koennen
 * nur Holzstuecke bis zu einer bestimmten maximalen Dicke verarbeitet werden. Diese muss im Konstruktor
 * angegeben werden
 * 
 * @author Michael Langowski, e1426581@student.tuwien.ac.at
 *
 */
public class HackschnitzelArbeitskopf extends AbstractArbeitskopf {

    /**
     * Erzeugt einen neuen <code>HackschnitzelArbeitskopf</code> mit der angegebenen maximalen Holzdicke
     *
     * VB: maxDiameter ist ein int-Wert groesser 0
     * NB: ein neuer HackschnitzelArbeitskopf mit gegebenem maxDiameter wurde erzeugt
     * 
     * @param maxDiameter
     *            int-Wert ( > 0), der die fuer diesen Arbeitskopf maximal zulaessige Holzdicke in Zentimetern
     *            beschreibt.
     * 
     * @throws IllegalArgumentException
     *             falls <code>maxDiameter</code> nicht den Anforderungen entspricht, d.h.
     *             <code>maxDiameter <= 0 </code>
     * 
     */
    public HackschnitzelArbeitskopf(int maxDiameter) throws IllegalArgumentException {
        if (maxDiameter <= 0) {
            throw new IllegalArgumentException(
                    "Maximaler Durchmesser kann nicht kleiner, bzw. gleihc 0 sein!");
        }
        HolzConstraint diameterConstraint = new HolzConstraint(HolzConstraint.ConstraintType.DIAMETER,
                maxDiameter);
        this.constraint = diameterConstraint;
    }

}
