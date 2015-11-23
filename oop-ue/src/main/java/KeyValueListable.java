

public class KeyValueListable implements Listable{

    private String key;
    private double value;
    
    public KeyValueListable(String key, double value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String getName() {
        return this.key;
    }
    
    public String getKey() {
        return key;
    }
    
    public double getValue() {
        return value;
    }   
        
}
