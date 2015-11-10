import java.util.HashMap;
import java.util.Map;

public class HolzFactory {

    private static final HolzFactory                                                                INSTANCE                        = new HolzFactory();

    private Map<Class<? extends AbstractHolz>, IHolzConverter<Rundholz, ? extends AbstractHolz>>    rundholzConverters              = new HashMap<>();
    private Map<Class<? extends AbstractHolz>, IHolzConverter<Energieholz, ? extends AbstractHolz>> energieholzConverters           = new HashMap<>();
    private Map<Class<? extends AbstractHolz>, IHolzConverter<Schnittholz, ? extends AbstractHolz>> schnittholzConverters           = new HashMap<>();

    // in saegeHelper benutzt, nicht in rundholzConverters wg korrektem Verhalten von neu
    private Map<Class<? extends AbstractHolz>, IHolzConverter<Rundholz, ? extends Schnittholz>>     rundholzToSchnittholzConverters = new HashMap<>();

    private HolzFactory() {
        this.initConverters();
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

    @SuppressWarnings("unchecked")
    public AbstractHolz[] saegeHelper(Rundholz input, Class<? extends AbstractHolz>... types) {
        AbstractHolz[] zersaegt = new AbstractHolz[types.length];
        AbstractHolz tmp = null;
        for (int i = 0; i < types.length; i++) {
            if (HolzFactory.isSubtypeOf(types[i], Energieholz.class)) {
                tmp = this.rundholzConverters.get(types[i]).createFrom(input);
                double volumen = input.laenge()
                                 * (Math.pow(input.getStaerke() * (1 / types.length) * (1 / types.length), 2) * Math.PI);
                ((Energieholz) tmp).setVolumen(volumen);
            } else if (HolzFactory.isSubtypeOf(types[i], Schnittholz.class)) {
                tmp = this.rundholzToSchnittholzConverters.get(types[i]).createFrom(input);
                int dicke = input.getStaerke() * (1 / types.length);
                ((Schnittholz) tmp).setDicke(dicke);
                ((Schnittholz) tmp).setBreite(input.getStaerke());
            } else {
                throw new IllegalArgumentException("Kann " + input.getClass().getSimpleName() + " nicht in "
                                                   + types[i].getSimpleName() + " zersaegen!");
            }
            zersaegt[i] = tmp;
        }
        return zersaegt;
    }

    private static boolean isSubtypeOf(Class<?> c1, Class<?> c2) {
        if (c1 == c2){
            return true;
        } else if (c1 == null) {
            return false;
        } else {
            return HolzFactory.isSubtypeOf(c1.getSuperclass(), c2);
        }
    }

    private void initConverters() {
        // Rundholz Converter
        this.rundholzConverters.put(Energieholz.class, new IHolzConverter<Rundholz, Energieholz>() {

            @Override
            public Energieholz createFrom(Rundholz input) {
                double volume = Math.pow(((double) input.getStaerke()) / 2.0, 2) * Math.PI
                                * (double) input.laenge();
                return new Energieholz(input.laenge(), volume);
            }

        });
        this.rundholzConverters.put(Rundholz.class, new IHolzConverter<Rundholz, Rundholz>() {

            @Override
            public Rundholz createFrom(Rundholz input) {
                return new Rundholz(input.laenge(), input.getStaerke());
            }

        });
        this.rundholzConverters.put(Industrieholz.class, new IHolzConverter<Rundholz, Industrieholz>() {

            @Override
            public Industrieholz createFrom(Rundholz input) {
                return new Industrieholz(input.laenge(), input.getStaerke());
            }

        });
        this.rundholzConverters.put(Saegerundholz.class, new IHolzConverter<Rundholz, Saegerundholz>() {

            @Override
            public Saegerundholz createFrom(Rundholz input) {
                return new Saegerundholz(input.laenge(), input.getStaerke());
            }

        });
        this.rundholzConverters.put(BauRundholz.class, new IHolzConverter<Rundholz, BauRundholz>() {

            @Override
            public BauRundholz createFrom(Rundholz input) {
                return new BauRundholz(input.laenge(), input.getStaerke());
            }

        });

        // Energieholz Converter
        this.energieholzConverters.put(Rundholz.class, new IHolzConverter<Energieholz, Rundholz>() {

            @Override
            public Rundholz createFrom(Energieholz input) {
                int staerke = (int) Math.round(Math.sqrt(input.getVolumen() / (Math.PI * input.laenge())));
                return new Rundholz(input.laenge(), staerke);
            }

        });
        this.energieholzConverters.put(Saegerundholz.class, new IHolzConverter<Energieholz, Saegerundholz>() {

            @Override
            public Saegerundholz createFrom(Energieholz input) {
                int staerke = (int) Math.round(Math.sqrt(input.getVolumen() / (Math.PI * input.laenge())));
                return new Saegerundholz(input.laenge(), staerke);
            }

        });
        this.energieholzConverters.put(Industrieholz.class, new IHolzConverter<Energieholz, Industrieholz>() {

            @Override
            public Industrieholz createFrom(Energieholz input) {
                int staerke = (int) Math.round(Math.sqrt(input.getVolumen() / (Math.PI * input.laenge())));
                return new Industrieholz(input.laenge(), staerke);
            }

        });
        this.energieholzConverters.put(BauRundholz.class, new IHolzConverter<Energieholz, BauRundholz>() {

            @Override
            public BauRundholz createFrom(Energieholz input) {
                int staerke = (int) Math.round(Math.sqrt(input.getVolumen() / (Math.PI * input.laenge())));
                return new BauRundholz(input.laenge(), staerke);
            }

        });
        this.energieholzConverters.put(Energieholz.class, new IHolzConverter<Energieholz, Energieholz>() {

            @Override
            public Energieholz createFrom(Energieholz input) {
                return new Energieholz(input.laenge(), input.getVolumen());
            }

        });

        // Schnittholz Converter
        this.schnittholzConverters.put(Schnittholz.class, new IHolzConverter<Schnittholz, Schnittholz>() {

            @Override
            public Schnittholz createFrom(Schnittholz input) {
                return new Schnittholz(input.laenge(), input.getDicke(), input.getBreite());
            }

        });
        this.schnittholzConverters.put(Vollkantschnittholz.class,
                new IHolzConverter<Schnittholz, Vollkantschnittholz>() {

                    @Override
                    public Vollkantschnittholz createFrom(Schnittholz input) {
                        return new Vollkantschnittholz(input.laenge(), input.getDicke(), input.getBreite());
                    }

                });
        this.schnittholzConverters.put(Brett.class, new IHolzConverter<Schnittholz, Brett>() {

            @Override
            public Brett createFrom(Schnittholz input) {
                return new Brett(input.laenge(), input.getDicke(), input.getBreite());
            }

        });
        this.schnittholzConverters.put(Kantholz.class, new IHolzConverter<Schnittholz, Kantholz>() {

            @Override
            public Kantholz createFrom(Schnittholz input) {
                return new Kantholz(input.laenge(), input.getDicke(), input.getBreite());
            }

        });
        this.schnittholzConverters.put(Energieholz.class, new IHolzConverter<Schnittholz, Energieholz>() {

            @Override
            public Energieholz createFrom(Schnittholz input) {
                return new Energieholz(input.laenge(), input.getBreite() * input.getDicke() * input.laenge());
            }

        });

        // rundholz to Schnittholz
        this.rundholzToSchnittholzConverters.put(Schnittholz.class,
                new IHolzConverter<Rundholz, Schnittholz>() {

                    @Override
                    public Schnittholz createFrom(Rundholz input) {
                        double grundflaeche = Math.pow((double) input.getStaerke() / 2.0, 2) * Math.PI;
                        return new Schnittholz(input.laenge(), (int) Math.round(Math.sqrt(grundflaeche)),
                                (int) Math.round(Math.sqrt(grundflaeche)));
                    }

                });
        this.rundholzToSchnittholzConverters.put(Vollkantschnittholz.class,
                new IHolzConverter<Rundholz, Vollkantschnittholz>() {

                    @Override
                    public Vollkantschnittholz createFrom(Rundholz input) {
                        double grundflaeche = Math.pow((double) input.getStaerke() / 2.0, 2) * Math.PI;
                        return new Vollkantschnittholz(input.laenge(), (int) Math.round(Math
                                .sqrt(grundflaeche)), (int) Math.round(Math.sqrt(grundflaeche)));
                    }

                });
        this.rundholzToSchnittholzConverters.put(Kantholz.class, new IHolzConverter<Rundholz, Kantholz>() {

            @Override
            public Kantholz createFrom(Rundholz input) {
                double grundflaeche = Math.pow((double) input.getStaerke() / 2.0, 2) * Math.PI;
                return new Kantholz(input.laenge(), (int) Math.round(Math.sqrt(grundflaeche)), (int) Math
                        .round(Math.sqrt(grundflaeche)));
            }

        });
        this.rundholzToSchnittholzConverters.put(Brett.class, new IHolzConverter<Rundholz, Brett>() {

            @Override
            public Brett createFrom(Rundholz input) {
                double grundflaeche = Math.pow((double) input.getStaerke() / 2.0, 2) * Math.PI;
                return new Brett(input.laenge(), (int) Math.round(Math.sqrt(grundflaeche)), (int) Math
                        .round(Math.sqrt(grundflaeche)));
            }

        });

    }

}
