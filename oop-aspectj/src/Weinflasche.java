import core.Schachtel;
import core.Schachtellager;
import forms.Kreis;

public class Weinflasche extends Kreis {
	public Weinflasche(int hoehe, String name, int durchmesser){
		super(hoehe, name,durchmesser);
	}
	
	public double getFlache(){return super.getFlaeche();}

}
