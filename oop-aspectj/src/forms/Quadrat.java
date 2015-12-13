/**
 * Klasse zur Verwaltung von Geschenken mit quadratischer Grundflaeche
 */

package forms;

import core.Einkaufstasche;
import core.Geschenk;
import core.Schachtellager;

public abstract class Quadrat extends Geschenk{
    
	private int seitenlaenge;
	
	/**
	 * VB: hoehe, name und seitenlaenge sind nicht null und hoehe und seitenlaenge sind >0
	 * NB: 
	 * @param hoehe		Hoehe des zu erzeugenden quadratischen Geschenks
	 * @param name		Name des zu erzeugenden quadratischen Geschenks
	 * @param seitenlaenge	Seitenlaenge des zu erzeugenden quadratischen Geschenks
	 */
	public Quadrat(int hoehe, String name,int seitenlaenge) {
		super(hoehe, name);
		this.seitenlaenge = seitenlaenge;
	}

	/**
	 * VB: l und e wurden initialisiert
	 * NB: dieses Geschenk wurde in einer passenden Schachtel aus dem uebergebenem 
	 * 		Schachtellager verpackt und in die uebergebene Einkauftsche gelegt
	 * @param l		Schachtellager aus dem die Schachtel zur Verpackung dieses 
	 * 				Geschenks genommen/ gesucht wird
	 * @param e		Einkaufstasche in die dieses Geschenk nach der Verpackung gelegt wird
	 */
	public void verpackeGeschenk(Schachtellager l,Einkaufstasche e){
		l.verpackeQuadrat(this,e);
	}
	
	/**
	 * VB: seitenlaenge wurde initialisiert
	 * NB: Grundflaeche dieses quadratischen Geschenks wurde zurueckgegeben
	 * @return	Grundflaeche dieses Geschenks
	 */
	public double getFlaeche(){
		return seitenlaenge*seitenlaenge;
	}
	
	public int getSeitenlaenge(){
		return seitenlaenge;
	}
	
}
