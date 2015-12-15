/**
 * Klasse zur Verwaltung von Geschenken
 */

package oop.core;

@DevelopedBy("Ines Rieder, Christoph Huber")
public abstract class Geschenk {

	private int hoehe;
	private String name;
	
	/**
	 * VB: hoehe und name sind nicht null, hoehe ist >0
	 * NB: ein Geschenk mit den uebergebenen Parametern wurde erzeugt
	 * @param hoehe	Hoehe des zu erzeugenden Geschenks
	 * @param name	Name des zu erzeugenden Geschenks
	 */
	@DevelopedBy("Ines Rieder")
	public Geschenk(int hoehe, String name){
		this.hoehe = hoehe;
		this.name = name;
	}
	
	/**
	 * VB: getFlaeche ist in den Unterklasse ausprogrammiert
	 * NB: die Grundflaeche dieses Geschenks wurde zurueckgegeben
	 * @return	Grundflaeche dieses Geschenks
	 */
	@DevelopedBy("Ines Rieder")
	public abstract double getFlaeche();
	
	/**
	 * VB: hoehe wurde initialisiert und getFlaeche in den Unterklassen ausprogrammiert
	 * NB: das Volumen dieses Geschenks wurde zurueckgegeben
	 * @return	Volumen dieses Geschenks
	 */
	@DevelopedBy("Ines Rieder")
	public double volumen(){
		return getFlaeche() * hoehe;
	}
	
	/**
	 * VB: l und e wurden initialisiert
	 * NB: dieses Geschenk wurde in einer passenden Schachtel aus dem uebergebenem 
	 * 		Schachtellager verpackt und in die uebergebene Einkauftsche gelegt
	 * @param l	Schachtellager aus dem eine Schachtel zur Verpackung dieses Geschenks gesucht wird
	 * @param e	Einkaufstasche in die das verpackte Geschenk gelegt wird
	 */
	@DevelopedBy("Christoph Huber")
	public abstract void verpackeGeschenk(Schachtellager l,Einkaufstasche e);
	
	@DevelopedBy("Christoph Huber")
	public int getHoehe(){return hoehe;}
	
	@DevelopedBy("Christoph Huber")
	public String getName(){return name;}
}
