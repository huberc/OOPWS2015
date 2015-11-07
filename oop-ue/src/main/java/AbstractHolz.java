import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractHolz implements Etikett {

    protected static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    private int                             laenge;
    private String                          datum;
    private Etikett                         alt;

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
    
    public abstract AbstractHolz neu();

}
