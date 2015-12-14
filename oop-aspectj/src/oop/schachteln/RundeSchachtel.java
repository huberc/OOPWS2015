/**
 * Klasse zur Verwaltung runder Schachteln
 */

package oop.schachteln;

import oop.core.Geschenk;
import oop.core.Schachtel;
import oop.forms.Kreis;
import oop.forms.Sechseck;

public class RundeSchachtel extends Kreis implements Schachtel{

	private Geschenk inhalt;
	
	/**
	 * VB: hoehe, name und durchmesser sind nicht null und hoehe und durchmesser >0
	 * NB: eine RundeSchachtel mit den uebergebenen Parametern wurde erzeugt
	 * @param hoehe		Hoehe der zu erzeugenden Schachtel
	 * @param name		Name der zu erzeugenden Schachtel
	 * @param durchmesser	Durchmesser der zu erzeugenden Schachtel
	 */
	public RundeSchachtel(int hoehe, String name, int durchmesser) {
		super(hoehe,name,durchmesser);
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
	 * @return	boolean ob das uebergebene Geschenk in diese Schachtel passt und
	 * 			ob es nicht zu viel Platz hat
	 */
	@Override
	public boolean passtHinein(Geschenk g) {
		if(this.getHoehe() < g.getHoehe()+1 || (this.getHoehe() >= g.getHoehe()+3)){
			return false;
		}else if(g instanceof Kreis){
			Kreis k = (Kreis) g;
			if(this.getDurchmesser()>k.getDurchmesser()+1 && this.getDurchmesser() <= k.getDurchmesser()+3){
				return true;
			}else{
				return false;
			}
		}else if(g instanceof Sechseck){
			Sechseck s = (Sechseck) g;
			if(this.getDurchmesser() > s.getUmkreisDurchmesser()+1 && this.getDurchmesser() <= s.getUmkreisDurchmesser()+3){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
	public Geschenk getInhalt(){return inhalt;}
}
