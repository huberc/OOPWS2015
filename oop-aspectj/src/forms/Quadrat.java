package forms;

import core.Geschenk;
import core.Schachtel;
import core.Schachtellager;

public abstract class Quadrat extends Geschenk{
    
	public Schachtel<Quadrat> verpackeGeschenk(Schachtellager l){
		return l.verpackeQuadrat(this);
	}
	
}
