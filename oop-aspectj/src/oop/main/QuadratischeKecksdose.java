/**
 * Keksdose als Beispiel fuer ein Geschenk mit quadratischen Grundflaechen
 */
package oop.main;
import oop.core.DevelopedBy;
import oop.forms.Quadrat;

@DevelopedBy("Ines Rieder")
public class QuadratischeKecksdose extends Quadrat{

	/**
	 * VB: hoehe, name und seitenlaenge sind nicht null, hoehe und seitenlaenge sind >0
	 * NB: eine Keksdose mit den uebergebenen Parametern wurde erzeugt
	 * @param hoehe		Hoehe der zu erzeugenden Keksdose
	 * @param name		Name der zu erzeugenden Keksdose
	 * @param seitenlaenge	Seitenlaenge der zu erzeugenden Keksdose
	 */
	@DevelopedBy("Ines Rieder")
	public QuadratischeKecksdose(int hoehe, String name, int seitenlaenge) {
		super(hoehe, name, seitenlaenge);
	}

}
