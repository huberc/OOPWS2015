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
    protected Etikett                       alt;

    /**
     * Public Konstruktor zum Erstellen eines neuen Etiketts OHNE vorherige Bearbeitungsschritte
     * 
     * @param alt
     *            das alte Etikett, d.h. die Repraesentation des vorherigen Verarbeitungsschritts, null bei
     *            neuem Etikett, das nicht durch Vorverarbeitung entstanden ist
     * 
     * @param laenge
     *            die Laenge des Holzstuecks
     */
    public AbstractHolz(AbstractHolz alt, int laenge) {
        this.alt = alt;
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

    public abstract AbstractHolz neu(Class<? extends AbstractHolz> clazz);
}
