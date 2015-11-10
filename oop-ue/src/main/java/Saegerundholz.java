
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

    public BauRundholz schaelen() {
        int staerkeGeschaelt = (int) (this.getStaerke() * (1-rindenDicke));
        BauRundholz geschaelt = new BauRundholz(this.getLaenge(), staerkeGeschaelt);
        geschaelt.setAlt(this);
        return geschaelt;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Etikett[] saegen(Class<? extends AbstractHolz>... types) {
        // TODO Teil-Etiketten mit HolzFactory.getInstance().createFromRundholz(types[i]) holen,
        // alt auf this setzen, danach Werte auf errechnete setzen (ueber protected setter)

        //nachdem der oben vorgeschlagene Aufruf für Teil-Etiketten nicht funktioniert, hab ich es einmal hardgecoded
        Etikett[] zersaegt = new Etikett[types.length];
        for (int i = 0; i <= types.length; i++) {
            Etikett help;
            if (types[i] instanceof Schnittholz ) {
                int dicke = this.getStaerke() * (1/types.length);
                help = new types[i](this.getLaenge(), dicke,this.getStaerke());     //kann Schnittholz oder Vollkantschnittholz
            }
            else if (types[i] instanceof Energieholz) {
                int volumen = this.getLaenge() * this.getStaerke() * this.getStaerke() * 2 * (1/types.length);
                help = new Energieholz(this.getLaenge(), volumen);
            }
            // else { throw exception } ???
            help.setAlt(this);
            zersaegt[i] = help;
        }
        return null;
    }

    
    public double getRindenDicke() {
        return rindenDicke;
    }

    protected void setRindenDicke(double rindenDicke) {
        this.rindenDicke = rindenDicke;
    }
}
