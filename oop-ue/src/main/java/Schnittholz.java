

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
    
    public void setDicke(int dicke) {
        this.dicke = dicke;
    }
    
    public int getBreite() {
        return breite;
    }
    
    public void setBreite(int breite) {
        this.breite = breite;
    }

    @Override
    public Etikett[] saegen(Class<? extends AbstractHolz>... types) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AbstractHolz neu(Class<? extends AbstractHolz> newType) {
        // TODO Auto-generated method stub
        return null;
    }

}
