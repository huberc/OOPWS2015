/**
 *
 */
public class RundholzGehobelt extends Rundholz {

    public RundholzGehobelt(int laenge, int preis, int durchmesser) {
        super(laenge, preis, durchmesser);
    }

    public void add(BauholzLager l){
        l.add(this);
    }
}
