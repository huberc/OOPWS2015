package forms;

import core.Geschenk;
import core.Schachtel;
import core.Schachtellager;

public abstract class Kreis extends Geschenk{

	@Override
	public Schachtel<Kreis> verpackeGeschenk(Schachtellager l){
		return l.verpackeKreis(this);
	}
}
