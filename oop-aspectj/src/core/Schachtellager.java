package core;

import java.util.ArrayList;
import java.util.List;

import forms.Kreis;
import forms.Quadrat;
import forms.Rechteck;
import forms.Sechseck;

public class Schachtellager {

    private List<Schachtel<Kreis>> rundeSchachteln = new ArrayList<>();
    
	public Schachtel<? extends Geschenk> verpacke(Geschenk g){
		return g.verpackeGeschenk(this);
	}
	
	public Schachtel<Kreis> verpackeKreis(Kreis k){
	    Schachtel<Kreis> box = this.rundeSchachteln.get(0);
	    box.einpacken(k);
	    return box;
	}
	
	public Schachtel<Quadrat> verpackeQuadrat(Quadrat q){
	    return null;
	}
	
	public Schachtel<Rechteck> verpackeRechteck(Rechteck r){
	    return null;
	}
	
	public Schachtel<Sechseck> verpackeSechseck(Sechseck s){
	    return null;
	}
	
}
