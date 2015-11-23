/**
 * Arbeitsaufteilung:
 *  Christoph Huber: Forstbetrieb, CustomList, ListableNumber, Listable,
 *  Michael Langowksi: Holzvollernter, Radernter, Schreiter, Abstractarbeitskopf, Schneidearbeitskopf, Hackschnitzelarbeitskopf,
 *      HolzConstraint, KeyValueListable, StringListable, UniqueNameProvider
 *  Ines Rieder: Gemeinde, Test, Zusicherungen
 */

public class Test {

    private Gemeinde     gemeinde1      = new Gemeinde("gemeinde1");
    private Gemeinde     gemeinde2      = new Gemeinde("gemeinde2");
    private Gemeinde     gemeinde3      = new Gemeinde("gemeinde3");

    private Forstbetrieb forstbetrieb11 = new Forstbetrieb("forstbetrieb11");
    private Forstbetrieb forstbetrieb12 = new Forstbetrieb("forstbetrieb12");
    private Forstbetrieb forstbetrieb13 = new Forstbetrieb("forstbetrieb13");

    private Forstbetrieb forstbetrieb21 = new Forstbetrieb("forstbetrieb21");
    private Forstbetrieb forstbetrieb22 = new Forstbetrieb("forstbetrieb22");
    private Forstbetrieb forstbetrieb23 = new Forstbetrieb("forstbetrieb23");

    private Forstbetrieb forstbetrieb31 = new Forstbetrieb("forstbetrieb31");
    private Forstbetrieb forstbetrieb32 = new Forstbetrieb("forstbetrieb32");
    private Forstbetrieb forstbetrieb33 = new Forstbetrieb("forstbetrieb33");

