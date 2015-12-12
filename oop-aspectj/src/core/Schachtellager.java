package core;

import java.util.ArrayList;
import java.util.List;

import schachteln.RechteckigeSchachtel;
import schachteln.RundeSchachtel;

public class Schachtellager {

	private List<Schachtel> rundeSchachteln = new ArrayList<>();
	private List<Schachtel> quadratischeSchachteln = new ArrayList<>();
	private List<Schachtel> rechteckigeSchachteln = new ArrayList<>();
	private List<Schachtel> sechseckigeSchachteln = new ArrayList<>();

	public void addRundeSchachtel(RundeSchachtel r){
		rundeSchachteln.add(r);
	}
	
	public void addQuadratischeSchachtel(QuadratischeSchachtel q){
		quadratischeSchachteln.add(q);
	}
	
	public void addRechteckigeSchachtel(RechteckigeSchachtel r){
		rechteckigeSchachteln.add(r);
	}
	
	public void addSechseckigeSchachtel(SechseckigeSchachtel s){
		sechseckigeSchachteln.add(s);
	}
	
	
	public void verpacke(Geschenk g, Einkaufstasche e) {
		g.verpackeGeschenk(this, e);
	}

	public void verpackeKreis(Geschenk g, Einkaufstasche e) {
		Schachtel box = null;
		if (!rundeSchachteln.isEmpty()) {
			for (int i = 0; i < this.rundeSchachteln.size(); i++) {
				box = this.rundeSchachteln.get(i);
				if (box.passtHinein(g)) {
					break;
				}
			}

		} else if (!quadratischeSchachteln.isEmpty()) {
			for (int i = 0; i < this.quadratischeSchachteln.size(); i++) {
				box = this.quadratischeSchachteln.get(i);
				if (box.passtHinein(g)) {
					System.out.println(
							"\tHinweis: es wurde keine passende runde Schachtel gefunden, daher wurde das Geschenk in eine passende quadratische Schachtel gegeben.");
					break;
				}
			}

		} else if (!sechseckigeSchachteln.isEmpty()) {
			for (int i = 0; i < this.sechseckigeSchachteln.size(); i++) {
				box = this.sechseckigeSchachteln.get(i);
				if (box.passtHinein(g)) {
					System.out.println("\tHinweis: es wurde keine passende runde Schachtel gefunden, daher wurde das Geschenk in eine passende sechseckige Schachtel gegeben.");
					break;
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
				}
			}

		}
		else if (!rundeSchachteln.isEmpty()) {
			for (int i = 0; i < this.rundeSchachteln.size(); i++) {
				box = this.rundeSchachteln.get(i);
				if (box.passtHinein(g)) {
					System.out.println("\tHinweis: es wurde keine passende sechseckige Schachtel gefunden, daher wurde das Geschenk in eine passende runde Schachtel gegeben.");
					break;
				}
			}

		} else if (!rechteckigeSchachteln.isEmpty()) {
			for (int i = 0; i < this.rechteckigeSchachteln.size(); i++) {
				box = this.rechteckigeSchachteln.get(i);
				if (box.passtHinein(g)) {
					System.out.println(
							"\tHinweis: es wurde keine passende runde Schachtel gefunden, daher wurde das Geschenk in eine passende rechteckige Schachtel gegeben.");
					break;
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
