

public class Saegearbeitskopf extends AbstractArbeitskopf {

    public Saegearbeitskopf(double maxLength){
        HolzConstraint lengthConstraint = new HolzConstraint(HolzConstraint.ConstraintType.LENGTH, maxLength);
    }
}
