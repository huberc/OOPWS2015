/**
 * Arbeitsaufteilung: Christoph Huber: Forstbetrieb, CustomList, ListableNumber,
 * Michael Langowksi: Holzvollernter, Abstractarbeitskopf
 * Ines Rieder: Gemeinde, Test
 */

public class Test {
    Gemeinde gemeinde1 = new Gemeinde("gemeinde1");
    Gemeinde gemeinde2 = new Gemeinde("gemeinde2");
    Gemeinde gemeinde3 = new Gemeinde("gemeinde3");

    Forstbetrieb forstbetrieb11 = new Forstbetrieb("forstbetrieb11");
    Forstbetrieb forstbetrieb12 = new Forstbetrieb("forstbetrieb12");
    Forstbetrieb forstbetrieb13 = new Forstbetrieb("forstbetrieb13");

    Forstbetrieb forstbetrieb21 = new Forstbetrieb("forstbetrieb21");
    Forstbetrieb forstbetrieb22 = new Forstbetrieb("forstbetrieb22");
    Forstbetrieb forstbetrieb23 = new Forstbetrieb("forstbetrieb23");

    Forstbetrieb forstbetrieb31 = new Forstbetrieb("forstbetrieb31");
    Forstbetrieb forstbetrieb32 = new Forstbetrieb("forstbetrieb32");
    Forstbetrieb forstbetrieb33 = new Forstbetrieb("forstbetrieb33");
    Gemeinde gemeinde1 = new Gemeinde("gemeinde1");
    Gemeinde gemeinde2 = new Gemeinde("gemeinde2");
    Gemeinde gemeinde3 = new Gemeinde("gemeinde3");

    Forstbetrieb forstbetrieb11 = new Forstbetrieb("forstbetrieb11");
    Forstbetrieb forstbetrieb12 = new Forstbetrieb("forstbetrieb12");
    Forstbetrieb forstbetrieb13 = new Forstbetrieb("forstbetrieb13");

    Radernter ernter1 = new Radernter();
    Schreiter ernter2 = new Schreiter();
    Radernter ernter3 = new Radernter();
    Schreiter ernter4 = new Schreiter();
    Radernter ernter5 = new Radernter();
    Schreiter ernter6 = new Schreiter();
    Radernter ernter7 = new Radernter();
    Schreiter ernter8 = new Schreiter();
    Radernter ernter9 = new Radernter();
    Schreiter ernter10 = new Schreiter();
    Radernter ernter11 = new Radernter();


    Forstbetrieb forstbetrieb21 = new Forstbetrieb("forstbetrieb21");
    Forstbetrieb forstbetrieb22 = new Forstbetrieb("forstbetrieb22");
    Forstbetrieb forstbetrieb23 = new Forstbetrieb("forstbetrieb23");

    Forstbetrieb forstbetrieb31 = new Forstbetrieb("forstbetrieb31");
    Forstbetrieb forstbetrieb32 = new Forstbetrieb("forstbetrieb32");
    Forstbetrieb forstbetrieb33 = new Forstbetrieb("forstbetrieb33");