    private Radernter    ernter1        = new Radernter();
    private Schreiter    ernter2        = new Schreiter();
    private Radernter    ernter3        = new Radernter();
    private Schreiter    ernter4        = new Schreiter();
    private Radernter    ernter5        = new Radernter();
    private Schreiter    ernter6        = new Schreiter();
    private Radernter    ernter7        = new Radernter();
    private Schreiter    ernter8        = new Schreiter();
    private Radernter    ernter9        = new Radernter();
    private Schreiter    ernter10       = new Schreiter();
    private Radernter    ernter11       = new Radernter();

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("Genereller Test:\t" + test.test());
        System.out.println("CustomList Test:\t" + test.testListFunctionality());
        System.out.println("CustomList Typesafety Test:\t" + test.testListTypeSafety());
        System.out.println("UniqueNames Test:\t" + test.testUniqueNames());
        System.out.println("Statistiken Test\t"+ test.testStatistiken());
    }

    private boolean test() {
        //3 Gemeinden erstellen, je 3 Forstbetriebe hinzufuegen und einen wieder entfernen (ueber eindeutigen Namen)

        gemeinde1.addBetrieb(forstbetrieb11);
        gemeinde1.addBetrieb(forstbetrieb12);
        gemeinde1.addBetrieb(forstbetrieb13);
        gemeinde1.deleteBetrieb("forstbetrieb12");

        if ((!gemeinde1.containsBetrieb(gemeinde1.getBetriebByName("forstbetrieb11")))
            || (gemeinde1.containsBetrieb(gemeinde1.getBetriebByName("forstbetrieb12")))
            || (!gemeinde1.containsBetrieb(gemeinde1.getBetriebByName("forstbetrieb13")))) {
            System.out.println("Fehler beim Einfuegen/ Entfernen von Forstbetrieben. ");
            return false;
        }

        gemeinde2.addBetrieb(forstbetrieb21);
        gemeinde2.addBetrieb(forstbetrieb22);
        gemeinde2.addBetrieb(forstbetrieb23);
        gemeinde2.deleteBetrieb("forstbetrieb22");

        if ((!gemeinde2.containsBetrieb(gemeinde2.getBetriebByName("forstbetrieb21")))
            || (gemeinde2.containsBetrieb(gemeinde2.getBetriebByName("forstbetrieb22")))
            || (!gemeinde2.containsBetrieb(gemeinde2.getBetriebByName("forstbetrieb23")))) {
            System.out.println("Fehler beim Einfuegen/ Entfernen von Forstbetrieben. ");
            return false;
        }

        gemeinde3.addBetrieb(forstbetrieb31);
        gemeinde3.addBetrieb(forstbetrieb32);
        gemeinde3.addBetrieb(forstbetrieb33);
        gemeinde3.deleteBetrieb("forstbetrieb32");

        if ((!gemeinde3.containsBetrieb(gemeinde3.getBetriebByName("forstbetrieb31")))
            || (gemeinde3.containsBetrieb(gemeinde3.getBetriebByName("forstbetrieb32")))
            || (!gemeinde3.containsBetrieb(gemeinde3.getBetriebByName("forstbetrieb33")))) {
            System.out.println("Fehler beim Einfuegen/ Entfernen von Forstbetrieben. ");
            return false;
        }

        //Holzvollernter hinzufuegen/ entfernen/ Informationen aendern (ueber Name und Nummer)

        ernter1.setArbeitskopf(new Schneidearbeitskopf(20.5));
        gemeinde1.getBetriebByName("forstbetrieb11").addHolzvollernter(ernter1);
        gemeinde1.getBetriebByName("forstbetrieb11").changeInformationOfHolzvollernter(1, 24, 10.0,
                new Schneidearbeitskopf(100.0));

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

        if ((!gemeinde1.getBetriebByName("forstbetrieb11").containsHolzvollernter(ernter1))
            || (gemeinde1.getBetriebByName("forstbetrieb13").containsHolzvollernter(ernter2))
            || (!gemeinde1.getBetriebByName("forstbetrieb13").containsHolzvollernter(ernter3))
            || (!gemeinde1.getBetriebByName("forstbetrieb13").containsHolzvollernter(ernter4))
            || (!gemeinde1.getBetriebByName("forstbetrieb13").containsHolzvollernter(ernter5))) {
            System.out.println("Fehler beim Einfuegen/ Entfernen von Holzvollerntern. ");
            return false;
        }

        if (!(ernter1.getId() == 1) || (!(ernter1.getBetriebsstunden() == 24))
            || (!((double) ernter1.getDistanceMoved() == 10.0))
            || (!(ernter1.getArbeitskopf() instanceof Schneidearbeitskopf))) {
            System.out.println("Fehler bei changeInformationOfHolzvollernter. ");
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

        if ((!gemeinde2.getBetriebByName("forstbetrieb21").containsHolzvollernter(ernter6))
            || (gemeinde2.getBetriebByName("forstbetrieb23").containsHolzvollernter(ernter7))
            || (!gemeinde2.getBetriebByName("forstbetrieb23").containsHolzvollernter(ernter8))) {
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

        if ((!gemeinde3.getBetriebByName("forstbetrieb31").containsHolzvollernter(ernter9))
            || (gemeinde3.getBetriebByName("forstbetrieb33").containsHolzvollernter(ernter10))
            || (!gemeinde3.getBetriebByName("forstbetrieb33").containsHolzvollernter(ernter11))) {
            System.out.println("Fehler beim Einfuegen/ Entfernen von Holzvollerntern. ");
            return false;
        }

        gemeinde1.show();
        gemeinde2.show();
        gemeinde3.show();
        return true;
    }

    private boolean testUniqueNames() {
        // unique namen fuer Gemeinden
        boolean gemeindeExceptionCaught = false;
        boolean forstbetriebExceptionCaught = false;
        new Gemeinde("G1");
        try {
            new Gemeinde("G1");
        } catch (IllegalArgumentException ex) {
            gemeindeExceptionCaught = true;
        }
        // unique namen fuer forstbetriebe
        new Forstbetrieb("F1");
        try {
            new Forstbetrieb("F1");
        } catch (IllegalArgumentException ex) {
            forstbetriebExceptionCaught = true;
        }
        return gemeindeExceptionCaught && forstbetriebExceptionCaught;
    }

    private boolean testListFunctionality() {
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
        if (l.contains(new StringListable("Hallo"))) {
            return false;
        }

        l.insert(new StringListable("Bla"));
        if (!l.contains(new StringListable("Bla"))) {
            return false;
        }
        l.removeByName("Bla");
        if (!l.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean testListTypeSafety() {
        CustomList l = new CustomList();
        l.insert(new Radernter());
        // typen duerfen innerhalb der Liste nicht gemischt werden
        // Expected: nichts passiert, Element nicht in der Liste
        l.insert(new StringListable("Blubb"));
        return !l.contains(new StringListable("Blubb"));
    }

    public boolean testStatistiken() {

        // Forstbetrieb 11 Auswertung
        CustomList customListforstbetrieb11 = new CustomList();
        customListforstbetrieb11 = forstbetrieb11.getAvgWorkingHoursOfAll();
        KeyValueListable keyValueListable = null;
        KeyValueListable keyValueListable1 = null;
        KeyValueListable keyValueListable2 = null;
        KeyValueListable keyValueListable3 = null;

        System.out.println();
        System.out.println();
        System.out.println("\tUntersuchter Forstbetrieb: "+forstbetrieb11.getName());
        System.out.println("\t\tenthaltene Ernter: "+ ernter1.getClass().getSimpleName()+" mit einem " +ernter1.getArbeitskopf().getClass().getSimpleName());
        System.out.println();

        //test AvgWorkingHoursOfAll
        keyValueListable = (KeyValueListable)customListforstbetrieb11.getElement("Schneidearbeitskopf");
        keyValueListable1 = (KeyValueListable)customListforstbetrieb11.getElement("HackschnitzelArbeitskopf");
        System.out.println("\tTest Durschnittliche Arbeitszeit aufgeschluesselt nach Arbeitskoepfen:");
        System.out.println("\t\t"+keyValueListable.getKey()+":\t\t"+keyValueListable.getValue());
        System.out.println("\t\t"+keyValueListable1.getKey()+":\t"+keyValueListable1.getValue());

        if(keyValueListable.getValue() != 24.0){
            System.out.println("Im "+forstbetrieb11.getName()+" ist die Betriebsstundenanzahl der "+keyValueListable.getKey()+" falsch");
            return false;
        }
        if(keyValueListable1.getValue() != 0.0){
            System.out.println("Im "+forstbetrieb11.getName()+" ist die Betriebsstundenanzahl der "+keyValueListable1.getKey()+" falsch");
            return false;
        }

        //test AvgWorkingHoursOfSpecific
        customListforstbetrieb11 = forstbetrieb11.getAvgWorkingHoursOfSpecific();

        keyValueListable = (KeyValueListable)customListforstbetrieb11.getElement("Radernter");
        keyValueListable1 = (KeyValueListable)customListforstbetrieb11.getElement("Schreiter");
        System.out.println("\tTest Durschnittliche Arbeitszeit aufgeschluesselt nach Holzvollernter:");
        System.out.println("\t\t"+keyValueListable.getKey()+":\t"+keyValueListable.getValue());
        System.out.println("\t\t"+keyValueListable1.getKey()+":\t"+keyValueListable1.getValue());

        if(keyValueListable.getValue() != 24.0){
            System.out.println("Im "+forstbetrieb11.getName()+" ist die Betriebsstundenanzahl der "+keyValueListable.getKey()+" falsch");
            return false;
        }
        if(keyValueListable1.getValue() != 0.0){
            System.out.println("Im "+forstbetrieb11.getName()+" ist die Betriebsstundenanzahl der "+keyValueListable1.getKey()+" falsch");
            return false;
        }


        //test getAvgDistance
        customListforstbetrieb11 = forstbetrieb11.getAvgDistance();

        keyValueListable = (KeyValueListable)customListforstbetrieb11.getElement("Schneidearbeitskopf");
        keyValueListable1 = (KeyValueListable)customListforstbetrieb11.getElement("HackschnitzelArbeitskopf");
        System.out.println("\tTest Durschnittliche zurueckgelegten Distanz von Radernter:");
        System.out.println("\t\t"+keyValueListable.getKey()+":\t\t"+keyValueListable.getValue());
        System.out.println("\t\t"+keyValueListable1.getKey()+":\t"+keyValueListable1.getValue());

        if(keyValueListable.getValue() != 10.0){
            System.out.println("Im "+forstbetrieb11.getName()+" ist die Distanz der "+keyValueListable.getKey()+" falsch");
            return false;
        }
        if(keyValueListable1.getValue() != 0.0){
            System.out.println("Im "+forstbetrieb11.getName()+" ist die Distanz der "+keyValueListable1.getKey()+" falsch");
            return false;
        }

        //test getAvgSteps
        customListforstbetrieb11 = forstbetrieb11.getAvgSteps();

        keyValueListable = (KeyValueListable)customListforstbetrieb11.getElement("Schneidearbeitskopf");
        keyValueListable1 = (KeyValueListable)customListforstbetrieb11.getElement("HackschnitzelArbeitskopf");
        System.out.println("\tTest Durschnittliche zurueckgelegten Schritte von Schreitern:");
        System.out.println("\t\t"+keyValueListable.getKey()+":\t\t"+keyValueListable.getValue());
        System.out.println("\t\t"+keyValueListable1.getKey()+":\t"+keyValueListable1.getValue());

        if(keyValueListable.getValue() != 0.0){
            System.out.println("Im "+forstbetrieb11.getName()+" sind die Schritte der "+keyValueListable.getKey()+" falsch");
            return false;
        }
        if(keyValueListable1.getValue() != 0.0){
            System.out.println("Im "+forstbetrieb11.getName()+" sind die Schritte der "+keyValueListable1.getKey()+" falsch");
            return false;
        }

        //test Min Max Test
        customListforstbetrieb11 = forstbetrieb11.getMaxAndMinPieceLength();

        keyValueListable = (KeyValueListable)customListforstbetrieb11.getElement("Radernter Minimum");
        keyValueListable1 = (KeyValueListable)customListforstbetrieb11.getElement("Radernter Maximum");
        keyValueListable2 = (KeyValueListable)customListforstbetrieb11.getElement("Schreiter Minimum");
        keyValueListable3 = (KeyValueListable)customListforstbetrieb11.getElement("Schreiter Maximum");
        System.out.println("\tTest minimale und maximale Stuecklaenge von Schneidearbeitskoepfen:");
        System.out.println("\t\t"+keyValueListable.getKey()+":\t"+keyValueListable.getValue());
        System.out.println("\t\t"+keyValueListable1.getKey()+":\t"+keyValueListable1.getValue());
        System.out.println("\t\t"+keyValueListable2.getKey()+":\t"+keyValueListable2.getValue());
        System.out.println("\t\t"+keyValueListable3.getKey()+":\t"+keyValueListable3.getValue());

        if(keyValueListable.getValue() != 100.0){
            System.out.println("Im "+forstbetrieb11.getName()+" ist das "+keyValueListable.getKey()+"falsch");
            return false;
        }
        if(keyValueListable1.getValue() != 100.0){
            System.out.println("Im "+forstbetrieb11.getName()+" ist das "+keyValueListable1.getKey()+" falsch");
            return false;
        }
        if(keyValueListable2.getValue() != 0.0){
            System.out.println("Im "+forstbetrieb11.getName()+" ist das "+keyValueListable2.getKey()+" falsch");
            return false;
        }
        if(keyValueListable3.getValue() != 0.0){
            System.out.println("Im "+forstbetrieb11.getName()+" ist das "+keyValueListable3.getKey()+" falsch");
            return false;
        }


        //test getAvgTreeThickness
        customListforstbetrieb11 = forstbetrieb11.getAvgTreeThickness();

        keyValueListable = (KeyValueListable)customListforstbetrieb11.getElement("Radernter");
        keyValueListable1 = (KeyValueListable)customListforstbetrieb11.getElement("Schreiter");
        System.out.println("\tTest Durschnittliche Baumdicke von HackschnitzelArbeitskoepfen:");
        System.out.println("\t\t"+keyValueListable.getKey()+":\t"+keyValueListable.getValue());
        System.out.println("\t\t"+keyValueListable1.getKey()+":\t"+keyValueListable1.getValue());

        if(keyValueListable.getValue() != 0.0){
            System.out.println("Im "+forstbetrieb11.getName()+" ist die durchschnittliche Baumdicke bei "+keyValueListable.getKey()+" falsch");
            return false;
        }
        if(keyValueListable1.getValue() != 0.0){
            System.out.println("Im "+forstbetrieb11.getName()+" ist die durchschnittliche Baumdicke bei  "+keyValueListable1.getKey()+" falsch");
            return false;
        }


        //Forstbetrieb34
        Forstbetrieb forstbetrieb34 = new Forstbetrieb("forstbetrieb34");
        forstbetrieb34.addHolzvollernter(ernter10);
        forstbetrieb34.addHolzvollernter(ernter11);
        forstbetrieb34.changeInformationOfHolzvollernter(10,12,34,new HackschnitzelArbeitskopf(14));
        forstbetrieb34.changeInformationOfHolzvollernter(11,12,34.0,new Schneidearbeitskopf(14));

        CustomList customListforstbetrieb34 = new CustomList();
        customListforstbetrieb34 = forstbetrieb34.getAvgWorkingHoursOfAll();
        KeyValueListable keyValueListable4 = null;
        KeyValueListable keyValueListable5 = null;
        KeyValueListable keyValueListable6 = null;
        KeyValueListable keyValueListable7 = null;

        System.out.println();
        System.out.println();
        System.out.println("\tUntersuchter Forstbetrieb: "+forstbetrieb34.getName());
        System.out.println("\t\tenthaltene Ernter: \t"+ernter10.getClass().getSimpleName() +" mit einem "+ernter10.getArbeitskopf().getClass().getSimpleName());
        System.out.println("\t\t\t\t\t\t\t"+ernter11.getClass().getSimpleName() +" mit einem "+ernter11.getArbeitskopf().getClass().getSimpleName());
        System.out.println();

        //test AvgWorkingHoursOfAll
        keyValueListable4 = (KeyValueListable)customListforstbetrieb34.getElement("Schneidearbeitskopf");
        keyValueListable5 = (KeyValueListable)customListforstbetrieb34.getElement("HackschnitzelArbeitskopf");
        System.out.println("\tTest Durschnittliche Arbeitszeit aufgeschluesselt nach Arbeitskoepfen:");
        System.out.println("\t\t"+keyValueListable4.getKey()+":\t\t"+keyValueListable4.getValue());
        System.out.println("\t\t"+keyValueListable5.getKey()+":\t"+keyValueListable5.getValue());

        if(keyValueListable4.getValue() != 12.0){
            System.out.println("Im "+forstbetrieb34.getName()+" ist die Betriebsstundenanzahl der "+keyValueListable4.getKey()+" falsch");
            return false;
        }
        if(keyValueListable5.getValue() != 12.0){
            System.out.println("Im "+forstbetrieb34.getName()+" ist die Betriebsstundenanzahl der "+keyValueListable5.getKey()+" falsch");
            return false;
        }

        //test AvgWorkingHoursOfSpecific
        customListforstbetrieb34 = forstbetrieb34.getAvgWorkingHoursOfSpecific();

        keyValueListable4 = (KeyValueListable)customListforstbetrieb34.getElement("Radernter");
        keyValueListable5 = (KeyValueListable)customListforstbetrieb34.getElement("Schreiter");
        System.out.println("\tTest Durschnittliche Arbeitszeit aufgeschluesselt nach Holzvollernter:");
        System.out.println("\t\t"+keyValueListable4.getKey()+":\t"+keyValueListable4.getValue());
        System.out.println("\t\t"+keyValueListable5.getKey()+":\t"+keyValueListable5.getValue());

        if(keyValueListable4.getValue() != 12.0){
            System.out.println("Im "+forstbetrieb34.getName()+" ist die Betriebsstundenanzahl der "+keyValueListable4.getKey()+" falsch");
            return false;
        }
        if(keyValueListable5.getValue() != 12.0){
            System.out.println("Im "+forstbetrieb34.getName()+" ist die Betriebsstundenanzahl der "+keyValueListable5.getKey()+" falsch");
            return false;
        }


        //test getAvgDistance
        customListforstbetrieb34 = forstbetrieb34.getAvgDistance();

        keyValueListable4 = (KeyValueListable)customListforstbetrieb34.getElement("Schneidearbeitskopf");
        keyValueListable5 = (KeyValueListable)customListforstbetrieb34.getElement("HackschnitzelArbeitskopf");
        System.out.println("\tTest Durschnittliche zurueckgelegten Distanz von Radernter:");
        System.out.println("\t\t"+keyValueListable4.getKey()+":\t\t"+keyValueListable4.getValue());
        System.out.println("\t\t"+keyValueListable5.getKey()+":\t"+keyValueListable5.getValue());

        if(keyValueListable4.getValue() != 47.0){
            System.out.println("Im "+forstbetrieb34.getName()+" ist die Distanz der "+keyValueListable4.getKey()+" falsch");
            return false;
        }
        if(keyValueListable5.getValue() != 0.0){
            System.out.println("Im "+forstbetrieb34.getName()+" ist die Distanz der "+keyValueListable5.getKey()+" falsch");
            return false;
        }

        //test getAvgSteps
        customListforstbetrieb34 = forstbetrieb34.getAvgSteps();

        keyValueListable4 = (KeyValueListable)customListforstbetrieb34.getElement("Schneidearbeitskopf");
        keyValueListable5 = (KeyValueListable)customListforstbetrieb34.getElement("HackschnitzelArbeitskopf");
        System.out.println("\tTest Durschnittliche zurueckgelegten Schritte von Schreitern:");
        System.out.println("\t\t"+keyValueListable4.getKey()+":\t\t"+keyValueListable4.getValue());
        System.out.println("\t\t"+keyValueListable5.getKey()+":\t"+keyValueListable5.getValue());

        if(keyValueListable4.getValue() != 0.0){
            System.out.println("Im "+forstbetrieb34.getName()+" sind die Schritte der "+keyValueListable4.getKey()+" falsch");
            return false;
        }
        if(keyValueListable5.getValue() != 44.0){
            System.out.println("Im "+forstbetrieb34.getName()+" sind die Schritte der "+keyValueListable5.getKey()+" falsch");
            return false;
        }

        //test Min Max Test
        customListforstbetrieb34 = forstbetrieb34.getMaxAndMinPieceLength();

        keyValueListable5 = (KeyValueListable)customListforstbetrieb34.getElement("Radernter Minimum");
        keyValueListable4 = (KeyValueListable)customListforstbetrieb34.getElement("Radernter Maximum");
        keyValueListable6 = (KeyValueListable)customListforstbetrieb34.getElement("Schreiter Minimum");
        keyValueListable7 = (KeyValueListable)customListforstbetrieb34.getElement("Schreiter Maximum");
        System.out.println("\tTest minimale und maximale Stuecklaenge von Schneidearbeitskoepfen:");
        System.out.println("\t\t"+keyValueListable4.getKey()+":\t"+keyValueListable4.getValue());
        System.out.println("\t\t"+keyValueListable5.getKey()+":\t"+keyValueListable5.getValue());
        System.out.println("\t\t"+keyValueListable6.getKey()+":\t"+keyValueListable6.getValue());
        System.out.println("\t\t"+keyValueListable7.getKey()+":\t"+keyValueListable7.getValue());

        if(keyValueListable4.getValue() != 14.0){
            System.out.println("Im "+forstbetrieb34.getName()+" ist das "+keyValueListable4.getKey()+"falsch");
            return false;
        }
        if(keyValueListable5.getValue() != 14.0){
            System.out.println("Im "+forstbetrieb34.getName()+" ist das "+keyValueListable5.getKey()+" falsch");
            return false;
        }
        if(keyValueListable6.getValue() != 0.0){
            System.out.println("Im "+forstbetrieb34.getName()+" ist das "+keyValueListable6.getKey()+" falsch");
            return false;
        }
        if(keyValueListable7.getValue() != 0.0){
            System.out.println("Im "+forstbetrieb34.getName()+" ist das "+keyValueListable7.getKey()+" falsch");
            return false;
        }


        //test getAvgTreeThickness
        customListforstbetrieb34 = forstbetrieb34.getAvgTreeThickness();

        keyValueListable4 = (KeyValueListable)customListforstbetrieb34.getElement("Radernter");
        keyValueListable5 = (KeyValueListable)customListforstbetrieb34.getElement("Schreiter");
        System.out.println("\tTest Durschnittliche Baumdicke von HackschnitzelArbeitskoepfen:");
        System.out.println("\t\t"+keyValueListable4.getKey()+":\t"+keyValueListable4.getValue());
        System.out.println("\t\t"+keyValueListable5.getKey()+":\t"+keyValueListable5.getValue());

        if(keyValueListable4.getValue() != 0.0){
            System.out.println("Im "+forstbetrieb34.getName()+" ist die durchschnittliche Baumdicke bei "+keyValueListable4.getKey()+" falsch");
            return false;
        }
        if(keyValueListable5.getValue() != 14.0){
            System.out.println("Im "+forstbetrieb34.getName()+" ist die durchschnittliche Baumdicke bei  "+keyValueListable5.getKey()+" falsch");
            return false;
        }
        return true;
    }

}
