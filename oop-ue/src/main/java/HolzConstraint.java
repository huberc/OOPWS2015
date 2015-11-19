/**
 * Klasse fuer Eigenschaften von Verarbeitungskoepfen. 
 * 
 * @author Michael Langowski, e1426581@student.tuwien.ac.at
 *
 */
public class HolzConstraint {

    /**
     * Typen von Constraints, die ein Arbeitskopf haben kann.
     * LENGTH = Die verarbeitbare Laenge des Arbeitskopfes ist auf maximal <code>constraintValue</code> beschraenkt
     * DIAMETER = Die verarbeitbare Dicke des Arbeitskopfes ist auf maximal <code>constraintValue</code> beschraenkt
     * 
     * @author Michael Langowski, e1426581@student.tuwien.ac.at
     *
     */
    enum ConstraintType {
        LENGTH, DIAMETER;
    }

    ConstraintType type;
    Number         constraintValue;
    
    public HolzConstraint(ConstraintType type, Number constraintValue){
        this.type = type;
        this.constraintValue = constraintValue;
    }
    

}