package oop.core;

import java.util.ArrayList;
import java.util.List;

@DevelopedBy
public class Einkaufstasche {

	private List <Schachtel> einkaufstasche = new ArrayList<>();
	
	public void addSchachtel(Schachtel s){
		einkaufstasche.add(s);
	}

	public double volumen(){
		double volumen=0;
		for(int i=0;i<einkaufstasche.size();i++){
			volumen+= einkaufstasche.get(i).volumen();
		}
		return volumen;
	}
	
	public String inhalt(){
		StringBuilder result = new StringBuilder();
		result.append("\tEinkaufstascheninhalt:\n");
		for(int i=0;i<einkaufstasche.size();i++){
			result.append("\t\t- die "+einkaufstasche.get(i).getName()+" beinhaltet "+einkaufstasche.get(i).getInhalt().getName()+"\n");
		}
		
		return result.toString();
	}

}
