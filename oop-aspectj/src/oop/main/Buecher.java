package oop.main;
import oop.core.DevelopedBy;
import oop.forms.Rechteck;

@DevelopedBy("Ines Rieder")
public class Buecher extends Rechteck{

    @DevelopedBy("Ines Rieder")
	public Buecher(int hoehe, String name, int breite, int laenge) {
		super(hoehe, name, breite, laenge);
	}

}
