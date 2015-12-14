/**
 * Klasse zur Verwaltung des Schachtellagers
 */

package oop.core;

import java.util.ArrayList;
import java.util.List;

import oop.schachteln.QuadratischeSchachtel;
import oop.schachteln.RechteckigeSchachtel;
import oop.schachteln.RundeSchachtel;
import oop.schachteln.SechseckigeSchachtel;

public class Schachtellager {

	private List<Schachtel> rundeSchachteln = new ArrayList<>();
	private List<Schachtel> quadratischeSchachteln = new ArrayList<>();
	private List<Schachtel> rechteckigeSchachteln = new ArrayList<>();
	private List<Schachtel> sechseckigeSchachteln = new ArrayList<>();

	/**
	 * VB: r ist nicht null und rundeSchachteln wurde initialisiert
	 * NB: r wurde diesem Schachtellager hinzugefuegt
	 * @param r		runde Schachtel die diesem Schachtellager hinzugefuegt werden soll
	 */
	public void addRundeSchachtel(RundeSchachtel r){
		rundeSchachteln.add(r);
	}
	
	/**
	 * VB: q ist nicht null und quadratischeSchachteln wurde initialisiert
	 * NB: q wurde diesem Schachtellager hinzugefuegt
	 * @param q		quadratische Schachtel die diesem Schachtellager hinzugefuegt werden soll
	 */
	public void addQuadratischeSchachtel(QuadratischeSchachtel q){
		quadratischeSchachteln.add(q);
	}
	
	/**
	 * VB: r ist nicht null und rechteckigeSchachteln wurde initialisiert
	 * NB: r wurde diesem Schachtellager hinzugefuegt
	 * @param r		rechteckige Schachtel die diesem Schachtellager hinzugefuegt werden soll
	 */
	public void addRechteckigeSchachtel(RechteckigeSchachtel r){
		rechteckigeSchachteln.add(r);
	}
	
	/**
	 * VB: s ist nicht null und sechseckigeSchachteln wurde initialisiert
	 * NB: s wurde diesem Schachtellager hinzugefuegt
	 * @param s		sechseckige Schachtel die diesem Schachtellager hinzugefuegt werden soll
	 */
	public void addSechseckigeSchachtel(SechseckigeSchachtel s){
		sechseckigeSchachteln.add(s);
	}
	
	/**
	 * 
	 * @param g	
	 * @param e
	 */
	public void verpacke(Geschenk g, Einkaufstasche e) {
		g.verpackeGeschenk(this, e);
	}

	//TODO: sollte nicht das unverpackte Geschenk verkauft werden wenn
	//		keine passende Schachtel gefunden wird?
	public void verpackeKreis(Geschenk g, Einkaufstasche e) {
		Schachtel box = null;
		if (!rundeSchachteln.isEmpty()) {
			for (int i = 0; i < this.rundeSchachteln.size(); i++) {
				box = this.rundeSchachteln.get(i);
				if (box.passtHinein(g)) {
					break;
				}else{
					box = null;
				}
			}

		} else if (!quadratischeSchachteln.isEmpty()) {
			for (int i = 0; i < this.quadratischeSchachteln.size(); i++) {
				box = this.quadratischeSchachteln.get(i);
				if (box.passtHinein(g)) {
					System.out.println(
							"\tHinweis: es wurde keine passende runde Schachtel gefunden, daher wurde das Geschenk in eine passende quadratische Schachtel gegeben.");
					break;
				}else{
					box = null;
				}
			}

		} else if (!sechseckigeSchachteln.isEmpty()) {
			for (int i = 0; i < this.sechseckigeSchachteln.size(); i++) {
				box = this.sechseckigeSchachteln.get(i);
				if (box.passtHinein(g)) {
					System.out.println("\tHinweis: es wurde keine passende runde Schachtel gefunden, daher wurde das Geschenk in eine passende sechseckige Schachtel gegeben.");
					break;
				}else{
					box = null;
				}
			}

		}
		if (box != null) {
			box.einpacken(g);
			e.addSchachtel(box);
		} else {
			System.out.println("\tkeine passende Schachtel vorhanden");
		}
	}

	public void verpackeQuadrat(Geschenk g, Einkaufstasche e) {
		Schachtel box = null;
		if (!quadratischeSchachteln.isEmpty()) {
			for (int i = 0; i < this.quadratischeSchachteln.size(); i++) {
				box = this.quadratischeSchachteln.get(i);
				if (box.passtHinein(g)) {
					break;
				}else{
					box = null;
				}
			}

		}
		
		if (box != null) {
			box.einpacken(g);
			e.addSchachtel(box);
		} else {
			System.out.println("\tkeine passende Schachtel vorhanden");
		}

	}

	public void verpackeRechteck(Geschenk g, Einkaufstasche e) {
		Schachtel box = null;
		if (!rechteckigeSchachteln.isEmpty()) {
			for (int i = 0; i < this.rechteckigeSchachteln.size(); i++) {
				box = this.rechteckigeSchachteln.get(i);
				if (box.passtHinein(g)) {
					break;
				}else{
					box = null;
				}
			}
		}
		
		if (box != null) {
			box.einpacken(g);
			e.addSchachtel(box);
		} else {
			System.out.println("\tkeine passende Schachtel vorhanden");
		}
	}

	public void verpackeSechseck(Geschenk g, Einkaufstasche e) {
		Schachtel box = null;
		if (!sechseckigeSchachteln.isEmpty()) {
			for (int i = 0; i < this.sechseckigeSchachteln.size(); i++) {
				box = this.sechseckigeSchachteln.get(i);
				if (box.passtHinein(g)) {
					break;
				}else{
					box = null;
				}
			}

		}
		else if (!rundeSchachteln.isEmpty()) {
			for (int i = 0; i < this.rundeSchachteln.size(); i++) {
				box = this.rundeSchachteln.get(i);
				if (box.passtHinein(g)) {
					System.out.println("\tHinweis: es wurde keine passende sechseckige Schachtel gefunden, daher wurde das Geschenk in eine passende runde Schachtel gegeben.");
					break;
				}else{
					box = null;
				}
			}

		} else if (!rechteckigeSchachteln.isEmpty()) {
			for (int i = 0; i < this.rechteckigeSchachteln.size(); i++) {
				box = this.rechteckigeSchachteln.get(i);
				if (box.passtHinein(g)) {
					System.out.println(
							"\tHinweis: es wurde keine passende runde Schachtel gefunden, daher wurde das Geschenk in eine passende rechteckige Schachtel gegeben.");
					break;
				}else{
					box = null;
				}
			}

		}
		if (box != null) {
			box.einpacken(g);
			e.addSchachtel(box);
		} else {
			System.out.println("\tkeine passende Schachtel vorhanden");
		}


	}

}
