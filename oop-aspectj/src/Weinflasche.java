/**
 * Weinflasche als Beispiel fuer ein Geschenk mit runder Grundflaeche
 */

import forms.Kreis;

public class Weinflasche extends Kreis {
	
	/**
	 * VB: hoehe, name und durchmesser sind nicht null, hoehe und durchmesser sind >0
	 * NB: eine Weinflasche mit den uebergebenen Parametern wurde erzeugt
	 * @param hoehe		Hoehe der zu erzeugenden Weinflasche
	 * @param name		Name der zu erzeugenden Weinfalsche
	 * @param durchmesser	Durchmesser der zu erzeugenden Weinfalsche
	 */
	public Weinflasche(int hoehe, String name, int durchmesser){
		super(hoehe, name,durchmesser);
	}

}
