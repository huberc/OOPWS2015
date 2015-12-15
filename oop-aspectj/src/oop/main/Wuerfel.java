/**
 * Wuerfel als Beispiele fuer ein Geschenk mit quadratischen Grundflaechen
 */

package oop.main;
import oop.core.DevelopedBy;
import oop.forms.Quadrat;

@DevelopedBy("Ines Rieder")
public class Wuerfel extends Quadrat{

	/**
	 * VB: hoehe, name und seitenlaenge sind nicht null, hoehe und seitenlaenge sind >0
	 * NB: ein Wuerfel mit den uebergebenen Parametern wurde erzeugt
	 * @param hoehe		Hoehe des zu erzeugenden Wuerfels
	 * @param name		Name des zu erzeugenden Wuerfels
	 * @param seitenlaenge	Seitenlaenge des zu erzeugenden Wuerfels
	 */
	@DevelopedBy("Ines Rieder")
	public Wuerfel(int hoehe, String name, int seitenlaenge) {
		super(hoehe, name, seitenlaenge);
	}

}
