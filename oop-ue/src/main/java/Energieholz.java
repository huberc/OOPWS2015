

public class Energieholz extends AbstractHolz{

    public Energieholz(int laenge, double volumen) {
        super(laenge);
        this.volumen = volumen;
    }

    private double volumen;

    public void hacken() {
        this.setEtikettierbar(false);
        System.out.println("\tDas Energieholz wurde durch hacken in Hackschnizel umgewandelt");
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
        return "\tEnergieholz{"+
                "\n\t\tLaenge:\t\t"+this.laenge()+
                "\n\t\tVolumen:\t"+this.getVolumen()+"\n\t}";
    }
}
