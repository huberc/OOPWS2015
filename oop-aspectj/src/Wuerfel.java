/**
 * Wuerfel als Beispiele fuer ein Geschenk mit quadratischen Grundflaechen
 */

import forms.Quadrat;

public class Wuerfel extends Quadrat{

	/**
	 * VB: hoehe, name und seitenlaenge sind nicht null, hoehe und seitenlaenge sind >0
	 * NB: ein Wuerfel mit den uebergebenen Parametern wurde erzeugt
	 * @param hoehe		Hoehe des zu erzeugenden Wuerfels
	 * @param name		Name des zu erzeugenden Wuerfels
	 * @param seitenlaenge	Seitenlaenge des zu erzeugenden Wuerfels
	 */
	public Wuerfel(int hoehe, String name, int seitenlaenge) {
		super(hoehe, name, seitenlaenge);
	}

}
