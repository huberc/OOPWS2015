/**
 * Klasse zur Verwaltung von Einkaufstaschen
 */

package oop.core;

import java.util.ArrayList;
import java.util.List;

@DevelopedBy("Christoph Huber")
public class Einkaufstasche {

    private List<Geschenk>  einkaufstasche1 = new ArrayList<>();
    private List<Schachtel> einkaufstasche2 = new ArrayList<>();

    /**
	 * VB: s ist nicht null, List einkaufstasche1 wurde initialisiert
	 * NB: s wurde dieser Einkaufstasche hinzugefuegt
	 * @param s	Geschenk das dieser Einkaufstasche hinzugefuegt werden soll
	 */
    @DevelopedBy("Christoph Huber")
    public void addGeschenk(Geschenk s) {
        einkaufstasche1.add(s);
    }

    /**
     * VB: box ist nicht null, einkaufstasche2 wurde initialisiert
     * NB: box wurde dieser Einkaufstasche hinzugefuegt
     * @param box	Schachtel die dieser Einkauftasche hinzugefuegt werden soll
     */
    @DevelopedBy("Christoph Huber")
    public void addSchachtel(Schachtel box) {
        einkaufstasche2.add(box);
    }

    /**
	 * VB: List einkaufstasche wurde initialisiert
	 * NB: Das Gesamtvolumen aller sich in dieser Tasche befindlichen Schachteln/Geschenke wurde zurueckgegeben
	 * @return	Gesamtvolumen aller in dieser Tasche befindlichen Schachteln/Geschenke
	 */
    @DevelopedBy("Christoph Huber")
    public double volumen() {
        double volumen = 0;
        for (int i = 0; i < einkaufstasche2.size(); i++) {
            volumen += einkaufstasche2.get(i).volumen();
        }
        for (int i = 0; i < einkaufstasche1.size(); i++) {
            volumen += einkaufstasche1.get(i).volumen();
        }
        return volumen;
    }

    /**
	 * VB: List einkaufstasche wurde initialisiert
	 * NB: der Inhalt dieser Einkaufstasche wurde in Form eines Strings zurueckgegeben
	 * @return	Inhalt dieser Einkaufstasche
	 */
    @DevelopedBy("Christoph Huber")
    public String inhalt() {
        StringBuilder result = new StringBuilder();
        result.append("\tEinkaufstascheninhalt:\n");
        for (int i = 0; i < einkaufstasche2.size(); i++) {
            result.append("\t\t- die " + einkaufstasche2.get(i).getName() + " beinhaltet "
                          + einkaufstasche2.get(i).getInhalt().getName() + "\n");
        }

        for (int i = 0; i < einkaufstasche1.size(); i++) {
            result.append("\t\t- "
                          + einkaufstasche1.get(i).getName()
                          + " wurde aufgrund keiner passenden Schachtel im Schachtellager unverpackt verkauft\n");
        }
        return result.toString();
    }
}
