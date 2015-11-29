/**
 * Created by Christoph on 29.11.2015.
 */
public class RundholzSaegerauh extends Rundholz {

    public RundholzSaegerauh(int laenge, int preis, int durchmesser) {
        super(laenge, preis, durchmesser);
    }

    public void add(BauholzLager bauholzLager){
        bauholzLager.add(this);
    }

}
