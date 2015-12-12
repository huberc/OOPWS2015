package forms;

import core.Geschenk;
import core.Schachtel;
import core.Schachtellager;

public abstract class Rechteck extends Geschenk{
	
	@Override
	public void verpackeGeschenk(Schachtellager l){
		l.verpackeRechteck(this);
	}
	
}
