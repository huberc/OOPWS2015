/**
 * Vase als Beispiel fuer ein Geschenk mit sechseckiger Grundflaeche
 */

import forms.Sechseck;

public class SechseckigeVase extends Sechseck{

	/**
	 * VB: hoehe, name und seitenlaenge sind nicht null, hoehe und seitenlaenge sind >0
	 * NB: eine vase mit den uebergebenen Parametern wurde erzeugt
	 * @param hoehe		Hoehe der zu erzeugenden Vase
	 * @param name		Name der zu erzeugenden Vase
	 * @param seitenlaenge	Seitenlaenge der zu erzeugenden Vase
	 */
	public SechseckigeVase(int hoehe, String name, int seitenlaenge) {
		super(hoehe, name, seitenlaenge);
	}

}
