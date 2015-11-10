
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
        return "Rundholz{\n"+
                "\n\t laenge:\t\t"+this.laenge()+
                "\n\t staerke:\t\t"+this.getStaerke()+"\n}";
    }
}
