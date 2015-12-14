/**
 * Buecher als Beispiel fuer Geschenke mit rechteckiger Grundflaeche
 */

import forms.Rechteck;

public class Buecher extends Rechteck{

	/**
	 * VB: hoehe, name, breite und laenge sind nicht null, hoehe, breite und laenge sind >0
	 * NB: ein Buch mti den uebergebenen Parametern wurde erzeugt
	 * @param hoehe		Hoehe des zu erzeugenden Buches
	 * @param name		Name des zu erzeugenden Buches
	 * @param breite	Breite des zu erzeugenden Buches
	 * @param laenge	Laenge des zu erzeugenden Buches
	 */
	public Buecher(int hoehe, String name, int breite, int laenge) {
		super(hoehe, name, breite, laenge);
	}

}
