

public abstract class Bauholz {

    private int laenge;
    private int preis;

    public Bauholz (int laenge, int preis) {
        this.laenge = laenge;
        this.preis = preis;
    }

    abstract void add(BauholzLager bauholzLager);
    
}
