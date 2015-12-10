package forms;

import core.Geschenk;
import core.Schachtel;
import core.Schachtellager;

public abstract class Kreis extends Geschenk{

	@Override
	public Schachtel<Kreis> findSchachtel(Schachtellager l){
		return l.getSchachtelFor(this);
	}
}
