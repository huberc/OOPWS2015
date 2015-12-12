package schachteln;

import core.Geschenk;
import core.Schachtel;
import forms.Rechteck;
import forms.Sechseck;

public class RechteckigeSchachtel extends Rechteck implements Schachtel{

	private Geschenk inhalt;
	
	public RechteckigeSchachtel(int hoehe, String name, int breite, int laenge) {
		super(hoehe, name, breite, laenge);	
	}

	@Override
	public double getFlaeche() {
		return this.getBreite()*this.getLaenge();
	}

	@Override
	public void einpacken(Geschenk g) {
		inhalt = g;		
	}

	@Override
	public boolean passtHinein(Geschenk g) {
		if(this.getHoehe() < g.getHoehe()+1){
			return false;
		}else if(g instanceof Rechteck){
			Rechteck r = (Rechteck) g;
			if(this.getBreite() > r.getBreite()+1 && this.getLaenge() > r.getLaenge()+1 && this.getBreite() < r.getBreite()+3 && this.getLaenge() < r.getLaenge()+3){
				return true;
			}else{
				return false;
			}
		}else if(g instanceof Sechseck){
			Sechseck s = (Sechseck) g;
			if(this.getBreite() > s.getUmkreisDurchmesser()+1 && this.getBreite() < s.getUmkreisDurchmesser()+3
					&& this.getLaenge() > s.getUmkreisDurchmesser()+1 && this.getLaenge() < s.getUmkreisDurchmesser()+3){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
	public Geschenk getInhalt(){
		return inhalt;
	}

}
