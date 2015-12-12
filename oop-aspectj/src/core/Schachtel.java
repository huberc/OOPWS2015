package core;

public interface Schachtel {

	void einpacken(Geschenk g);
	
	boolean passtHinein(Geschenk g);
	
	double volumen();
	
	Geschenk getInhalt();
	
	String getName();
}
