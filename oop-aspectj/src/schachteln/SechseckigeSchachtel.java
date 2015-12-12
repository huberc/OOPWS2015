package schachteln;

import core.Geschenk;
import core.Schachtel;
import forms.Kreis;
import forms.Sechseck;

public class SechseckigeSchachtel extends Sechseck implements Schachtel{

	Geschenk inhalt; 
	
	public SechseckigeSchachtel(int hoehe, String name, int seitenlaenge) {
		super(hoehe, name, seitenlaenge);
	}

	@Override
	public void einpacken(Geschenk g) {
		this.inhalt = g;
	}

	@Override
	public boolean passtHinein(Geschenk g) {
		if ((this.getHoehe() < g.getHoehe()+1) || (this.getHoehe() > g.getHoehe()+2)) {
			return false;
		} else if (g instanceof Sechseck) {
			Sechseck s = (Sechseck) g;
			if ((this.getSeitenlaenge() > s.getSeitenlaenge()+1) && 
					(this.getSeitenlaenge() < s.getSeitenlaenge()+2)) {
				return true;
			} else {
				return false;
			}
		} else if (g instanceof Kreis) {
			Kreis k = (Kreis) g;
			if ((this.getInkreisDurchmesser() > k.getDurchmesser()+1) &&
					(this.getInkreisDurchmesser() < k.getDurchmesser()+2)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
}
