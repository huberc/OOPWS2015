
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
     * @param staerke laenge des Holzstuecks in cm
     * @param rindenDicke Anteil an <code>staerke</code>, der auf Rinde entfaellt - Prozentwert zw. 0 und 1
     */
    public Saegerundholz(int laenge, int staerke, double rindenDicke) {
        this(laenge, staerke);
        this.rindenDicke = rindenDicke;
    }

    public Saegerundholz schaelen() {
        // TODO neues Etikett, schaelen ist ein Verarbeitungsschritt!
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Etikett[] saegen(Class<? extends AbstractHolz>... types) {
        // TODO Teil-Etiketten mit HolzFactory.getInstance().createFromRundholz(types[i]) holen,
        // alt auf this setzen, danach Werte auf errechnete setzen (ueber protected setter)
        return null;
    }

    
    public double getRindenDicke() {
        return rindenDicke;
    }

    
    protected void setRindenDicke(double rindenDicke) {
        this.rindenDicke = rindenDicke;
    }
}
