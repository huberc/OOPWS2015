/**
 * Klasse zur Verwaltung von Geschenken die eine runde Grundflaeche besitzen
 */

package forms;

import core.Einkaufstasche;
import core.Geschenk;
import core.Schachtellager;

public abstract class Kreis extends Geschenk{
	private int durchmesser;
	
	/**
	 * VB: hoehe, name und durchmesser sind nicht null und hoehe und durchmesser >0
	 * NB: ein rundes Geschenk wurden mit den uebergebenen Parametern erzeugt
	 * @param hoehe		Hoehe des zuerzeugenden runden Geschenks
	 * @param name		Name des zuerzeugenden runden Geschenks
	 * @param durchmesser Durchmesser des zuerzeugenden runden Geschenks
	 */
	public Kreis(int hoehe, String name, int durchmesser){
		super(hoehe, name);
		this.durchmesser = durchmesser;
	}
	
	/**
	 * VB: durchmesser wurde initialisiert
	 * NB: die Grundflaeche dieses runden Geschenks wurde zurueckgegeben
	 * @return	Grundlaeche dieses Geschenks
	 */
	public double getFlaeche(){
		return ((Math.PI*durchmesser*durchmesser)/4);
	}
	
	/**
	 * VB: l und e wurden initialisiert
	 * NB: dieses Geschenk wurde in einer passenden Schachtel aus dem uebergebenem 
	 * 		Schachtellager verpackt und in die uebergebene Einkauftsche gelegt
	 * @param l		Schachtellager aus dem die Schachtel zur Verpackung dieses 
	 * 				Geschenks genommen/ gesucht wird
	 * @param e		Einkaufstasche in die dieses Geschenk nach der Verpackung gelegt wird
	 */
	@Override
	public void verpackeGeschenk(Schachtellager l,Einkaufstasche e){
		l.verpackeKreis(this, e);
	}
	
	public int getDurchmesser(){return durchmesser;}
	
}
