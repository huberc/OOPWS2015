package oop.core;

@DevelopedBy("Ines Rieder, Christoph Huber")
public abstract class Geschenk {

	private int hoehe;
	private String name;
	
	@DevelopedBy("Ines Rieder")
	public Geschenk(int hoehe, String name){
		this.hoehe = hoehe;
		this.name = name;
	}
	
	@DevelopedBy("Ines Rieder")
	public abstract double getFlaeche();
	
	@DevelopedBy("Ines Rieder")
	public double volumen(){
		return getFlaeche() * hoehe;
	}
	
	@DevelopedBy("Christoph Huber")
	public abstract void verpackeGeschenk(Schachtellager l,Einkaufstasche e);
	
	@DevelopedBy("Christoph Huber")
	public int getHoehe(){return hoehe;}
	
	@DevelopedBy("Christoph Huber")
	public String getName(){return name;}
}
