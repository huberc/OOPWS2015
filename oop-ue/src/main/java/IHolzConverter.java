/**
 *@author Michael Langowski, e1426581@student.tuwien.ac.at
 */

public interface IHolzConverter<T extends AbstractHolz, R extends AbstractHolz> {

    R createFrom(T input);
    
}
