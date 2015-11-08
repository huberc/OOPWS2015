import java.util.HashMap;
import java.util.Map;

public class Rundholz extends AbstractHolz {

    private static final Map<Class<? extends AbstractHolz>, IHolzConverter<Rundholz, ? extends AbstractHolz>> CONVERTERS = new HashMap<>();

    static {
        Rundholz.CONVERTERS.put(Rundholz.class, new IHolzConverter<Rundholz, Rundholz>() {

            @Override
            public Rundholz createFrom(Rundholz input) {
                return new Rundholz(input, input.laenge(), input.staerke);
            }

        });
        Rundholz.CONVERTERS.put(Energieholz.class, new IHolzConverter<Rundholz, Energieholz>() {

            @Override
            public Energieholz createFrom(Rundholz input) {
                return new Energieholz(input.laenge(), Math.pow((double) input.staerke, 2) * Math.PI
                                                       * (double) input.laenge());
            }

        });
    }

    public Rundholz(Rundholz alt, int laenge, int staerke) {
        super(alt, laenge);
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
    public AbstractHolz neu(Class<? extends AbstractHolz> clazz) {

        return null;
    }

}
