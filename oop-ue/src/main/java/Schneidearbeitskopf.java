

public class Schneidearbeitskopf extends AbstractArbeitskopf {

    public Schneidearbeitskopf(double maxLength){
        HolzConstraint lengthConstraint = new HolzConstraint(HolzConstraint.ConstraintType.LENGTH, maxLength);
    }
}
