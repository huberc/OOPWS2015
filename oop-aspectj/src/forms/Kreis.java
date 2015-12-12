package forms;

import core.Einkaufstasche;
import core.Geschenk;
import core.Schachtellager;

public abstract class Kreis extends Geschenk{
	private int durchmesser;
	
	public Kreis(int hoehe, String name, int durchmesser){
		super(hoehe, name);
		this.durchmesser = durchmesser;
	}
	
	public double getFlaeche(){
		return ((Math.PI*durchmesser*durchmesser)/4);
	}
	@Override
	public void verpackeGeschenk(Schachtellager l,Einkaufstasche e){
		l.verpackeKreis(this, e);
	}
	
	public int getDurchmesser(){return durchmesser;}
	
}
