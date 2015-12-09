/**
 * Created by Christoph on 09.12.2015.
 */
public class QuadratischeSchachtel extends Schachtel{
	
	private Geschenk inhalt;
	
	
	public enum supportedSchachteln{
		Quadrat;
	}

	@Override
	public double volumen() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Geschenk getInhalt() {
		return inhalt;
	}
	
}
