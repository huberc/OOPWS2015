/**
 * Klasse zur Verwaltung von sechseckigen Schachteln
 */

package schachteln;

import core.Geschenk;
import core.Schachtel;
import forms.Kreis;
import forms.Sechseck;

public class SechseckigeSchachtel extends Sechseck implements Schachtel{

	Geschenk inhalt; 
	
	/**
	 * VB: hoehe, name und seitenlaenge sind nicht null
	 * NB: eine SechseckigeSchachtel mit den uebergebenen Parametern wurde erzeugt
	 * @param hoehe		Hoehe der zu erzeugenden Schachtel
	 * @param name		Name der zu erzeugenden Schachtel
	 * @param seitenlaenge	Seitenlaenge der zu erzeugenden Schachtel
	 */
	public SechseckigeSchachtel(int hoehe, String name, int seitenlaenge) {
		super(hoehe, name, seitenlaenge);
	}

	/**
	 * VB: g ist nicht null
	 * NB: der Inhalt dieser Schachtel wurde auf g gesetzt
	 * @param g		Geschenk, das in dieser Schachtel eingepackt werden soll
	 */
	@Override
	public void einpacken(Geschenk g) {
		this.inhalt = g;
	}

	/**
	 * VB: g ist nicht null
	 * NB: ein boolean wurde zurueckgegeben ob das uebergebene Geschenk in diese Schachtel
	 * 		passt und ob es auch nicht zu viel Platz hat (damit es nicht verrutscht)
	 * @param g		Geschenk, dessen Parameter ueberprueft werden ob es in dieser Schachtel 
	 * 				Platz finden wuerde und ob es auch nicht zu viel Platz hat 
	 */
	@Override
	public boolean passtHinein(Geschenk g) {
		if ((this.getHoehe() < g.getHoehe()+1) || (this.getHoehe() > g.getHoehe()+3)) {
			return false;
		} else if (g instanceof Sechseck) {
			Sechseck s = (Sechseck) g;
			if ((this.getSeitenlaenge() > s.getSeitenlaenge()+1) && 
					(this.getSeitenlaenge() < s.getSeitenlaenge()+3)) {
				return true;
			} else {
				return false;
			}
		} else if (g instanceof Kreis) {
			Kreis k = (Kreis) g;
			if ((this.getInkreisDurchmesser() > k.getDurchmesser()+1) &&
					(this.getInkreisDurchmesser() < k.getDurchmesser()+3)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public Geschenk getInhalt(){return inhalt;}
	
}
