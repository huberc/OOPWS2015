package forms;

import core.Geschenk;
import core.Schachtel;
import core.Schachtellager;

public abstract class Sechseck extends Geschenk {
	
	
	public void verpackeGeschenk(Schachtellager l) {
		l.verpackeSechseck(this);
	}
}
