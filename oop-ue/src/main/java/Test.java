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
        Forstbetrieb forstbetrieb11 = new Forstbetrieb("forstbetrieb11");
        gemeinde1.addBetrieb("forstbetrieb11");
        Forstbetrieb forstbetrieb12 = new Forstbetrieb("forstbetrieb12");
        gemeinde1.addBetrieb("forstbetrieb12");
        Forstbetrieb forstbetrieb13 = new Forstbetrieb("forstbetrieb13");
        gemeinde1.addBetrieb("forstbetrieb13");
        gemeinde1.deleteBetrieb("forstbetrieb12");

        Gemeinde gemeinde2 = new Gemeinde("gemeinde2");
        Forstbetrieb forstbetrieb21 = new Forstbetrieb("forstbetrieb21");
        gemeinde2.addBetrieb("forstbetrieb21");
        Forstbetrieb forstbetrieb22 = new Forstbetrieb("forstbetrieb22");
        gemeinde2.addBetrieb("forstbetrieb22");
        Forstbetrieb forstbetrieb23 = new Forstbetrieb("forstbetrieb23");
        gemeinde2.addBetrieb("forstbetrieb23");
        gemeinde2.deleteBetrieb("forstbetrieb22");

        Gemeinde gemeinde3 = new Gemeinde("gemeinde3");
        Forstbetrieb forstbetrieb31 = new Forstbetrieb("forstbetrieb31");
        gemeinde3.addBetrieb("forstbetrieb31");
        Forstbetrieb forstbetrieb32 = new Forstbetrieb("forstbetrieb32");
        gemeinde1.addBetrieb("forstbetrieb32");
        Forstbetrieb forstbetrieb33 = new Forstbetrieb("forstbetrieb33");
        gemeinde3.addBetrieb("forstbetrieb33");
        gemeinde3.deleteBetrieb("forstbetrieb32");

        //Holzvollernter hinzufuegen/ entfernen/ Informationen aendern (ueber Name und Nummer)
        // TODO Ines die Ernter muessen extern angelegt werden und geaddet, z.B
        Radernter ernter1 = new Radernter();
        ernter1.setArbeitskopf(new Schneidearbeitskopf(20.5));
        gemeinde1.getBetriebByName("forstbetrieb11").addHolzvollernter(ernter1); // TODO anpassen

        gemeinde1.getBetriebByName("forstbetrieb11").addHolzvollernter(1);
        gemeinde1.getBetriebByName("forstbetrieb11").changeInformationOfHolzvollernter(1, 24, 15,
                new Schneidearbeitskopf(100.0));
        gemeinde1.getBetriebByName("forstbetrieb13").addHolzvollernter(2);
        gemeinde1.getBetriebByName("forstbetrieb13").changeInformationOfHolzvollernter(2, 32, 10.0,
                new HackschnitzelArbeitskopf(10));
        gemeinde1.getBetriebByName("forstbetrieb13").addHolzvollernter(3);
        gemeinde1.getBetriebByName("forstbetrieb13").changeInformationOfHolzvollernter(3, 48, 13.0,
                new Schneidearbeitskopf(75.0));
        gemeinde1.getBetriebByName("forstbetrieb13").addHolzvollernter(4);
        gemeinde1.getBetriebByName("forstbetrieb13").changeInformationOfHolzvollernter(4, 60, 20,
                new HackschnitzelArbeitskopf(10));
        gemeinde1.getBetriebByName("forstbetrieb13").addHolzvollernter(5);
        gemeinde1.getBetriebByName("forstbetrieb13").changeInformationOfHolzvollernter(5, 72, 13.0,
                new Schneidearbeitskopf(125.0));
        gemeinde1.getBetriebByName("forstbetrieb13").deleteHolzvollernter(2);

        gemeinde2.getBetriebByName("forstbetrieb21").addHolzvollernter(1);
        gemeinde2.getBetriebByName("forstbetrieb21").changeInformationOfHolzvollernter(1, 24, 32,
                new Schneidearbeitskopf(100.0));
        gemeinde2.getBetriebByName("forstbetrieb23").addHolzvollernter(2);
        gemeinde2.getBetriebByName("forstbetrieb23").changeInformationOfHolzvollernter(2, 32, 10.0,
                new HackschnitzelArbeitskopf(10));
        gemeinde2.getBetriebByName("forstbetrieb23").addHolzvollernter(3);
        gemeinde2.getBetriebByName("forstbetrieb23").changeInformationOfHolzvollernter(3, 28, 13.0,
                new HackschnitzelArbeitskopf(10));
        gemeinde2.getBetriebByName("forstbetrieb23").deleteHolzvollernter(2);

        gemeinde3.getBetriebByName("forstbetrieb31").addHolzvollernter(1);
        gemeinde3.getBetriebByName("forstbetrieb31").changeInformationOfHolzvollernter(1, 24, 32,
                new Schneidearbeitskopf(100.0));
        gemeinde3.getBetriebByName("forstbetrieb33").addHolzvollernter(2);
        gemeinde3.getBetriebByName("forstbetrieb33").changeInformationOfHolzvollernter(2, 32, 10.0,
                new HackschnitzelArbeitskopf(10));
        gemeinde3.getBetriebByName("forstbetrieb33").addHolzvollernter(3);
        gemeinde3.getBetriebByName("forstbetrieb33").changeInformationOfHolzvollernter(3, 48, 13.0,
                new HackschnitzelArbeitskopf(10));
        gemeinde3.getBetriebByName("forstbetrieb33").deleteHolzvollernter(2);

        //TODO: Tests
        //statistische Werte - ALLER Forstbetriebe?!?
        gemeinde1.getBetriebByName("forstbetrieb13").getAvgWorkingHoursOfAll();
        gemeinde1.getBetriebByName("forstbetrieb13").getAvgWorkingHoursOfSpecific(2); //wieder ueber ID?
        gemeinde1.getBetriebByName("forstbetrieb13").getAvgDistance();
        gemeinde1.getBetriebByName("forstbetrieb13").getAvgSteps();
        gemeinde1.getBetriebByName("forstbetrieb13").getMaxAndMinPieceLength();
        gemeinde1.getBetriebByName("forstbetrieb13").getAvgTreeThickness();

        return true;
    }

}
