import java.util.HashMap;
import java.util.Map;

public class HolzFactory {

    private static final HolzFactory                                                                INSTANCE              = new HolzFactory();

    private Map<Class<? extends AbstractHolz>, IHolzConverter<Rundholz, ? extends AbstractHolz>>    rundholzConverters    = new HashMap<>();
    private Map<Class<? extends AbstractHolz>, IHolzConverter<Energieholz, ? extends AbstractHolz>> energieholzConverters = new HashMap<>();
    private Map<Class<? extends AbstractHolz>, IHolzConverter<Schnittholz, ? extends AbstractHolz>> schnittholzConverters = new HashMap<>();

    // TODO Holzkonverter hierhin!

    private HolzFactory() {
        // Rundholz Converter
        this.rundholzConverters.put(Energieholz.class, new IHolzConverter<Rundholz, Energieholz>() {

            @Override
            public Energieholz createFrom(Rundholz input) {
                double volume = Math.pow(((double) input.getStaerke())/2.0, 2) * Math.PI * (double) input.laenge();
                return new Energieholz(input.laenge(), volume);
            }

        });
        this.rundholzConverters.put(Rundholz.class, new IHolzConverter<Rundholz, Rundholz>() {

            @Override
            public Rundholz createFrom(Rundholz input) {
                return new Rundholz(input.laenge(), input.getStaerke());
            }

        });
        this.rundholzConverters.put(Industrieholz.class, new IHolzConverter<Rundholz, Industrieholz>(){

            @Override
            public Industrieholz createFrom(Rundholz input) {
                return new Industrieholz(input.laenge(), input.getStaerke());
            }
            
        });
        this.rundholzConverters.put(Saegerundholz.class, new IHolzConverter<Rundholz, Saegerundholz>(){

            @Override
            public Saegerundholz createFrom(Rundholz input) {
                return new Saegerundholz(input.laenge(), input.getStaerke());
            }
            
        });
        this.rundholzConverters.put(BauRundholz.class, new IHolzConverter<Rundholz, BauRundholz>(){

            @Override
            public BauRundholz createFrom(Rundholz input) {
                return new BauRundholz(input.laenge(), input.getStaerke());
            }
            
        });
        
        // Energieholz Converter
        this.energieholzConverters.put(Rundholz.class, new IHolzConverter<Energieholz, Rundholz>(){

            @Override
            public Rundholz createFrom(Energieholz input) {
                int staerke = (int)Math.round(Math.sqrt(input.getVolumen()/(Math.PI*input.getLaenge())));
                return new Rundholz(input.getLaenge(), staerke);
            }
            
        });
        this.energieholzConverters.put(Saegerundholz.class, new IHolzConverter<Energieholz, Saegerundholz>(){

            @Override
            public Saegerundholz createFrom(Energieholz input) {
                int staerke = (int)Math.round(Math.sqrt(input.getVolumen()/(Math.PI*input.getLaenge())));
                return new Saegerundholz(input.getLaenge(), staerke);
            }
            
        });
        this.energieholzConverters.put(Industrieholz.class, new IHolzConverter<Energieholz, Industrieholz>(){

            @Override
            public Industrieholz createFrom(Energieholz input) {
                int staerke = (int)Math.round(Math.sqrt(input.getVolumen()/(Math.PI*input.getLaenge())));
                return new Industrieholz(input.getLaenge(), staerke);
            }
            
        });
        this.energieholzConverters.put(BauRundholz.class, new IHolzConverter<Energieholz, BauRundholz>(){

            @Override
            public BauRundholz createFrom(Energieholz input) {
                int staerke = (int)Math.round(Math.sqrt(input.getVolumen()/(Math.PI*input.getLaenge())));
                return new BauRundholz(input.getLaenge(), staerke);
            }
            
        });
        this.energieholzConverters.put(Energieholz.class, new IHolzConverter<Energieholz, Energieholz>(){

            @Override
            public Energieholz createFrom(Energieholz input) {
                return new Energieholz(input.getLaenge(), input.getVolumen());
            }
            
        });
        
        // Schnittholz Converter
        this.schnittholzConverters.put(key, value)
        
    }

    public static HolzFactory getInstance() {
        return HolzFactory.INSTANCE;
    }

    // NOTE: Beinahe identischer code zu createFrom<some holz> - 
    // Um Type-Safety Checking im Kompiliervorgang weitestgehend zu ermoeglichen trotzdem separate Methoden
    // -> Alternativen: Generics auf Level der Factory (Aufwand in keinem Verhaeltnis zum nutzen)
    //                  Methode createFrom mit AbstractHolz als Input - muesste Downcasts zum Delegieren benutzen, 
    //                  dadurch Type-Safety vom Compiler nicht pruefbar
    //   
    public AbstractHolz createFromRundholz(Rundholz input, Class<? extends AbstractHolz> targetType) {
        IHolzConverter<Rundholz, ? extends AbstractHolz> conv = this.rundholzConverters.get(targetType);
        if (conv != null) {
            return conv.createFrom(input);
        } else {
            throw new IllegalArgumentException("Kann nicht " + targetType.getSimpleName() + " aus "
                                               + input.getClass() + " erstellen!");
        }
    }

    public AbstractHolz createFromEnergieholz(Energieholz input, Class<? extends AbstractHolz> targetType) {
        IHolzConverter<Energieholz, ? extends AbstractHolz> conv = this.energieholzConverters.get(targetType);
        if (conv != null) {
            return conv.createFrom(input);
        } else {
            throw new IllegalArgumentException("Kann nicht " + targetType.getSimpleName() + " aus "
                                               + input.getClass() + " erstellen!");
        }
    }

    public AbstractHolz createFromSchnittholz(Schnittholz input, Class<? extends AbstractHolz> targetType) {
        IHolzConverter<Schnittholz, ? extends AbstractHolz> conv = this.schnittholzConverters.get(targetType);
        if (conv != null) {
            return conv.createFrom(input);
        } else {
            throw new IllegalArgumentException("Kann nicht " + targetType.getSimpleName() + " aus "
                                               + input.getClass() + " erstellen!");
        }
    }

}
