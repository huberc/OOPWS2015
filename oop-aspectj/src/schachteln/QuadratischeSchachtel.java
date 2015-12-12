package schachteln;

import core.Geschenk;
import core.Schachtel;
import forms.Kreis;
import forms.Quadrat;

public class QuadratischeSchachtel extends Quadrat implements Schachtel {
	
	private Geschenk inhalt;
	
	public QuadratischeSchachtel(int hoehe, String name, int seitenlaenge) {
		super(hoehe, name, seitenlaenge);
	}

	@Override
	public void einpacken(Geschenk g) {
		this.inhalt = g;
	}
	
	@Override
	public boolean passtHinein(Geschenk g) {
		if ((this.getHoehe() < g.getHoehe()+1) || (this.getHoehe() >g.getHoehe()+2)) {
			return false;
		} else if (g instanceof Quadrat) {
			Quadrat q = (Quadrat) g;
			if ((this.getSeitenlaenge() > q.getSeitenlaenge()+1) && 
					(this.getSeitenlaenge() < q.getSeitenlaenge()+2)) {
				return true;
			} else {
				return false;
			}
		} else if (g instanceof Kreis) {
			Kreis k = (Kreis) g;
			if ((this.getSeitenlaenge() > k.getDurchmesser()+1) &&
					(this.getSeitenlaenge() < k.getDurchmesser()+2)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	public Geschenk getInhalt(){return inhalt;}
}
