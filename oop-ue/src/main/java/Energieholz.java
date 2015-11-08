

public class Energieholz extends AbstractHolz{

    public Energieholz(int laenge) {
        super(laenge);
        // TODO Auto-generated constructor stub
    }

    private int volumen;

    
    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    @Override
    public AbstractHolz neu(Class<? extends AbstractHolz> newType) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
