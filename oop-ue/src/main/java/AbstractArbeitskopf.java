/**
 *  Abstrakte Klasse fuer Arbeitskoepfe
 *
 *  @author Michael Langowski
 */
public abstract class AbstractArbeitskopf {

    /**
     * Definitionen der Holzconstraints fuer Hackschnitzelarbeitskopf und Schneidearbeitskopf
     */
    protected HolzConstraint constraint;
    
    public HolzConstraint getConstraint() {
        return constraint;
    }
    
}
