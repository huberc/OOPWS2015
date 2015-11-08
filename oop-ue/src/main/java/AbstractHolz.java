import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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

    //    /**
    //     * Protected Konstruktor fuer Historisierung (aktualisiert alt), wird NICHT direkt verwendet, muss in
    //     * geerbten Klassen vorhanden sein und aus fuer den noetigen Param-Typ ueberladenem Konstruktor
    //     * aufgerufen werden.
    //     * 
    //     * @param holz
    //     *            Das alte Etikett (= Etikett vor aktuellem Verarbeitungsschritt)
    //     */
    //    protected AbstractHolz(AbstractHolz holz) {
    //        this.alt = holz;
    //    }

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

    public abstract AbstractHolz neu(Class<? extends AbstractHolz> newType);

}
