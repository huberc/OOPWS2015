

public class Energieholz implements Etikett{

    private int volumen;

    
    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

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
    
    public Etikett neu(){
        return null;
    }
    
}
