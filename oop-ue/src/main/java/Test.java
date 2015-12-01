/**
 * Arbeitsaufteilung: Design und test wurde gemeinsam entwickelt und geschrieben
 *  Christoph Huber: add
 *  Michael Langowksi: get
 *  Ines Rieder: list, price, Zusicherungen
 */

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.keinSaegerauh());

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

}
