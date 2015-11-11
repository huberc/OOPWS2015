/**
 * @author Ines Rieder, e1425000@student.tuwien.ac.at
 */
public class Rundholz extends AbstractHolz {

    public Rundholz(int laenge, int staerke) {
        super(laenge);
        this.staerke = staerke;
    }

    private int staerke;

    public int getStaerke() {
        return staerke;
    }

    public void setStaerke(int staerke) {
        this.staerke = staerke;
    }

    @Override
    public AbstractHolz internalNeu(Class<? extends AbstractHolz> clazz) {
        return HolzFactory.getInstance().createFromRundholz(this, clazz);
    }

    public String toString() {
        return "\tRundholz{"+
                "\n\t\tLaenge:\t\t"+this.laenge()+
                "\n\t\tStaerke:\t"+this.getStaerke()+"\n\t}";
    }
}
