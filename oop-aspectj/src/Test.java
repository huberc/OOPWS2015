import core.Einkaufstasche;
import core.Schachtellager;
import schachteln.RechteckigeSchachtel;

public class Test {

    public static void main(String[] args){
        new String("Blubbb");
        new String("Blaaaa");
        Test test = new Test();
        
        System.out.println(test.testRechteckigeSchachtel());
        
    }
    
    private boolean testRechteckigeSchachtel(){
    	Schachtellager schachtellager = new Schachtellager();
    	Einkaufstasche einkaufstasche = new Einkaufstasche();
    	Buecher buch1 = new Buecher(18,"Buch1",14,19);
    	RechteckigeSchachtel rechteckigeSchachtel = new RechteckigeSchachtel(20, "RechteckigeSchatel 1", 15, 20);
    	
    	schachtellager.addRechteckigeSchachtel(rechteckigeSchachtel);
    	
    	schachtellager.verpacke(buch1, einkaufstasche);
    	
    	if(! (rechteckigeSchachtel.volumen() == einkaufstasche.volumen()))
    		return false;
    	if(!(einkaufstasche.inhalt().contains("Buch1"))){
    		return false;
    	}
    		
    	System.out.println(einkaufstasche.volumen());
    	System.out.println(einkaufstasche.inhalt());
    	
    	return true;
    }
}
