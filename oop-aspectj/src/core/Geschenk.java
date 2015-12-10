package core;

public abstract class Geschenk {

	public abstract Schachtel<? extends Geschenk> findSchachtel(Schachtellager l);
}
