package forms;

import core.Einkaufstasche;
import core.Geschenk;
import core.Schachtellager;

public abstract class Rechteck extends Geschenk{
	
	private int breite, laenge;
	
	public Rechteck(int hoehe, String name,int breite, int laenge) {
		super(hoehe, name);
		this.breite = breite;
		this.laenge = laenge;
	}

	@Override
	public void verpackeGeschenk(Schachtellager l, Einkaufstasche e){
		l.verpackeRechteck(this,e);
	}
	
	public int getLaenge(){return laenge;}
	
	public int getBreite(){return breite;}
	
}
