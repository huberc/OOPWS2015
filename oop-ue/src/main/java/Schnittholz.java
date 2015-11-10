

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
        // TODO Teil-Etiketten mit HolzFactory.getInstance().createFromRundholz(types[i]) holen,
        // alt auf this setzen, danach Werte auf errechnete setzen (ueber protected setter)

        //TODO Ines, der Auruf würde so gehen, der michi hat nur einen Parameter vergessen HolzFactory.getInstance().createFromRundholz(this,types[i]);
        //nachdem der oben vorgeschlagene Aufruf für Teil-Etiketten nicht funktioniert, hab ich es einmal hardgecoded
        AbstractHolz[] zersaegt = new AbstractHolz[types.length];
        for (int i = 0; i <= types.length; i++) {

            if(HolzFactory.getInstance().createFromSchnittholz(this,types[i]) instanceof Schnittholz){
                int laenge = this.laenge() * (1/types.length);
                zersaegt[i] = new Schnittholz(laenge,this.getDicke(),this.getBreite());

            }
            else if(HolzFactory.getInstance().createFromSchnittholz(this,types[i]) instanceof Energieholz){
                int volumen = this.getLaenge() * this.getBreite() * this.getDicke() * (1/types.length);
                zersaegt[i] = new Energieholz(this.getLaenge(), volumen);
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
