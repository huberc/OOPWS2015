package forms;

import core.Geschenk;
import core.Schachtel;
import core.Schachtellager;

public abstract class Quadrat extends Geschenk{
	public void verpackeGeschenk(Schachtellager l){
		l.verpackeQuadrat(this);
	}
}
