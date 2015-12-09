import java.util.*;

/**
 * Created by Christoph on 09.12.2015.
 */
public class Einkaufstasche {
	
	List<Schachtel> schachteln = new ArrayList<Schachtel>();
	
	
	public double volumen(){
		double volumen=0;
		for(int i=0;i<schachteln.size();i++){
			volumen += schachteln.get(i).volumen();
		}
		
		return volumen;
	}
	
	public String inhalt(){
		StringBuilder builder = new StringBuilder();
		
		for(int i=0;i<schachteln.size();i++){
			builder.append(schachteln.get(i).getInhalt().getName());
		}
	}
	
	public void addSchachtel(Schachtel schachtel){
		schachteln.add(schachtel);
	}
}
