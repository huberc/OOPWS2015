

public class Rundholz implements Etikett{

    private int staerke;
    
    @Override
    public int laenge() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String datum() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Etikett alt() {
        // TODO Auto-generated method stub
        return null;
    }
 
    public int getStaerke() {
        return staerke;
    }
  
    public void setStaerke(int staerke) {
        this.staerke = staerke;
    }

    public Etikett neu(){
        return null; // Kann Rundholz oder Energieholz geben
    }
    
}