    Radernter ernter1 = new Radernter();
    Schreiter ernter2 = new Schreiter();
    Radernter ernter3 = new Radernter();
    Schreiter ernter4 = new Schreiter();
    Radernter ernter5 = new Radernter();
    Schreiter ernter6 = new Schreiter();
    Radernter ernter7 = new Radernter();
    Schreiter ernter8 = new Schreiter();
    Radernter ernter9 = new Radernter();
    Schreiter ernter10 = new Schreiter();
    Radernter ernter11 = new Radernter();


    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("Teststate:\t" + test.test());
    }

    public boolean test() {
        //3 Gemeinden erstellen, je 3 Forstbetriebe hinzufuegen und einen wieder entfernen (ueber eindeutigen Namen)

        gemeinde1.addBetrieb();
        gemeinde1.addBetrieb();
        gemeinde1.addBetrieb();
        gemeinde1.deleteBetrieb("forstbetrieb12");

        if ((!gemeinde1.containsBetrieb(gemeinde1.getBetriebByName("forstbetrieb11"))) || (gemeinde1.containsBetrieb(gemeinde1.getBetriebByName("forstbetrieb12"))) || (!gemeinde1.containsBetrieb(gemeinde1.getBetriebByName("forstbetrieb13")))) {
            System.out.println("Fehler beim Einfuegen/ Entfernen von Forstbetrieben. ");
            return false;
        }


        gemeinde2.addBetrieb();
        gemeinde2.addBetrieb();
        gemeinde2.addBetrieb();
        gemeinde2.deleteBetrieb("forstbetrieb22");

        if ((!gemeinde2.containsBetrieb(gemeinde2.getBetriebByName("forstbetrieb21"))) || (gemeinde2.containsBetrieb(gemeinde2.getBetriebByName("forstbetrieb22"))) || (!gemeinde2.containsBetrieb(gemeinde2.getBetriebByName("forstbetrieb23")))) {
            System.out.println("Fehler beim Einfuegen/ Entfernen von Forstbetrieben. ");
            return false;
        }


        gemeinde3.addBetrieb();
        gemeinde3.addBetrieb();
        gemeinde3.addBetrieb("forstbetrieb33");
        gemeinde3.deleteBetrieb("forstbetrieb32");

        if ((!gemeinde3.containsBetrieb(gemeinde3.getBetriebByName("forstbetrieb31"))) || (gemeinde3.containsBetrieb(gemeinde3.getBetriebByName("forstbetrieb32"))) || (!gemeinde3.containsBetrieb(gemeinde3.getBetriebByName("forstbetrieb33")))) {
            System.out.println("Fehler beim Einfuegen/ Entfernen von Forstbetrieben. ");
            return false;
        }

        //Holzvollernter hinzufuegen/ entfernen/ Informationen aendern (ueber Name und Nummer)

        ernter1.setArbeitskopf(new Schneidearbeitskopf(20.5));
        gemeinde1.getBetriebByName("forstbetrieb11").addHolzvollernter(ernter1); // TODO anpassen
        gemeinde1.getBetriebByName("forstbetrieb11").changeInformationOfHolzvollernter(1, 24, 10.0, new Schneidearbeitskopf(100.0));

        gemeinde1.getBetriebByName("forstbetrieb13").addHolzvollernter(ernter2);
        gemeinde1.getBetriebByName("forstbetrieb13").changeInformationOfHolzvollernter(2, 32, 15,
                new HackschnitzelArbeitskopf(10));

        gemeinde1.getBetriebByName("forstbetrieb13").addHolzvollernter(ernter3);
        gemeinde1.getBetriebByName("forstbetrieb13").changeInformationOfHolzvollernter(3, 48, 13.0,
                new Schneidearbeitskopf(75.0));

        gemeinde1.getBetriebByName("forstbetrieb13").addHolzvollernter(ernter4);
        gemeinde1.getBetriebByName("forstbetrieb13").changeInformationOfHolzvollernter(4, 60, 20,
                new HackschnitzelArbeitskopf(10));

        gemeinde1.getBetriebByName("forstbetrieb13").addHolzvollernter(ernter5);
        gemeinde1.getBetriebByName("forstbetrieb13").changeInformationOfHolzvollernter(5, 72, 13.0,
                new Schneidearbeitskopf(125.0));
        gemeinde1.getBetriebByName("forstbetrieb13").deleteHolzvollernter(2);

        if ((!gemeinde1.getBetriebByName("forstbetrieb11").containsHolzvollernter(ernter1)) || (gemeinde1.getBetriebByName("forstbetrieb13").containsHolzvollernter(ernter2)) ||
                (!gemeinde1.getBetriebByName("forstbetrieb13").containsHolzvollernter(ernter3)) || (!gemeinde1.getBetriebByName("forstbetrieb13").containsHolzvollernter(ernter4)) ||
                (!gemeinde1.getBetriebByName("forstbetrieb13").containsHolzvollernter(ernter5))) {
            System.out.println("Fehler beim Einfuegen/ Entfernen von Holzvollerntern. ");
            return false;
        }

        if (!(ernter1.getName().equals(1)) || (!(ernter1.getBetriebsstunden() == 24)) || (!((double) ernter1.getDistanceMoved()==10.0)) ||
                (!(ernter1.getArbeitskopf() instanceof Schneidearbeitskopf))) {
            return false;
        }

        gemeinde2.getBetriebByName("forstbetrieb21").addHolzvollernter(ernter6);
        gemeinde2.getBetriebByName("forstbetrieb21").changeInformationOfHolzvollernter(6, 24, 32,
                new Schneidearbeitskopf(100.0));

        gemeinde2.getBetriebByName("forstbetrieb23").addHolzvollernter(ernter7);
        gemeinde2.getBetriebByName("forstbetrieb23").changeInformationOfHolzvollernter(7, 32, 10.0,
                new HackschnitzelArbeitskopf(10));

        gemeinde2.getBetriebByName("forstbetrieb23").addHolzvollernter(ernter8);
        gemeinde2.getBetriebByName("forstbetrieb23").changeInformationOfHolzvollernter(8, 28, 13,
                new HackschnitzelArbeitskopf(10));
        gemeinde2.getBetriebByName("forstbetrieb23").deleteHolzvollernter(7);

        if ((!gemeinde2.getBetriebByName("forstbetrieb21").containsHolzvollernter(ernter6)) || (gemeinde2.getBetriebByName("forstbetrieb23").containsHolzvollernter(ernter7)) ||
                (!gemeinde2.getBetriebByName("forstbetrieb23").containsHolzvollernter(ernter8))) {
            System.out.println("Fehler beim Einfuegen/ Entfernen von Holzvollerntern. ");
            return false;
        }

        gemeinde3.getBetriebByName("forstbetrieb31").addHolzvollernter(ernter9);
        gemeinde3.getBetriebByName("forstbetrieb31").changeInformationOfHolzvollernter(9, 24, 20.0,
                new Schneidearbeitskopf(100.0));

        gemeinde3.getBetriebByName("forstbetrieb33").addHolzvollernter(ernter10);
        gemeinde3.getBetriebByName("forstbetrieb33").changeInformationOfHolzvollernter(10, 32, 10,
                new HackschnitzelArbeitskopf(10));

        gemeinde3.getBetriebByName("forstbetrieb33").addHolzvollernter(ernter11);
        gemeinde3.getBetriebByName("forstbetrieb33").changeInformationOfHolzvollernter(11, 48, 13.0,
                new HackschnitzelArbeitskopf(10));
        gemeinde3.getBetriebByName("forstbetrieb33").deleteHolzvollernter(10);

        if ((!gemeinde3.getBetriebByName("forstbetrieb31").containsHolzvollernter(ernter9)) || (gemeinde3.getBetriebByName("forstbetrieb33").containsHolzvollernter(ernter10)) ||
                (!gemeinde3.getBetriebByName("forstbetrieb33").containsHolzvollernter(ernter11))) {
            System.out.println("Fehler beim Einfuegen/ Entfernen von Holzvollerntern. ");
            return false;
        }

        /*
        //statistische Werte - ALLER Forstbetriebe?!?
        CustomList avgWorkingHoursOfAll = gemeinde1.getBetriebByName("forstbetrieb13").getAvgWorkingHoursOfAll();
        if ((avgWorkingHoursOfAll.getElement(""))){
            return false;
        }

        gemeinde1.getBetriebByName("forstbetrieb13").getAvgWorkingHoursOfSpecific(new Schreiter()); //wieder ueber ID?
        gemeinde1.getBetriebByName("forstbetrieb13").getAvgDistance();
        gemeinde1.getBetriebByName("forstbetrieb13").getAvgSteps();
        gemeinde1.getBetriebByName("forstbetrieb13").getMaxAndMinPieceLength();
        gemeinde1.getBetriebByName("forstbetrieb13").getAvgTreeThickness(); */

        return true;
    }

    public boolean testUniqueNames() {
        // unique namen fuer Gemeinden
        boolean gemeindeExceptionCaught = false;
        boolean forstbetriebExceptionCaught = false;
        Gemeinde g1 = new Gemeinde("G1");
        try {
            new Gemeinde("G1");
        } catch (IllegalArgumentException ex) {
            gemeindeExceptionCaught = true;
        }
        // unique namen fuer forstbetriebe
        Forstbetrieb f1 = new Forstbetrieb("F1");
        try {
            new Forstbetrieb("F1");
        } catch (IllegalArgumentException ex) {
            forstbetriebExceptionCaught = true;
        }
        return gemeindeExceptionCaught && forstbetriebExceptionCaught;
    }

    public boolean testListFunctionality() {
        // rests auf empty liste
        CustomList l = new CustomList();
        if (!l.isEmpty()) {
            return false;
        }
        if (l.removeByName("something") != null) {
            return false;
        }
        try {
            if (l.getElement("some element") != null) {
                return false;
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            return false;
        }
        if(l.contains(new ListableNumber(5))){
            return false;
        }
        
        // elemente einfuegen
        
        return false;
    }
public boolean testStatistiken(){

}

}
