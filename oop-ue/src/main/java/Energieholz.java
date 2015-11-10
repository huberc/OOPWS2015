

public class Energieholz extends AbstractHolz{

    public Energieholz(int laenge, double volumen) {
        super(laenge);
        this.volumen = volumen;
    }

    private double volumen;

    public void hacken() {
        this.setEtikettierbar(false);
    }
    
    public double getVolumen() {
        return volumen;
    }

    protected void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    @Override
    public AbstractHolz internalNeu(Class<? extends AbstractHolz> newType) {
        return HolzFactory.getInstance().createFromEnergieholz(this, newType);
    }

    public String toString() {
        return "Energieholz{\n"+
                "\n\t laenge:\t\t"+this.laenge()+
                "\n\t volumen:\t\t"+this.getVolumen()+"\n}";
    }
}
