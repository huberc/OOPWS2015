/**
 * Lebkuchenhaus als Beispiel fuer ein Geschenk mit rechteckiger Grundflaeche
 */

import forms.Rechteck;

public class RechteckigesLebkuchenhaus extends Rechteck {

	/**
	 * VB: hoehe, name, breite und laenge sind nicht null, hoehe, breite und laenge sind >0
	 * NB: ein Lebkuchenhaus mit den uebergebenen Parametern wurde erzeugt
	 * @param hoehe		Hoehe des zu erzeugenden Lebkuchenhauses
	 * @param name		Name des zu erzeugenden Lebkuchenhauses
	 * @param breite	Breite des zu erzeugenden Lebkuchenhauses
	 * @param laenge	Laenge des zu erzeugenden Lebkuchenhauses
	 */
	public RechteckigesLebkuchenhaus(int hoehe, String name, int breite, int laenge) {
		super(hoehe, name, breite, laenge);
	}

}
