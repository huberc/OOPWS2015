/**
 * Arbeitsaufteilung: Christoph Huber: Michael Langowski: Ines Rieder:
 */

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
    }

    public boolean testLagerBasics() {
        BauholzLager lager = new BauholzLager();
        Bauholz b;
        b = new RundholzGehobelt(1, 2, 3);
        lager.add(b);
        b = new RundholzSaegerauh(4, 5, 6);
        lager.add(b);
        b = new KantholzGehobelt(7, 8, 9, 10);
        lager.add(b);
        b = new KantholzSaegerauh(11, 12, 13, 14);
        lager.add(b);
        lager.list();
        return true;
    }

}
