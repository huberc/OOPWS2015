/**
 * Created by Christoph on 29.11.2015.
 */
public class KantholzGehobelt extends Kantholz {

    public KantholzGehobelt(int laenge, int preis, int breite, int hoehe) {
        super(laenge, preis, breite, hoehe);
    }

    public void add(BauholzLager bauholzLager){
        bauholzLager.add(this);
    }
}
