/**
 * Helper-Klasse, um sicherzustellen dass <code>Gemeinde</code>n und <code>Forstbetrieb</code>e global
 * einzigartige Namen besitzen. Der <code>UniqueNameProvider</code> kapselt eine Liste aller bereits bei
 * diesem <code>UniqueNameProvider</code> registrierten Namen. Bei Aufruf von <code>checkName</code> wird der
 * uebergebene Wert mit der Liste bereits benutzter Namen abgeglichen. NOTE: <code>UniqueNameProvider</code>
 * ist thread-safe
 * 
 * @author Michael Langowski, e1426581@student.tuwien.ac.at
 *
 */
public final class UniqueNameProvider {

    /**
     * Interne Liste aller bereits bei diesem Provider registrierten Namen.
     */
    private final CustomList registeredNames = new CustomList();

    /**
     * Ueberprueft ob ein Name bei diesem <code>UniqueNameProvider</code> bereits registriert ist (d.h. in der
     * Liste der verwendeten Namen existiert)
     * 
     * @param name
     *            der zu ueberpruefende Name
     * @return <code>true</code> falls der name bereits verwendet wird, sonst <code>false</code>
     */
    public final boolean nameUsed(final String name) {
        return this.registeredNames.contains(UniqueNameProvider.toListable(name));
    }

    /**
     * Registriert einen Namen als verwendet. Der uebergebene Wert wird damit in die Liste der bereits
     * registrierten Namen eingetragen
     * 
     * @param name
     *            der zu registrierende name
     */
    public void registerName(String name) {
        synchronized (this.registeredNames) {
            this.registeredNames.insert(UniqueNameProvider.toListable(name));
        }
    }

    /**
     * Interne Helper-Funktion, um <code>String</code>s in <code>Listable</code>s umzuwandeln
     * 
     * @param str
     *            <code>String</code>-Wert der als <code>Listable</code> dargestellt werden soll
     * @return eine neue Instanz eines anonym implementierten <code>Listable</code>, dessen
     *         <code>getName</code>-Methode <code>str</code> zurueckgibt
     */
    private static Listable toListable(final String str) {
        return new Listable() {

            @Override
            public String getName() {
                return str;
            }
        };
    }

}
