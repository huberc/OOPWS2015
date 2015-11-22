/**
 * Implementierung eines <code>AbstractArbeitskopf</code> der Baumstaemme zersaegt. Es koennen nur Baumstaemme
 * bis zu einer dem Konstruktor uebergebenen Maximallaenge zersaegt werden.
 * 
 * @author Michael Langowski, e1426581@student.tuwien.ac.at
 *
 */
public class Schneidearbeitskopf extends AbstractArbeitskopf {

    /**
     * Erzeugt einen neuen <code>Schneidearbeitskopf</code> mit der angegebenen Maximallaenge fuer
     * verarbeitbare Holzstuecke
     * 
     * @param maxLength
     *            die maximal Laenge ( > 0) in Metern fuer Holzstuecke, die dieser Arbeitskopf verarbeiten
     *            kann
     * 
     * @throws IllegalArgumentException
     *             falls <code>maxLength</code> nicht den Anforderungen ( > 0) entspricht
     */
    public Schneidearbeitskopf(double maxLength) throws IllegalArgumentException {
        if (maxLength <= 0) {
            throw new IllegalArgumentException("Maximale Laenge kann nicht kleiner oder gleihc 0 sein!");
        }
        HolzConstraint lengthConstraint = new HolzConstraint(HolzConstraint.ConstraintType.LENGTH, maxLength);
        this.constraint = lengthConstraint;
    }
}
