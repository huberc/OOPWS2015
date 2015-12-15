/**
 * Klasse zur Verwaltung von Geschenken mit quadratischer Grundflaeche
 */

package oop.forms;

import oop.core.DevelopedBy;
import oop.core.Einkaufstasche;
import oop.core.Geschenk;
import oop.core.Schachtellager;

@DevelopedBy("Ines Rieder")
public abstract class Quadrat extends Geschenk{
    
	private int seitenlaenge;
	
	/**
	 * VB: hoehe, name und seitenlaenge sind nicht null und hoehe und seitenlaenge sind >0
	 * NB: 
	 * @param hoehe		Hoehe des zu erzeugenden quadratischen Geschenks
	 * @param name		Name des zu erzeugenden quadratischen Geschenks
	 * @param seitenlaenge	Seitenlaenge des zu erzeugenden quadratischen Geschenks
	 */
	@DevelopedBy("Ines Rieder")
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
	@DevelopedBy("Ines Rieder")
	public void verpackeGeschenk(Schachtellager l,Einkaufstasche e){
		l.verpackeQuadrat(this,e);
	}
	
	/**
	 * VB: seitenlaenge wurde initialisiert
	 * NB: Grundflaeche dieses quadratischen Geschenks wurde zurueckgegeben
	 * @return	Grundflaeche dieses Geschenks
	 */
	@DevelopedBy("Ines Rieder")
	public double getFlaeche(){
		return seitenlaenge*seitenlaenge;
	}
	
	@DevelopedBy("Ines Rieder")
	public int getSeitenlaenge(){
		return seitenlaenge;
	}
	
}
