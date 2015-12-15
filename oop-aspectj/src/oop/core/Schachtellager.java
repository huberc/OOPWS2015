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

@DevelopedBy("Michael Langowski, Christoph Huber")
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
	@DevelopedBy("Michael Langowski")
	public void addRundeSchachtel(RundeSchachtel r) {
		rundeSchachteln.add(r);
	}

	/**
	 * VB: q ist nicht null und quadratischeSchachteln wurde initialisiert
	 * NB: q wurde diesem Schachtellager hinzugefuegt
	 * @param q		quadratische Schachtel die diesem Schachtellager hinzugefuegt werden soll
	 */
	@DevelopedBy("Michael Langowski")
	public void addQuadratischeSchachtel(QuadratischeSchachtel q) {
		quadratischeSchachteln.add(q);
	}

	/**
	 * VB: r ist nicht null und rechteckigeSchachteln wurde initialisiert
	 * NB: r wurde diesem Schachtellager hinzugefuegt
	 * @param r		rechteckige Schachtel die diesem Schachtellager hinzugefuegt werden soll
	 */
	@DevelopedBy("Michael Langowski")
	public void addRechteckigeSchachtel(RechteckigeSchachtel r) {
		rechteckigeSchachteln.add(r);
	}

	/**
	 * VB: s ist nicht null und sechseckigeSchachteln wurde initialisiert
	 * NB: s wurde diesem Schachtellager hinzugefuegt
	 * @param s		sechseckige Schachtel die diesem Schachtellager hinzugefuegt werden soll
	 */
	@DevelopedBy("Michael Langowski")
	public void addSechseckigeSchachtel(SechseckigeSchachtel s) {
		sechseckigeSchachteln.add(s);
	}

	/**
	 * VB: g und e sind nicht null
	 * NB: Das Geschenk g wurde in einer Schachtel aus diesem Schachtellager verpackt
	 * 		und der Einkaufstasche e hinzugefuegt
	 * @param g	Geschenk, das in einer Schachtel aus diesem Schachtellager verpackt werden soll
	 * @param e Einkaufstasche in die das Geschenk g nach der Verpackung gelegt werden soll
	 */
	@DevelopedBy("Christoph Huber")
	public void verpacke(Geschenk g, Einkaufstasche e) {
		g.verpackeGeschenk(this, e);
	}

	/**
	 * VB: g und e sind nicht null, g ist eine Unterklasse von Kreis
	 * NB: Das Geschenk g wurde in einer Schachtel aus diesem Schachtellager verpackt
	 * 		und der Einkaufstasche hinzugefuegt
	 * @param g	rundes Geschenk, das in einer Schachtel aus diesem Schachtellager verpackt werden soll
	 * @param e Einkaufstasche in die das Geschenk g nach der Verpackung gelegt werden soll
	 */
	@DevelopedBy("Christoph Huber")
	public void verpackeKreis(Geschenk g, Einkaufstasche e) {
		Schachtel box = null;
		if (!rundeSchachteln.isEmpty()) {
			for (int i = 0; i < this.rundeSchachteln.size(); i++) {
				box = this.rundeSchachteln.get(i);
				if (box.passtHinein(g)) {
					break;
				} else {
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
				} else {
					box = null;
				}
			}

		} else if (!sechseckigeSchachteln.isEmpty()) {
			for (int i = 0; i < this.sechseckigeSchachteln.size(); i++) {
				box = this.sechseckigeSchachteln.get(i);
				if (box.passtHinein(g)) {
					System.out.println(
							"\tHinweis: es wurde keine passende runde Schachtel gefunden, daher wurde das Geschenk in eine passende sechseckige Schachtel gegeben.");
					break;
				} else {
					box = null;
				}
			}

		}
		if (box != null) {
			box.einpacken(g);
			e.addSchachtel(box);
		} else {
			e.addGeschenk(g);
			System.out.println("\tHinweis: keine passende Schachtel vorhanden, Geschenk wird unverpackt verkauft.");
		}
	}

	/**
	 * VB: g und e sind nicht null, g ist eine Unterklasse von Quadrat
	 * NB: Das Geschenk g wurde in einer Schachtel aus diesem Schachtellager verpackt
	 * 		und der Einkaufstasche hinzugefuegt
	 * @param g	quadratisch Geschenk, das in einer Schachtel aus diesem Schachtellager verpackt werden soll
	 * @param e Einkaufstasche in die das Geschenk g nach der Verpackung gelegt werden soll
	 */
	@DevelopedBy("Christoph Huber")
	public void verpackeQuadrat(Geschenk g, Einkaufstasche e) {
		Schachtel box = null;
		if (!quadratischeSchachteln.isEmpty()) {
			for (int i = 0; i < this.quadratischeSchachteln.size(); i++) {
				box = this.quadratischeSchachteln.get(i);
				if (box.passtHinein(g)) {
					break;
				} else {
					box = null;
				}
			}

		}

		if (box != null) {
			box.einpacken(g);
			e.addSchachtel(box);
		} else {
			e.addGeschenk(g);
			System.out.println("\tHinweis: keine passende Schachtel vorhanden, Geschenk wird unverpackt verkauft.");
		}

	}

	/**
	 * VB: g und e sind nicht null, g ist eine Unterklasse von Rechteck
	 * NB: Das Geschenk g wurde in einer Schachtel aus diesem Schachtellager verpackt
	 * 		und der Einkaufstasche hinzugefuegt
	 * @param g	rechteckige Geschenk, das in einer Schachtel aus diesem Schachtellager verpackt werden soll
	 * @param e Einkaufstasche in die das Geschenk g nach der Verpackung gelegt werden soll
	 */
	@DevelopedBy("Christoph Huber")
	public void verpackeRechteck(Geschenk g, Einkaufstasche e) {
		Schachtel box = null;
		if (!rechteckigeSchachteln.isEmpty()) {
			for (int i = 0; i < this.rechteckigeSchachteln.size(); i++) {
				box = this.rechteckigeSchachteln.get(i);
				if (box.passtHinein(g)) {
					break;
				} else {
					box = null;
				}
			}
		}

		if (box != null) {
			box.einpacken(g);
			e.addSchachtel(box);
		} else {
			e.addGeschenk(g);
			System.out.println("\tHinweis: keine passende Schachtel vorhanden, Geschenk wird unverpackt verkauft.");
		}
	}

	/**
	 * VB: g und e sind nicht null, g ist eine Unterklasse von Sechseck
	 * NB: Das Geschenk g wurde in einer Schachtel aus diesem Schachtellager verpackt
	 * 		und der Einkaufstasche hinzugefuegt
	 * @param g	sechseckiges Geschenk, das in einer Schachtel aus diesem Schachtellager verpackt werden soll
	 * @param e Einkaufstasche in die das Geschenk g nach der Verpackung gelegt werden soll
	 */
	@DevelopedBy("Christoph Huber")
	public void verpackeSechseck(Geschenk g, Einkaufstasche e) {
		Schachtel box = null;
		if (!sechseckigeSchachteln.isEmpty()) {
			for (int i = 0; i < this.sechseckigeSchachteln.size(); i++) {
				box = this.sechseckigeSchachteln.get(i);
				if (box.passtHinein(g)) {
					break;
				} else {
					box = null;
				}
			}

		} else if (!rundeSchachteln.isEmpty()) {
			for (int i = 0; i < this.rundeSchachteln.size(); i++) {
				box = this.rundeSchachteln.get(i);
				if (box.passtHinein(g)) {
					System.out.println(
							"\tHinweis: es wurde keine passende sechseckige Schachtel gefunden, daher wurde das Geschenk in eine passende runde Schachtel gegeben.");
					break;
				} else {
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
				} else {
					box = null;
				}
			}

		}
		if (box != null) {
			box.einpacken(g);
			e.addSchachtel(box);
		} else {
			e.addGeschenk(g);
			System.out.println("\tHinweis: keine passende Schachtel vorhanden, Geschenk wird unverpackt verkauft.");
		}

	}

}
