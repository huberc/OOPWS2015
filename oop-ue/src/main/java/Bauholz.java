

public abstract class Bauholz {

    private int laenge;
    private int preis;

    abstract void add(BauholzLager bauholzLager);
    
    public int getLaenge() {
        return laenge;
    }
    
    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }
   
    public int getPreis() {
        return preis;
    }
    
    public void setPreis(int preis) {
        this.preis = preis;
    }
    
}
