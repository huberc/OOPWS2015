

public interface IHolzConverter<T extends AbstractHolz, R extends AbstractHolz> {

    R createFrom(T input);
    
}
