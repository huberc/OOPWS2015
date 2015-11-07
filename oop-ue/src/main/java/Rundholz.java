

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
    
}
