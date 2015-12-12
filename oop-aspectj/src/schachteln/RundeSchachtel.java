package schachteln;

import core.Geschenk;
import core.Schachtel;
import forms.Kreis;
import forms.Sechseck;

public class RundeSchachtel extends Kreis implements Schachtel{

	private Geschenk inhalt;
	
	public RundeSchachtel(int hoehe, String name, int durchmesser) {
		super(hoehe,name,durchmesser);
	}

	@Override
	public void einpacken(Geschenk g) {
		this.inhalt = g;
	}

	@Override
	public boolean passtHinein(Geschenk g) {
		if(this.getHoehe() < g.getHoehe()+1){
			return false;
		}else if(g instanceof Kreis){
			Kreis k = (Kreis) g;
			if(this.getDurchmesser()>k.getDurchmesser()+1){
				return true;
			}else{
				return false;
			}
		}else if(g instanceof Sechseck){
			Sechseck s = (Sechseck) g;
			if(this.getDurchmesser() > s.getInkreisDurchmesser()+1){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
	public Geschenk getInhalt(){return inhalt;}
}
