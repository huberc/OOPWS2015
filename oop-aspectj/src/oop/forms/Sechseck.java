/**
 * Klasse zur Verwaltung von Geschenken mit sechseckiger Grundflaeche
 */

package oop.forms;

import oop.core.Einkaufstasche;
import oop.core.Geschenk;
import oop.core.Schachtellager;

public abstract class Sechseck extends Geschenk {
	private int seitenlaenge;
	
	/**
	 * VB: hoehe, name und seitenlaenge wurden initialisiert und hoehe und seitenlaenge sind >0
	 * @param hoehe		Hoehe des zu erzeugenden sechseckigen Geschenks
	 * @param name		Name Hoehe des zu erzeugenden sechseckigen Geschenks
	 * @param seitenlaenge	Seitenlaenge Hoehe des zu erzeugenden sechseckigen Geschenks
	 */
	public Sechseck(int hoehe, String name,int seitenlaenge) {
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
	public void verpackeGeschenk(Schachtellager l,Einkaufstasche e) {
		 l.verpackeSechseck(this,e);
	}
	
	/**
	 * VB: seitenlaenge wurde initialisiert
	 * NB: Grundflaeche dieses sechseckigen Geschenks wurde zurueckgegeben
	 * @return	Grundflaeche deses Geschenks
	 */
	public double getFlaeche(){
		return seitenlaenge*seitenlaenge*3/2*Math.sqrt(3);
	}
	
	public int getSeitenlaenge(){
		return this.seitenlaenge;
	}
	
	/**
	 * VB: seitenlaenge wurde initialisiert
	 * NB: Inkreisdurchmesser der Grundflaeche dieses rechteckigen Geschenks wurde zurueckgegeben
	 * @return	Inkreisdurchmesser der Grundflaeche dieses Geschenks
	 */
	public double getInkreisDurchmesser(){
		return seitenlaenge*Math.sqrt(3);
	}
	
	/**
	 * VB: seitenlaenge wurde initialisiert
	 * NB: Umkreisradius der Grundflaeche dieses rechteckigen Geschenks wurde zurueckgegeben
	 * @return Umkreisradius der Grundflaeche deses rechteckigen Geschenks
	 */
	public double getUmkreisDurchmesser(){
		return 2.0*seitenlaenge;
	}
}
