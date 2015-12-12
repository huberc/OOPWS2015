package forms;

import core.Einkaufstasche;
import core.Geschenk;
import core.Schachtellager;

public abstract class Sechseck extends Geschenk {
	private int seitenlaenge;
	
	public Sechseck(int hoehe, String name,int seitenlaenge) {
		super(hoehe, name);
		this.seitenlaenge = seitenlaenge;
	}

	public void verpackeGeschenk(Schachtellager l,Einkaufstasche e) {
		 l.verpackeSechseck(this,e);
	}
	
	public double getFlaeche(){
		return seitenlaenge*seitenlaenge*3/2*Math.sqrt(3);
	}
	
	public int getSeitenlaenge(){
		return this.seitenlaenge;
	}
	public double getInkreisDurchmesser(){
		return seitenlaenge*Math.sqrt(3);
	}
}
