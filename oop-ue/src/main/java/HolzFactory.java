import java.util.HashMap;
import java.util.Map;

public class HolzFactory {

    private Map<Class<? extends AbstractHolz>, IHolzConverter<Rundholz, ? extends AbstractHolz>> rundholzConverters = new HashMap();

    public HolzFactory() {

    }


    public AbstractHolz createFromRundholz(Rundholz input, Class<? extends AbstractHolz> targetType) {
        IHolzConverter<Rundholz, ? extends AbstractHolz> conv = this.rundholzConverters.get(targetType);
        if(conv != null){
            return conv.createFrom(input);
        }else{
            throw new IllegalArgumentException("Kann nicht " + targetType.getSimpleName() + " aus " + input.getClass() + " erstellen!");
        }
    }
}
