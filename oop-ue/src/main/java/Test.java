import java.util.Iterator;

/**
 * Arbeitsaufteilung: Christoph Huber: Forstbetrieb, CustomList, ListableNumber, Michael Langowksi:
 * Holzvollernter, Abstractarbeitskopf Ines Rieder: Gemeinde, Test
 */

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("Teststate:\t" + test.test());
    }

    public boolean test() {
        //3 Gemeinden erstellen, je 3 Forstbetriebe hinzufuegen und einen wieder entfernen (ueber eindeutigen Namen)
        Gemeinde gemeinde1 = new Gemeinde("gemeinde1");
        gemeinde1.addBetrieb("forstbetrieb11");
        gemeinde1.addBetrieb("forstbetrieb12");
        gemeinde1.addBetrieb("forstbetrieb13");
        gemeinde1.deleteBetrieb("forstbetrieb12");

        if ((!gemeinde1.containsBetrieb(gemeinde1.getBetriebByName("forstbetrieb11"))) || (gemeinde1.containsBetrieb(gemeinde1.getBetriebByName("forstbetrieb12"))) || (!gemeinde1.containsBetrieb(gemeinde1.getBetriebByName("forstbetrieb13")))) {
            System.out.println("Fehler beim Einfuegen/ Entfernen von Forstbetrieben. ");
            return false;
        }

        Gemeinde gemeinde2 = new Gemeinde("gemeinde2");
        gemeinde2.addBetrieb("forstbetrieb21");
        gemeinde2.addBetrieb("forstbetrieb22");
        gemeinde2.addBetrieb("forstbetrieb23");
        gemeinde2.deleteBetrieb("forstbetrieb22");

        if ((!gemeinde2.containsBetrieb(gemeinde2.getBetriebByName("forstbetrieb21"))) || (gemeinde2.containsBetrieb(gemeinde2.getBetriebByName("forstbetrieb22"))) || (!gemeinde2.containsBetrieb(gemeinde2.getBetriebByName("forstbetrieb23")))) {
            System.out.println("Fehler beim Einfuegen/ Entfernen von Forstbetrieben. ");
            return false;
        }

        Gemeinde gemeinde3 = new Gemeinde("gemeinde3");
        gemeinde3.addBetrieb("forstbetrieb31");
        gemeinde1.addBetrieb("forstbetrieb32");
        gemeinde3.addBetrieb("forstbetrieb33");
        gemeinde3.deleteBetrieb("forstbetrieb32");

        if ((!gemeinde3.containsBetrieb(gemeinde3.getBetriebByName("forstbetrieb31"))) || (gemeinde3.containsBetrieb(gemeinde3.getBetriebByName("forstbetrieb32"))) || (!gemeinde3.containsBetrieb(gemeinde3.getBetriebByName("forstbetrieb33")))) {
            System.out.println("Fehler beim Einfuegen/ Entfernen von Forstbetrieben. ");
            return false;
        }

        //Holzvollernter hinzufuegen/ entfernen/ Informationen aendern (ueber Name und Nummer)
        // TODO Ines die Ernter muessen extern angelegt werden und geaddet, z.B
        Radernter ernter1 = new Radernter();
        ernter1.setArbeitskopf(new Schneidearbeitskopf(20.5));
        gemeinde1.getBetriebByName("forstbetrieb11").addHolzvollernter(ernter1); // TODO anpassen
        gemeinde1.getBetriebByName("forstbetrieb11").changeInformationOfHolzvollernter(1, 24, 10.0, new Schneidearbeitskopf(100.0));
        Schreiter ernter2 = new Schreiter();
        gemeinde1.getBetriebByName("forstbetrieb13").addHolzvollernter(ernter2);
        gemeinde1.getBetriebByName("forstbetrieb13").changeInformationOfHolzvollernter(2, 32, 15,
                new HackschnitzelArbeitskopf(10));
        Radernter ernter3 = new Radernter();
        gemeinde1.getBetriebByName("forstbetrieb13").addHolzvollernter(ernter3);
        gemeinde1.getBetriebByName("forstbetrieb13").changeInformationOfHolzvollernter(3, 48, 13.0,
                new Schneidearbeitskopf(75.0));
        Schreiter ernter4 = new Schreiter();
        gemeinde1.getBetriebByName("forstbetrieb13").addHolzvollernter(ernter4);
        gemeinde1.getBetriebByName("forstbetrieb13").changeInformationOfHolzvollernter(4, 60, 20,
                new HackschnitzelArbeitskopf(10));
        Radernter ernter5 = new Radernter();
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

        Schreiter ernter6 = new Schreiter();
        gemeinde2.getBetriebByName("forstbetrieb21").addHolzvollernter(ernter6);
        gemeinde2.getBetriebByName("forstbetrieb21").changeInformationOfHolzvollernter(6, 24, 32,
                new Schneidearbeitskopf(100.0));
        Radernter ernter7 = new Radernter();
        gemeinde2.getBetriebByName("forstbetrieb23").addHolzvollernter(ernter7);
        gemeinde2.getBetriebByName("forstbetrieb23").changeInformationOfHolzvollernter(7, 32, 10.0,
                new HackschnitzelArbeitskopf(10));
        Schreiter ernter8 = new Schreiter();
        gemeinde2.getBetriebByName("forstbetrieb23").addHolzvollernter(ernter8);
        gemeinde2.getBetriebByName("forstbetrieb23").changeInformationOfHolzvollernter(8, 28, 13,
                new HackschnitzelArbeitskopf(10));
        gemeinde2.getBetriebByName("forstbetrieb23").deleteHolzvollernter(7);

        if ((!gemeinde2.getBetriebByName("forstbetrieb21").containsHolzvollernter(ernter6)) || (gemeinde2.getBetriebByName("forstbetrieb23").containsHolzvollernter(ernter7)) ||
                (!gemeinde2.getBetriebByName("forstbetrieb23").containsHolzvollernter(ernter8))) {
            System.out.println("Fehler beim Einfuegen/ Entfernen von Holzvollerntern. ");
            return false;
        }

        Radernter ernter9 = new Radernter();
        gemeinde3.getBetriebByName("forstbetrieb31").addHolzvollernter(ernter9);
        gemeinde3.getBetriebByName("forstbetrieb31").changeInformationOfHolzvollernter(9, 24, 20.0,
                new Schneidearbeitskopf(100.0));
        Schreiter ernter10 = new Schreiter();
        gemeinde3.getBetriebByName("forstbetrieb33").addHolzvollernter(ernter10);
        gemeinde3.getBetriebByName("forstbetrieb33").changeInformationOfHolzvollernter(10, 32, 10,
                new HackschnitzelArbeitskopf(10));
        Radernter ernter11 = new Radernter();
        gemeinde3.getBetriebByName("forstbetrieb33").addHolzvollernter(ernter11);
        gemeinde3.getBetriebByName("forstbetrieb33").changeInformationOfHolzvollernter(11, 48, 13.0,
                new HackschnitzelArbeitskopf(10));
        gemeinde3.getBetriebByName("forstbetrieb33").deleteHolzvollernter(10);

        if ((!gemeinde3.getBetriebByName("forstbetrieb31").containsHolzvollernter(ernter9)) || (gemeinde3.getBetriebByName("forstbetrieb33").containsHolzvollernter(ernter10)) ||
                (!gemeinde3.getBetriebByName("forstbetrieb33").containsHolzvollernter(ernter11))) {
            System.out.println("Fehler beim Einfuegen/ Entfernen von Holzvollerntern. ");
            return false;
        }

        //TODO: Tests
        //statistische Werte - ALLER Forstbetriebe?!?
        gemeinde1.getBetriebByName("forstbetrieb13").getAvgWorkingHoursOfAll();
        gemeinde1.getBetriebByName("forstbetrieb13").getAvgWorkingHoursOfSpecific(new Schreiter()); //wieder ueber ID?
        gemeinde1.getBetriebByName("forstbetrieb13").getAvgDistance();
        gemeinde1.getBetriebByName("forstbetrieb13").getAvgSteps();
        gemeinde1.getBetriebByName("forstbetrieb13").getMaxAndMinPieceLength();
        gemeinde1.getBetriebByName("forstbetrieb13").getAvgTreeThickness();

        return true;
    }

}
