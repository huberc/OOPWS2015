import core.Einkaufstasche;
import core.Schachtellager;
import schachteln.QuadratischeSchachtel;
import schachteln.RechteckigeSchachtel;
import schachteln.RundeSchachtel;
import schachteln.SechseckigeSchachtel;

public class Test {

    public static void main(String[] args){
        new String("Blubbb");
        new String("Blaaaa");
        Test test = new Test();
        
        System.out.println("Test fuer rechteckige Schachtel: "+test.testRechteckigeSchachtel());
        System.out.println();
        System.out.println("Test fuer quadratische Schachtel: "+test.testQuadratischeSchachtel());
        System.out.println();
        System.out.println("Test fuer runde Schachtel: "+test.testRundeSchachtel());
        System.out.println();
        System.out.println("Test fuer sechseckige Schachtel: "+test.testSeschseckigeSchachtel());
        System.out.println();
        System.out.println("Test fallback Strategie: "+test.testFallbackAlgorithmus());
        
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
    		
    	System.out.println("\tVolumen der Einkaufstasche: "+einkaufstasche.volumen());
    	System.out.println(einkaufstasche.inhalt());
    	
    	return true;
    }
    
    private boolean testQuadratischeSchachtel(){
    	Schachtellager schachtellager = new Schachtellager();
    	Einkaufstasche einkaufstasche = new Einkaufstasche();
    	Wuerfel wuerfel = new Wuerfel(18,"Wuerfel 1",17);
    	QuadratischeSchachtel quadratischeSchachtel = new QuadratischeSchachtel(19, "QuadratischeSchachtel 1", 20);
    	
    	schachtellager.addQuadratischeSchachtel(quadratischeSchachtel);
    	
    	schachtellager.verpacke(wuerfel, einkaufstasche);
    	
    	if(! (quadratischeSchachtel.volumen() == einkaufstasche.volumen()))
    		return false;
    	if(!(einkaufstasche.inhalt().contains("Wuerfel 1"))){
    		return false;
    	}
    		
    	System.out.println("\tVolumen der Einkaufstasche: "+einkaufstasche.volumen());
    	System.out.println(einkaufstasche.inhalt());
    	
    	return true;
    }
    private boolean testRundeSchachtel(){
    	Schachtellager schachtellager = new Schachtellager();
    	Einkaufstasche einkaufstasche = new Einkaufstasche();
    	Weinflasche weinflasche = new Weinflasche(14, "Weinflasche", 8);
    	RundeSchachtel rundeSchachtel = new RundeSchachtel(15, "RundeSchachtel1", 10);
    	
    	schachtellager.addRundeSchachtel(rundeSchachtel);
    	
    	schachtellager.verpacke(weinflasche, einkaufstasche);
    	
    	if(! (rundeSchachtel.volumen() == einkaufstasche.volumen()))
    		return false;
    	if(!(einkaufstasche.inhalt().contains("Weinflasche"))){
    		return false;
    	}
    		
    	System.out.println("\tVolumen der Einkaufstasche: "+einkaufstasche.volumen());
    	System.out.println(einkaufstasche.inhalt());
    	
    	return true;
    }
    private boolean testSeschseckigeSchachtel(){
    	Schachtellager schachtellager = new Schachtellager();
    	Einkaufstasche einkaufstasche = new Einkaufstasche();
    	SechseckigeKerze kerze = new SechseckigeKerze(9, "Kerze1", 8);
    	SechseckigeSchachtel sechseckigeSchachtel = new SechseckigeSchachtel(10, "SechseckigeSchachtel", 9);
    	
    	schachtellager.addSechseckigeSchachtel(sechseckigeSchachtel);
    	
    	schachtellager.verpacke(kerze, einkaufstasche);
    	
    	if(! (sechseckigeSchachtel.volumen() == einkaufstasche.volumen()))
    		return false;
    	if(!(einkaufstasche.inhalt().contains("Kerze1"))){
    		return false;
    	}
    		
    	System.out.println("\tVolumen der Einkaufstasche: "+einkaufstasche.volumen());
    	System.out.println(einkaufstasche.inhalt());
    	
    	return true;
    }
    
    private boolean testFallbackAlgorithmus(){
    	Schachtellager schachtellager = new Schachtellager();
    	Einkaufstasche einkaufstasche = new Einkaufstasche();
    	
    	Baelle ball = new Baelle(10, "Ball1", 14);
    	QuadratischeSchachtel quadratischeSchachtel = new QuadratischeSchachtel(12, "QuadratischeSchachtel 1", 16);
    	
    	schachtellager.addQuadratischeSchachtel(quadratischeSchachtel);
    	
    	schachtellager.verpacke(ball, einkaufstasche);
    	
    	if(! (quadratischeSchachtel.volumen() == einkaufstasche.volumen()))
    		return false;
    	if(!(einkaufstasche.inhalt().contains(ball.getName())) && !(einkaufstasche.inhalt().contains(quadratischeSchachtel.getName()))){
    		return false;
    	}
    	System.out.println("\tVolumen der Einkaufstasche: "+einkaufstasche.volumen());
    	System.out.println(einkaufstasche.inhalt());
    	
    	return true;
    }
}
