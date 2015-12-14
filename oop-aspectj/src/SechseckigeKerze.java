/**
 * Kerze als Beispiel fuer ein Geschenk mit sechseckiger Grundflaeche
 */

import forms.Sechseck;

public class SechseckigeKerze extends Sechseck{

	/**
	 * VB: hoehe, name und seitenlaenge sind nicht null, hoehe und seitenlaenge sind >0
	 * NB: eine Kerze mit den uebergebenen Parametern wurde erzeugt
	 * @param hoehe		Hoehe der zu erzeugenden Kerze
	 * @param name		Name der zu erzeugenden Kerze
	 * @param seitenlaenge	Seitenlaenge der zu erzeugenden Kerze
	 */
	public SechseckigeKerze(int hoehe, String name, int seitenlaenge) {
		super(hoehe, name, seitenlaenge);
	}

}
