

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

    @Override
    public Etikett[] saegen(Class<? extends AbstractHolz>... types) {
        // TODO Teil-Etiketten mit HolzFactory.getInstance().createFromSchnittholz(types[i]) holen,
        // alt auf this setzen, danach Werte auf errechnete setzen (ueber protected setter)
        return null;
    }

    @Override
    protected AbstractHolz internalNeu(Class<? extends AbstractHolz> newType) {
        return HolzFactory.getInstance().createFromSchnittholz(this, newType);
    }

    
}
