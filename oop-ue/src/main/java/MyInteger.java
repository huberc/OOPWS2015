

public class MyInteger implements Smaller<MyInteger>{

    private int value;

    public MyInteger(int value){
        this.value = value;
    }

    @Override
    public boolean smaller(MyInteger other) {
        if(this.value < other.getValue())
            return true;
        else
            return false;
    }

    public int getValue() {
        return value;
    }
}
