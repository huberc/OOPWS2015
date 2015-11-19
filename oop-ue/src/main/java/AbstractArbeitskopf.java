
public abstract class AbstractArbeitskopf {

    public abstract WoodConstraint getConstraint();
    
    class WoodConstraint{
        
        ConstraintType type;
        Number constraintValue;
        
    }
    
    enum ConstraintType{
        LENGTH,
        DIAMETER;
    }
    
}
