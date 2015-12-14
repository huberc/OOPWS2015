/**
 * Klasse zur Verwaltung von Einkaufstaschen
 */

package core;

import java.util.ArrayList;
import java.util.List;

public class Einkaufstasche {

	private List <Schachtel> einkaufstasche = new ArrayList<>();
	
	/**
	 * VB: s ist nicht null, List einkaufstasche wurde initialisiert
	 * @param s	Schachtel die dieser Einkaufstasche hinzugefuegt werden soll
	 */
	public void addSchachtel(Schachtel s){
		einkaufstasche.add(s);
	}

	/**
	 * VB: List einkaufstasche wurde initialisiert
	 * NB: Das Gesamtvolumen aller sich in dieser Tasche befindlichen Schachteln wurde zurueckgegeben
	 * @return	Gesamtvolumen aller in dieser Tasche befindlichen Schachteln
	 */
	public double volumen(){
		double volumen=0;
		for(int i=0;i<einkaufstasche.size();i++){
			volumen+= einkaufstasche.get(i).volumen();
		}
		return volumen;
	}
	
	/**
	 * VB: List einkaufstasche wurde initialisiert
	 * NB: der Inhalt dieser Einkaufstasche wurde in Form eines Strings zurueckgegeben
	 * @return	Inhalt dieser Einkaufstasche
	 */
	public String inhalt(){
		StringBuilder result = new StringBuilder();
		result.append("\tEinkaufstascheninhalt:\n");
		for(int i=0;i<einkaufstasche.size();i++){
			result.append("\t\t- die "+einkaufstasche.get(i).getName()+" beinhaltet "+einkaufstasche.get(i).getInhalt().getName()+"\n");
		}
		
		return result.toString();
	}

}
