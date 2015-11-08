

public class Energieholz extends AbstractHolz{

    public Energieholz(int laenge, double volumen) {
        super(laenge);
        this.volumen = volumen;
    }

    private double volumen;

    
    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    @Override
    public AbstractHolz neu(Class<? extends AbstractHolz> newType) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
