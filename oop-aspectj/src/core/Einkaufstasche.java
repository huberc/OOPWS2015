package core;

import java.util.ArrayList;
import java.util.List;

public class Einkaufstasche {
	
	List <Schachtel> einkaufstasche = new ArrayList<>();
	
	public void addSchachtel(Schachtel s){
		einkaufstasche.add(s);
	}

}
