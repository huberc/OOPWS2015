package core;

public interface Schachtel<T extends Geschenk> {

	void einpacken(T g);
	
	boolean passtHinein(T g);
	
}
