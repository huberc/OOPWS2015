import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Abstrakte Superklasse aller Holztypen, Template-Implementierung von neu + "Template"-Konstruktor
 * 
 * @author Michael Langowski, e1426581@student.tuwien.ac.at
 *
 */
public abstract class AbstractHolz implements Etikett {

    protected static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    private int                             laenge;
    private String                          datum;
    private Etikett                         alt;
    private boolean etiketierbar = true;

    /**
     * Public Konstruktor zum Erstellen eines neuen Etiketts OHNE vorherige Bearbeitungsschritte
     * 
     * @param laenge
     *            die Laenge des Holzstuecks
     */
    public AbstractHolz(int laenge) {
        this.laenge = laenge;
        this.datum = AbstractHolz.DATE_FORMAT.format(new Date());
    }

    @Override
    public int laenge() {
        return this.laenge;
    }

    @Override
    public String datum() {
        return this.datum;
    }

    @Override
    public Etikett alt() {
        return this.alt;
    }

    protected void setAlt(AbstractHolz alt){
        this.alt = alt;
    }

    protected int getLaenge() { return this.laenge; }
    
    protected abstract AbstractHolz internalNeu(Class<? extends AbstractHolz> newType);
    
    // TODO document!
    public final  AbstractHolz neu(Class<? extends AbstractHolz> clazz){
        AbstractHolz retVal = this.internalNeu(clazz);
        retVal.setAlt(this);
        return retVal;
    }

    public boolean isEtiketierbar() {
        return etiketierbar;
    }

    public void setEtiketierbar(boolean etiketierbar) {
        this.etiketierbar = etiketierbar;
    }
}
