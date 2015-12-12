package core;

public abstract class Geschenk {

	private int hoehe;
	private String name;
	
	public Geschenk(int hoehe, String name){
		this.hoehe = hoehe;
		this.name = name;
	}
	
	public abstract double getFlaeche();
	
	public double volumen(){
		return getFlaeche() * hoehe;
	}
	
	public abstract void verpackeGeschenk(Schachtellager l,Einkaufstasche e);
	
	public int getHoehe(){return hoehe;}
	
	public String getName(){return name;}
}
