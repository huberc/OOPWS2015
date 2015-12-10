package forms;

import core.Geschenk;
import core.Schachtel;
import core.Schachtellager;

public abstract class Sechseck extends Geschenk {
	
	
	public Schachtel<Sechseck> findSchachtel(Schachtellager l) {
		return l.getSchachtelFor(this);
	}
}
