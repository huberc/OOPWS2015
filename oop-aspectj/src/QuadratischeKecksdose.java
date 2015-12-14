/**
 * Keksdose als Beispiel fuer ein Geschenk mit quadratischen Grundflaechen
 */
import forms.Quadrat;

public class QuadratischeKecksdose extends Quadrat{

	/**
	 * VB: hoehe, name und seitenlaenge sind nicht null, hoehe und seitenlaenge sind >0
	 * NB: eine Keksdose mit den uebergebenen Parametern wurde erzeugt
	 * @param hoehe		Hoehe der zu erzeugenden Keksdose
	 * @param name		Name der zu erzeugenden Keksdose
	 * @param seitenlaenge	Seitenlaenge der zu erzeugenden Keksdose
	 */
	public QuadratischeKecksdose(int hoehe, String name, int seitenlaenge) {
		super(hoehe, name, seitenlaenge);
	}

}
