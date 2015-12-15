/**
 * Baelle als Beispiel fuer Geschenke mit runder Grundflaeche
 */

package oop.main;
import oop.core.DevelopedBy;
import oop.forms.Kreis;

@DevelopedBy("Ines Rieder")
public class Baelle extends Kreis{
	
	/**
	 * VB: hoehe, name und durchmesser sind nicht null, hoehe und durchmesser sind >0
	 * NB: ein Ball mit den uebergebenen Parametern wurde erzeugt
	 * @param hoehe		Hoehe des zu erzeugenden Balls
	 * @param name		Name des zu erzeugenden Balls
	 * @param durchmesser	Durchmesser des zu erzeugenden Balls
	 */
	@DevelopedBy("Ines Rieder")
	public Baelle(int hoehe, String name, int durchmesser){
		super(hoehe,name, durchmesser);
	}

}
