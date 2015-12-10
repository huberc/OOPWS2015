package core;

import forms.Kreis;
import forms.Quadrat;
import forms.Rechteck;
import forms.Sechseck;

public class Schachtellager {

	public <T extends Geschenk> void verpacke(T g){
		Schachtel<T> s = g.findSchachtel(this);
		s.einpacken(g);
	}
	
	public Schachtel<Kreis> getSchachtelFor(Kreis k){
		return null;
	}
	
	public Schachtel<Quadrat> getSchachtelFor(Quadrat q){
		return null;
	}
	
	public Schachtel<Rechteck> getSchachtelFor(Rechteck r){
		return null;
	}
	
	public Schachtel<Sechseck> getSchachtelFor(Sechseck s){
		return null;
	}
	
}
