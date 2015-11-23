/**
 * Created by Christoph on 23.11.2015.
 */
public class StringListable implements Listable{
    
    private String value;
    
    public StringListable(String value){
        this.value = value;
    }

    @Override
    public String getName() {
        return this.value;
    }
}
