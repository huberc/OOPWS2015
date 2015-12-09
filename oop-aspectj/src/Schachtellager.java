import java.util.HashMap;
import java.util.Map;

/**
 * Created by Christoph on 09.12.2015.
 */
public class Schachtellager {
	
	Map<Class <? extends Schachtel>,Integer> schachteln = new HashMap<Class<? extends Schachtel>,Integer>();
	
	public void verpacke(Geschenk geschenk){
		
	}
	
	public void addSchachteln(Class <? extends Schachtel> schachtel, int menge){
		this.schachteln.put(schachtel, menge);
	}
	
}
