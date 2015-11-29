
public abstract class Bauholz {

    /* Laenge und Preis des Bauholzes */
    private int laenge;
    private int preis;

    /**
     * Erstellen eines neuen Bauholzes
     * VB: laenge und preis sind nicht null
     * NB: ein Bauholz mit den uebergebenem Parametern wurde erzeugt
     * @param laenge    Lange des Bauholzes
     * @param preis     Preis des Bauholzes
     */
    public Bauholz (int laenge, int preis) {
        this.laenge = laenge;
        this.preis = preis;
    }

    /**
     * VB: bauholzLager ist nicht null
     * NB: dieses Bauholz wurde dem bauholzLager hinzugefuegt
     * @param bauholzLager  Bauholzlager wo dieses Bauholz hinzugeuegt werden soll
     */
    abstract void add(BauholzLager bauholzLager);
    
    public int getLaenge() {
        return laenge;
    }
   
    public int getPreis() {
        return preis;
    }
}
