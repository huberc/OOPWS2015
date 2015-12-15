/**
 * Klasse zur Verwaltung von Geschenken mit rechteckiger Grundflaeche
 */

package oop.forms;

import oop.core.DevelopedBy;
import oop.core.Einkaufstasche;
import oop.core.Geschenk;
import oop.core.Schachtellager;

@DevelopedBy("Christoph Huber")
public abstract class Rechteck extends Geschenk{
	
	private int breite, laenge;
	
	/**
	 * VB: hoehe, name, breite und laenge sind nicht null und hoehe, breite und laenge sind >0
	 * @param hoehe		Hoehe des zu erzeugenden rechteckigen Geschenks
	 * @param name		Name des zu erzeugenden rechteckigen Geschenks
	 * @param breite	Breite des zu erzeugenden rechteckigen Geschenks
	 * @param laenge	Laenge des zu erzeugenden rechteckigen Geschenks
	 */
	@DevelopedBy("Christoph Huber")
	public Rechteck(int hoehe, String name,int breite, int laenge) {
		super(hoehe, name);
		this.breite = breite;
		this.laenge = laenge;
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
	@DevelopedBy("Christoph Huber")
	public void verpackeGeschenk(Schachtellager l, Einkaufstasche e){
		l.verpackeRechteck(this,e);
	}
	
	@DevelopedBy("Christoph Huber")
	public int getLaenge(){return laenge;}
	
	@DevelopedBy("Christoph Huber")
	public int getBreite(){return breite;}
	
	/**
	 * VB: breite und laenge wurden initialisiert
	 * NB: Grundflaeche dieses rechteckigen Geschenks wurde zurueckgegeben
	 * @return	Grundflaeche dieses Geschenks
	 */
	@DevelopedBy("Christoph Huber")
	public double getFlaeche(){
		return breite*laenge;
	}
	
}
