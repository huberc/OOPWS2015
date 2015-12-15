/**
 * Klasse zur Verwaltung von Geschenken die eine runde Grundflaeche besitzen
 */

package oop.forms;

import oop.core.DevelopedBy;
import oop.core.Einkaufstasche;
import oop.core.Geschenk;
import oop.core.Schachtellager;

@DevelopedBy("Michael Langowski")
public abstract class Kreis extends Geschenk{
	private int durchmesser;
	
	/**
	 * VB: hoehe, name und durchmesser sind nicht null und hoehe und durchmesser >0
	 * NB: ein rundes Geschenk wurden mit den uebergebenen Parametern erzeugt
	 * @param hoehe		Hoehe des zuerzeugenden runden Geschenks
	 * @param name		Name des zuerzeugenden runden Geschenks
	 * @param durchmesser Durchmesser des zuerzeugenden runden Geschenks
	 */
	@DevelopedBy("Michael Langowski")
	public Kreis(int hoehe, String name, int durchmesser){
		super(hoehe, name);
		this.durchmesser = durchmesser;
	}
	
	/**
	 * VB: durchmesser wurde initialisiert
	 * NB: die Grundflaeche dieses runden Geschenks wurde zurueckgegeben
	 * @return	Grundlaeche dieses Geschenks
	 */
	@DevelopedBy("Michael Langowski")
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
	@DevelopedBy("Michael Langowski")
	public void verpackeGeschenk(Schachtellager l,Einkaufstasche e){
		l.verpackeKreis(this, e);
	}
	
	@DevelopedBy("Michael Langowski")
	public int getDurchmesser(){return durchmesser;}
	
}
