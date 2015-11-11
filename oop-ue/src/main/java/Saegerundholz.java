/**
 * @author Christoph Huber, e1427322@student.tuwien.ac.at
 */
public class Saegerundholz extends Rundholz implements Saegbar {

    /**
     * Rindendicke in Prozent - staerke verringert sich beim Schaelen um diesen Wert (gerundet auf volle cm)
     */
    private double rindenDicke = 0.05;

    /**
     * Erstellt ein neues Saegerundholz-Etikett mit angegebener Laenge, Staerke und
     * 5% ( = Default-Wert) Rindendicke
     * 
     * @see new Rundholz(int l, int s)
     * 
     */
    public Saegerundholz(int laenge, int staerke) {
        super(laenge, staerke);
    }

    /**
     * Erstellt ein neues Saegerundholz-Etikett mit angegebener Laenge, Staerke und
     * <code>rindenDicke</code> Prozent Rindendicke
     * 
     * @param laenge laenge des Holzstuecks in cm
     * @param staerke staerke des Holzstuecks in cm
     * @param rindenDicke Anteil an <code>staerke</code>, der auf Rinde entfaellt - Prozentwert zw. 0 und 1
     */
    public Saegerundholz(int laenge, int staerke, double rindenDicke) {
        this(laenge, staerke);
        this.rindenDicke = rindenDicke;
    }

    /**
     *
     * @return produced <code>Baurundholz</code>
     */
    public BauRundholz schaelen() {

        int staerkeGeschaelt = (int) (this.getStaerke() * (1-rindenDicke));
        BauRundholz geschaelt = (BauRundholz) this.neu(BauRundholz.class);
        geschaelt.setStaerke(staerkeGeschaelt);
        geschaelt.setAlt(this);
        return geschaelt;
    }

    /**
     * @author Ines Rieder, e1425000@student.tuwien.ac.at
     * @param types Array of classes, in which the wood should be processed in
     * @return Array of the produced woods
     */
    @Override
    public AbstractHolz[] saegen(Class<? extends AbstractHolz>... types) {
        if(!this.isEtikettierbar()){
            throw new IllegalStateException("Nicht etikettierbar!");
        }
        AbstractHolz[] retVal = HolzFactory.getInstance().saegeHelper(this, types);
        for(AbstractHolz holz : retVal){
            holz.setAlt(this);
        }
        return retVal;
    }

    
    public double getRindenDicke() {
        return rindenDicke;
    }

    protected void setRindenDicke(double rindenDicke) {
        this.rindenDicke = rindenDicke;
    }

    @Override
    public String toString() {
        return "\tSaegerundholz{\n" +
                "\t\tRindendicke:\t" + rindenDicke +
                "\n\t\tLaenge:\t\t"+this.laenge()+
                "\n\t\tStaerke:\t"+this.getStaerke()+"\n\t}";
    }
}
