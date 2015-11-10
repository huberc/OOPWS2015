
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

    public BauRundholz schaelen() {
        int staerkeGeschaelt = (int) (this.getStaerke() * (1-rindenDicke));
        BauRundholz geschaelt = new BauRundholz(this.getLaenge(), staerkeGeschaelt);
        geschaelt.setAlt(this);
        return geschaelt;
    }

    @SuppressWarnings("unchecked")
    @Override
    public AbstractHolz[] saegen(Class<? extends AbstractHolz>... types) {
        // TODO Teil-Etiketten mit HolzFactory.getInstance().createFromRundholz(types[i]) holen,
        // alt auf this setzen, danach Werte auf errechnete setzen (ueber protected setter)

        //TODO Ines, der Auruf würde so gehen, der michi hat nur einen Parameter vergessen HolzFactory.getInstance().createFromRundholz(this,types[i]);
        //nachdem der oben vorgeschlagene Aufruf für Teil-Etiketten nicht funktioniert, hab ich es einmal hardgecoded
        AbstractHolz[] zersaegt = new AbstractHolz[types.length];
        for (int i = 0; i <= types.length; i++) {

            if(HolzFactory.getInstance().createFromRundholz(this,types[i]) instanceof Schnittholz){
                int dicke = this.getStaerke() * (1/types.length);
                zersaegt[i] = new Schnittholz(this.getLaenge(),dicke,this.getStaerke());

            }
            else if(HolzFactory.getInstance().createFromRundholz(this,types[i]) instanceof Energieholz){
                int volumen = this.getLaenge() * this.getStaerke() * this.getStaerke() * 2 * (1/types.length);
                zersaegt[i] = new Energieholz(this.getLaenge(), volumen);
            }
            zersaegt[i].setAlt(this);
           /* if (types[i] instanceof Schnittholz ) {
                int dicke = this.getStaerke() * (1/types.length);
                help = new types[i](this.getLaenge(), dicke,this.getStaerke());     //kann Schnittholz oder Vollkantschnittholz
            }
            else if (types[i] instanceof Energieholz) {

            }
            // else { throw exception } ???
            help.setAlt(this);
            zersaegt[i] = help;*/
        }
        return zersaegt;
    }

    
    public double getRindenDicke() {
        return rindenDicke;
    }

    protected void setRindenDicke(double rindenDicke) {
        this.rindenDicke = rindenDicke;
    }
}
