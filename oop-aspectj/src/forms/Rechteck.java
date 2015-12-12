package forms;

import core.Geschenk;
import core.Schachtel;
import core.Schachtellager;

public abstract class Rechteck extends Geschenk{
	
	@Override
	public Schachtel<Rechteck> verpackeGeschenk(Schachtellager l){
		return l.verpackeRechteck(this);
	}
	
}
