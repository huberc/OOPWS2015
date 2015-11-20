/**
 * @author Christoph Huber
 */
public class ListableNumber implements Listable {

    private Number number;

    public ListableNumber(Number number){
        this.number = number;
    }

    @Override
    public String getName() {
        return ""+this.number;
    }


    public Number getNumber() {
        return number;
    }
}
