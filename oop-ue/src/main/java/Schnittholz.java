

public class Schnittholz implements Etikett, Saegbar{

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

    @Override
    public Etikett[] saegen(Class<? extends Etikett>... types) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public Etikett neu(){
        return null;
    }
}
