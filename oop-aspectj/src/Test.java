import oop.core.DevelopedBy;
import oop.core.Einkaufstasche;
import oop.core.Schachtellager;
import oop.main.Baelle;
import oop.main.Buecher;
import oop.main.SechseckigeKerze;
import oop.main.SechseckigeVase;
import oop.main.Weinflasche;
import oop.main.Wuerfel;
import oop.schachteln.QuadratischeSchachtel;
import oop.schachteln.RechteckigeSchachtel;
import oop.schachteln.RundeSchachtel;
import oop.schachteln.SechseckigeSchachtel;

@DevelopedBy("Christoph Huber, Ines Rieder")
public class Test {

    @DevelopedBy("Christoph Huber, Ines Rieder")
    public static void main(String[] args){
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
		System.out.println();
		System.out.println("Test keine Schachtel vorhanden: "+test.testKeinSchachtelvorhanden());
        
    }
    
    @DevelopedBy("Christoph Huber")
    private boolean testRechteckigeSchachtel(){
    	Schachtellager schachtellager = new Schachtellager();
    	Einkaufstasche einkaufstasche = new Einkaufstasche();
    	Buecher buch1 = new Buecher(18,"Buch1",14,19);
    	RechteckigeSchachtel rechteckigeSchachtel = new RechteckigeSchachtel(20, "RechteckigeSchachtel 1", 15, 20);
    	
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
    
    @DevelopedBy("Christoph Huber")
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
    
    @DevelopedBy("Christoph Huber")
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
    
    @DevelopedBy("Ines Rieder")
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
    
    @DevelopedBy("Ines Rieder")
    private boolean testFallbackAlgorithmus(){
    	
    	/**
    	 * Test runde Geschenk in quadratische Schachtel
    	 */
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
    	
    	
    	/**
    	 *	Test rundes Geschenk in sechseckige Schachtel 
    	 */
    	Schachtellager schachtellager1 = new Schachtellager();
    	
    	Weinflasche weinflasche = new Weinflasche(10, "Weinflasche", 25);
    	
    	SechseckigeSchachtel sechseckigeSchachtel = new SechseckigeSchachtel(12, "SechseckigeSchachtel 1", 16);
    	
    	schachtellager1.addSechseckigeSchachtel(sechseckigeSchachtel);
    	
    	schachtellager1.verpacke(weinflasche, einkaufstasche);
    	
    	if(! ((sechseckigeSchachtel.volumen()+quadratischeSchachtel.volumen()) == einkaufstasche.volumen()))
    		return false;
    	if(!(einkaufstasche.inhalt().contains(weinflasche.getName())) && !(einkaufstasche.inhalt().contains(sechseckigeSchachtel.getName()))){
    		return false;
    	}
    	System.out.println("\tVolumen der Einkaufstasche: "+einkaufstasche.volumen());
    	System.out.println(einkaufstasche.inhalt());
    	
    	
    	/**
    	 *	Test sechseckiges Geschenk in runde Schachtel 
    	 */
    	Schachtellager schachtellager2 = new Schachtellager();
    	
    	SechseckigeKerze kerze = new SechseckigeKerze(10, "Kerze", 7);
    	
    	RundeSchachtel rundeSchachtel = new RundeSchachtel(12, "RundeSchachtel 1", 16);
    	
    	schachtellager2.addRundeSchachtel(rundeSchachtel);
    	
    	schachtellager2.verpacke(kerze, einkaufstasche);
    	
    	if(! ((sechseckigeSchachtel.volumen()+quadratischeSchachtel.volumen()+rundeSchachtel.volumen()) == einkaufstasche.volumen()))
    		return false;
    	if(!(einkaufstasche.inhalt().contains(kerze.getName())) && !(einkaufstasche.inhalt().contains(rundeSchachtel.getName()))){
    		return false;
    	}
    	System.out.println("\tVolumen der Einkaufstasche: "+einkaufstasche.volumen());
    	System.out.println(einkaufstasche.inhalt());
    	
    	/**
    	 *	Test sechseckiges Geschenk in rechteckige Schachtel 
    	 */
    	Schachtellager schachtellager3 = new Schachtellager();
    	
    	SechseckigeVase vase = new SechseckigeVase(10, "Vase", 7);
    	
    	RechteckigeSchachtel rechteckigeSchachtel = new RechteckigeSchachtel(12, "RechteckigeSchachtel 1", 16,17);
    	
    	schachtellager3.addRechteckigeSchachtel(rechteckigeSchachtel);
    	
    	schachtellager3.verpacke(vase, einkaufstasche);
    	
    	if(! ((sechseckigeSchachtel.volumen()+quadratischeSchachtel.volumen()+rundeSchachtel.volumen()+rechteckigeSchachtel.volumen()) == einkaufstasche.volumen()))
    		return false;
    	if(!(einkaufstasche.inhalt().contains(vase.getName())) && !(einkaufstasche.inhalt().contains(rechteckigeSchachtel.getName()))){
    		return false;
    	}
    	System.out.println("\tVolumen der Einkaufstasche: "+einkaufstasche.volumen());
    	System.out.println(einkaufstasche.inhalt());
    	
    	
    	return true;
    }
    
    @DevelopedBy("Ines Rieder")
    private boolean testKeinSchachtelvorhanden(){
		Schachtellager schachtellager = new Schachtellager();
		Einkaufstasche einkaufstasche = new Einkaufstasche();
		SechseckigeVase vase = new SechseckigeVase(10, "Vase", 7);

		schachtellager.verpacke(vase,einkaufstasche);

		if(!(einkaufstasche.volumen() == vase.volumen())){
			return false;
		}
		if(!(einkaufstasche.inhalt().contains(vase.getName()))){
			return false;
		}

		System.out.println("\tVolumen der Einkaufstasche: "+einkaufstasche.volumen());
		System.out.println(einkaufstasche.inhalt());

    	return true;
    }
}
