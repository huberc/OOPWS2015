

public class Schnittholz extends AbstractHolz implements Saegbar{

    public Schnittholz(int laenge, int dicke, int breite) {
        super(laenge);
        this.dicke = dicke;
        this.breite = breite;
    }

    private int dicke;
    private int breite;
    
    public int getDicke() {
        return dicke;
    }
    
    protected void setDicke(int dicke) {
        this.dicke = dicke;
    }
    
    public int getBreite() {
        return breite;
    }
    
    protected void setBreite(int breite) {
        this.breite = breite;
    }

    @SuppressWarnings("unchecked")
    @Override
    public AbstractHolz[] saegen(Class<? extends AbstractHolz>... types) {
        AbstractHolz[] zersaegt = new AbstractHolz[types.length];
        AbstractHolz tmp;

        for (int i = 0; i <= types.length; i++) {
            tmp = HolzFactory.getInstance().createFromSchnittholz(this,types[i]);
            if(HolzFactory.getInstance().createFromSchnittholz(this,types[i]) instanceof Schnittholz){
                int dick = this.dicke* (1/types.length);
                ((Schnittholz) tmp).setDicke(dick);
                ((Schnittholz) tmp).setBreite(this.breite);
                zersaegt[i] = tmp;

            }
            else if(HolzFactory.getInstance().createFromSchnittholz(this,types[i]) instanceof Energieholz){
                double volumen = this.getLaenge() * this.getBreite() * this.getDicke() * (1/types.length);
                ((Energieholz) tmp).setVolumen(volumen);
                zersaegt[i] = tmp;
            }
            zersaegt[i].setAlt(this);
        }
        return zersaegt;
    }

    @Override
    protected AbstractHolz internalNeu(Class<? extends AbstractHolz> newType) {
        return HolzFactory.getInstance().createFromSchnittholz(this, newType);
    }

    
}
