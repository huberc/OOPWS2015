package oop.core;

import java.util.ArrayList;
import java.util.List;

public class Einkaufstasche {

	private List<Geschenk> einkaufstasche1 = new ArrayList<>();
	private List<Schachtel> einkaufstasche2 = new ArrayList<>();


	public void addGeschenk(Geschenk s){
		einkaufstasche1.add(s);
	}
	public void addSchachtel(Schachtel box) {
		einkaufstasche2.add(box);
	}
	public double volumen(){
		double volumen=0;
		for(int i=0;i<einkaufstasche2.size();i++){
			volumen+= einkaufstasche2.get(i).volumen();
		}
		for(int i=0;i<einkaufstasche1.size();i++){
			volumen+= einkaufstasche1.get(i).volumen();
		}
		return volumen;
	}
	
	public String inhalt(){
		StringBuilder result = new StringBuilder();
		result.append("\tEinkaufstascheninhalt:\n");
		for(int i=0;i<einkaufstasche2.size();i++){
			result.append("\t\t- die "+einkaufstasche2.get(i).getName()+" beinhaltet "+einkaufstasche2.get(i).getInhalt().getName()+"\n");
		}

		for(int i=0;i<einkaufstasche1.size();i++){
			result.append("\t\t- "+einkaufstasche1.get(i).getName()+" wurde aufgrund keiner passenden Schachtel im Schachtellager unverpackt verkauft\n");
		}
		return result.toString();
	}
}
