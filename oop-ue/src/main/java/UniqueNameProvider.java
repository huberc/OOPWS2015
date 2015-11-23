/**
 * Helper-Klasse, um sicherzustellen dass <code>Gemeinde</code>n und <code>Forstbetrieb</code>e global
 * einzigartige Namen besitzen. Der <code>UniqueNameProvider</code> kapselt eine Liste aller bereits bei
 * diesem <code>UniqueNameProvider</code> registrierten Namen. Bei Aufruf von <code>checkName</code> wird der
 * uebergebene Wert mit der Liste bereits benutzter Namen abgeglichen.
 * 
 * @author Michael Langowski, e1426581@student.tuwien.ac.at
 *
 */
public final class UniqueNameProvider {

    private final CustomList customList = new CustomList();

    public final boolean checkName(final String name) {
        return this.customList.contains(UniqueNameProvider.toListable(name));
    }

    private static Listable toListable(final String str) {
        return new Listable() {

            @Override
            public String getName() {
                return str;
            }
        };
    }

}
