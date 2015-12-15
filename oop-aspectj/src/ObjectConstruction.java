import oop.core.DevelopedBy;

/**
 * Aspekt zur Ueberwachung der Initialisierung von neuen Objekten zur Laufzeit
 * 
 * @author Michael Langowski
 *
 */
@DevelopedBy("Michael Langowski")
public aspect ObjectConstruction {

	/**
	 * Pointcut fuer das Erstellen eines Objektes einer selbst geschriebenen
	 * Klasse (= alles in oop.* packages) Note: Der Test selbst wird hierbei
	 * absichtlich nicht beruecksichtigt.
	 */
	pointcut objectConstruction() : initialization(oop..new(..));

	/**
	 * Pointcut fuer Ausfuehrung der Main-Methode
	 *
	 */
	pointcut mainMethodCall() : execution(public static void Test.main(String[]));

	private int objCount = 0;

	/**
	 * Wird nach dem fuer objectConstruction angegebenen join point ausgefuehrt,
	 * in diesem Fall wird der Objekt-Counter hochgesetzt
	 */
	@DevelopedBy("Michael Langowski")
	after() : objectConstruction(){
		// System.out.println("ASPECTJ: After new object creation: " +
		// thisJoinPoint);
		objCount++;
	}

	/**
	 * Wird nach Ausfuehrung der main-Methode, d.h. am Programmende ausgefuehrt,
	 * Ausgabe des Zaehlerstandes. NOTE: Zaehlerstand wird zurueckgesetzt, um
	 * korrekte Funktion bei Mehrfachausfuehrung von main innerhalb der gleichen
	 * JVM zu gewaehrleisten (denkbar zB bei automatischem Test)
	 */
	@DevelopedBy("Michael Langowski")
	after() : mainMethodCall(){
		System.out.println("Object construction aspect: Es wurden insgesamt " + objCount + " neue Objekte angelegt!");
		objCount = 0;
	}

}
