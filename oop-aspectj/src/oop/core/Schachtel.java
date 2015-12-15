package oop.core;

@DevelopedBy("Ines Rieder, Michael Langowski")
public interface Schachtel {

    @DevelopedBy("Michael Langowski")
	void einpacken(Geschenk g);
	
    @DevelopedBy("Ines Rieder")
	boolean passtHinein(Geschenk g);
	
    @DevelopedBy("Ines Rieder")
	double volumen();
	
    @DevelopedBy("Ines Rieder")
	Geschenk getInhalt();
	
    @DevelopedBy("Ines Rieder")
	String getName();
}
