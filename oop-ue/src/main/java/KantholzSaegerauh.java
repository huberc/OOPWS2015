/**
 *
 */
public class KantholzSaegerauh extends Kantholz {

    public KantholzSaegerauh(int laenge, int preis, int breite, int hoehe) {
        super(laenge, preis, breite, hoehe);
    }

    public void add(BauholzLager bauholzLager){
        bauholzLager.add(this);
    }
}
