package forms;

import core.Einkaufstasche;
import core.Geschenk;
import core.Schachtellager;

public abstract class Quadrat extends Geschenk{
    
	private int seitenlaenge;
	
	public Quadrat(int hoehe, String name,int seitenlaenge) {
		super(hoehe, name);
		this.seitenlaenge = seitenlaenge;
	}

	public void verpackeGeschenk(Schachtellager l,Einkaufstasche e){
		l.verpackeQuadrat(this,e);
	}
	
	public double getFlaeche(){
		return seitenlaenge*seitenlaenge;
	}
	
	public int getSeitenlaenge(){
		return seitenlaenge;
	}
	
}
