/**
 * Kerze als Beispiel fuer ein Geschenk mit sechseckiger Grundflaeche
 */

package oop.main;
import oop.core.DevelopedBy;
import oop.forms.Sechseck;

@DevelopedBy("Ines Rieder")
public class SechseckigeKerze extends Sechseck{

	/**
	 * VB: hoehe, name und seitenlaenge sind nicht null, hoehe und seitenlaenge sind >0
	 * NB: eine Kerze mit den uebergebenen Parametern wurde erzeugt
	 * @param hoehe		Hoehe der zu erzeugenden Kerze
	 * @param name		Name der zu erzeugenden Kerze
	 * @param seitenlaenge	Seitenlaenge der zu erzeugenden Kerze
	 */
	@DevelopedBy("Ines Rieder")
	public SechseckigeKerze(int hoehe, String name, int seitenlaenge) {
		super(hoehe, name, seitenlaenge);
	}

}
