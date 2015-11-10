
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
        BauRundholz geschaelt = (BauRundholz) this.neu(BauRundholz.class);
        geschaelt.setStaerke(staerkeGeschaelt);
        geschaelt.setAlt(this);
        return geschaelt;
    }

    @SuppressWarnings("unchecked")
    @Override
    public AbstractHolz[] saegen(Class<? extends AbstractHolz>... types) {
        AbstractHolz[] zersaegt = new AbstractHolz[types.length];
        AbstractHolz tmp;

        for (int i = 0; i <= types.length; i++) {

            tmp = HolzFactory.getInstance().createFromRundholz(this,types[i]);
            if(tmp instanceof Schnittholz){
                int dicke = this.getStaerke() * (1/types.length);
                ((Schnittholz) tmp).setDicke(dicke);
                ((Schnittholz) tmp).setBreite(this.getStaerke());
                zersaegt[i] = tmp;
            }
            else if(HolzFactory.getInstance().createFromRundholz(this,types[i]) instanceof Energieholz){
                double volumen = this.laenge() * (Math.pow(this.getStaerke()* (1/types.length)* (1/types.length),2) * Math.PI);
                ((Energieholz) tmp).setVolumen(volumen);
                zersaegt[i] = tmp;
            }

            zersaegt[i].setAlt(this);
        }
        return zersaegt;
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
                "\n\t\tLaenge:\t\t\t"+this.laenge()+
                "\n\t\tStaerke:\t\t"+this.getStaerke()+"\n}";
    }
}
