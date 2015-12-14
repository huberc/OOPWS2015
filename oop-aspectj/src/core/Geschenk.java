/**
 * Klasse zur Verwaltung von Geschenken
 */

package core;

public abstract class Geschenk {

	private int hoehe;
	private String name;
	
	/**
	 * VB: hoehe und name sind nicht null, hoehe ist >0
	 * NB: ein Geschenk mit den uebergebenen Parametern wurde erzeugt
	 * @param hoehe	Hoehe des zu erzeugenden Geschenks
	 * @param name	Name des zu erzeugenden Geschenks
	 */
	public Geschenk(int hoehe, String name){
		this.hoehe = hoehe;
		this.name = name;
	}
	
	/**
	 * VB: getFlaeche ist in den Unterklasse ausprogrammiert
	 * NB: die Grundflaeche dieses Geschenks wurde zurueckgegeben
	 * @return	Grundflaeche dieses Geschenks
	 */
	public abstract double getFlaeche();
	
	/**
	 * VB: hoehe wurde initialisiert und getFlaeche in den Unterklassen ausprogrammiert
	 * NB: das Volumen dieses Geschenks wurde zurueckgegeben
	 * @return	Volumen dieses Geschenks
	 */
	public double volumen(){
		return getFlaeche() * hoehe;
	}
	
	/**
	 * 
	 * @param l	Schachtellager aus dem eine Schachtel zur Verpackung dieses Geschenks gesucht wird
	 * @param e	Einkaufstasche in die das verpackte Geschenk gelegt wird
	 */
	public abstract void verpackeGeschenk(Schachtellager l,Einkaufstasche e);
	
	public int getHoehe(){return hoehe;}
	
	public String getName(){return name;}
}
