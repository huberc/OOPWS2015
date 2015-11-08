

public class Rundholz extends AbstractHolz{

    public Rundholz(int laenge, int staerke) {
        super(laenge);
        this.staerke = staerke;
    }

    private int staerke;
 
    public int getStaerke() {
        return staerke;
    }
  
    public void setStaerke(int staerke) {
        this.staerke = staerke;
    }

    @Override
    public AbstractHolz neu(Class<? extends AbstractHolz> newType) {
        return null;
    }
    
}
