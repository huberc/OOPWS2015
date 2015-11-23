/**
 * Interface zur Definition aller Typen, die in einer <code>CustomList</code> gespeichert werden koennen. Ein
 * <code>Listable</code> muss einen eindeutigen Namen definieren, der innerhalb einer <code>CustomList</code>
 * als Gleichheitskriterium verwendet werden kann. Implementierungen muessen die ueber entsprechende
 * Implementierungen von equals und hashCode sicherstellen
 * 
 */
public interface Listable {

    /**
     * Gibt den eindeutigen Namen eines <code>Listable</code> zurueck
     * 
     * @return den Namen (= Gleichheitskriterium) des <code>Listable</code>
     */
    String getName();

    /**
     * Vergleicht ein <code>Listable</code> mit einem anderen Objekt. Implementierungen von Listable muessen
     * equals entsprechend der oben festgelegten Kriterien (getName() identifiziert ein Listable)
     * ueberschreiben, die Methode ist im Interface als zusaetzliche Zusicherung explizit angegeben
     * 
     * @param o
     *            das Object, gegen das dieses Listable verglichen werden soll
     * @return true falls this und o den Bedingungen fuer Gleichheit (siehe oben) genuegen, sonst false
     */
    boolean equals(Object o);

    /**
     * Berechnet den eindeutigen Hash eines <code>Listable</code> basierend auf den oben festgelegten
     * Kriterien. Zwei <code>Listable</code>s haben gleiche hashCodes sonfern ihre Namen gleich sind (d.h.
     * gleiche HashCodes besitzen). Dieses Verhalten ist von Implementierungen sicherzustellen
     * 
     * @return einen eindeutigen Hash-Wert fuer dieses Listable. Zwei <code>Listable</code>s haben gleiche
     *         hashCodes sonfern ihre Namen gleich sind (d.h. gleiche HashCodes besitzen). Dieses Verhalten
     *         ist von Implementierungen sicherzustellen
     */
    int hashCode();

}
