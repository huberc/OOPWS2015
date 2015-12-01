/**
 * Arbeitsaufteilung: Design und test wurde gemeinsam entwickelt und geschrieben
 *  Christoph Huber: add, list mit uebergebenen Dachstuhl
 *  Michael Langowksi: get
 *  Ines Rieder: list, price, Zusicherungen
 */

public class Test {

    public static void main(String[] args) {
        Test test = new Test();

        System.out.println("Allgemeiner Test fuer add- und get-Methoden: "+test.testAllgemein());
        System.out.println("Test der Grenzfaelle: "+test.keinSaegerauh());


    }

    private boolean keinSaegerauh() {
        BauholzLager lager = new BauholzLager();
        Bauholz bauholz1 = new RundholzGehobelt(100, 20000, 10);
        lager.add(bauholz1);
        Bauholz bauholz2 = new KantholzGehobelt(100, 30000, 10, 10);
        lager.add(bauholz2);
        Dachstuhl holzNutzbauDachstuhl = new HolzNutzbauDachstuhl();
        Dachstuhl steinNutzbauDachstuhl = new SteinNutzbauDachstuhl();
        Bauholz tmpHolz = lager.get(holzNutzbauDachstuhl);
        Bauholz tmpStein = lager.get(steinNutzbauDachstuhl);

        if ((tmpHolz == bauholz1) && (tmpStein == bauholz2)) {
            return true;
        }

        return false;
    }


    private boolean testAllgemein(){
        Bauholz rundholzGehobelt1 = new RundholzGehobelt(10,10,10);
        Bauholz rundholzGehobelt2 = new RundholzGehobelt(20,20,20);
        Bauholz rundholzGehobelt3 = new RundholzGehobelt(30,30,30);

        Bauholz rundholzSaegerauh1 = new RundholzSaegerauh(10,10,10);
        Bauholz rundholzSaegerauh2 = new RundholzSaegerauh(20,20,20);
        Bauholz rundholzSaegerauh3 = new RundholzSaegerauh(30,30,30);

        Bauholz kantholzGehobelt1 = new KantholzGehobelt(10,10,10,10);
        Bauholz kantholzGehobelt2 = new KantholzGehobelt(20,20,20,20);
        Bauholz kantholzGehobelt3 = new KantholzGehobelt(30,30,30,30);

        Bauholz kantholzSaegerauh1 = new KantholzSaegerauh(10,10,10,10);
        Bauholz kantholzSaegerauh2 = new KantholzSaegerauh(20,20,20,20);
        Bauholz kantholzSaegerauh3 = new KantholzSaegerauh(30,30,30,30);

        BauholzLager bauholzLager = new BauholzLager();

        Dachstuhl dachstuhl1 = new HolzNutzbauDachstuhl();
        Dachstuhl dachstuhl2 = new HolzWohnbauDachstuhl();
        Dachstuhl dachstuhl3 = new SteinNutzbauDachstuhl();
        Dachstuhl dachstuhl4 = new SteinWohnbauDachstuhl();

        bauholzLager.add(rundholzGehobelt1);
        bauholzLager.add(rundholzGehobelt2);
        bauholzLager.add(rundholzGehobelt3);
        bauholzLager.add(rundholzSaegerauh1);
        bauholzLager.add(rundholzSaegerauh2);
        bauholzLager.add(rundholzSaegerauh3);
        bauholzLager.add(kantholzGehobelt1);
        bauholzLager.add(kantholzGehobelt2);
        bauholzLager.add(kantholzGehobelt3);
        bauholzLager.add(kantholzSaegerauh1);
        bauholzLager.add(kantholzSaegerauh2);
        bauholzLager.add(kantholzSaegerauh3);

        System.out.println("Aktueller Lagerbestand:");
        bauholzLager.list();

        if(bauholzLager.get(dachstuhl1).getClass() != RundholzSaegerauh.class){
            System.out.println("Der zurueckgegebene Typ fuer "+dachstuhl1.getClass().getSimpleName()+" stimmt nicht mit der Spezifikation ueberein");
            return false;
        }
        if(bauholzLager.get(dachstuhl2).getClass() != RundholzGehobelt.class){
            System.out.println("Der zurueckgegebene Typ fuer "+dachstuhl2.getClass().getSimpleName()+" stimmt nicht mit der Spezifikation ueberein");
            return false;
        }
        if(bauholzLager.get(dachstuhl3).getClass() != KantholzSaegerauh.class){
            System.out.println("Der zurueckgegebene Typ fuer "+dachstuhl3.getClass().getSimpleName()+" stimmt nicht mit der Spezifikation ueberein");
            return false;
        }
        if(bauholzLager.get(dachstuhl4).getClass() != KantholzGehobelt.class){
            System.out.println("Der zurueckgegebene Typ fuer "+dachstuhl4.getClass().getSimpleName()+" stimmt nicht mit der Spezifikation ueberein");
            return false;
        }

        System.out.println();
        bauholzLager.list(dachstuhl1);
        System.out.println();
        bauholzLager.list(dachstuhl2);
        System.out.println();
        bauholzLager.list(dachstuhl3);
        System.out.println();
        bauholzLager.list(dachstuhl4);
        System.out.println();
        bauholzLager.price(dachstuhl1);
        System.out.println();
        bauholzLager.price(dachstuhl2);
        System.out.println();
        bauholzLager.price(dachstuhl3);
        System.out.println();
        bauholzLager.price(dachstuhl4);
        System.out.println();

        return true;
    }

}
