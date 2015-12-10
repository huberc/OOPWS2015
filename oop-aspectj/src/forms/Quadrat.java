package forms;

import core.Geschenk;
import core.Schachtel;
import core.Schachtellager;

public abstract class Quadrat extends Geschenk{
	public Schachtel<Quadrat> findSchachtel(Schachtellager l){
		return l.getSchachtelFor(this);
	}
}
