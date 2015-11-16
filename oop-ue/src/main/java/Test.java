import java.util.Iterator;

/**
 * Arbeitsaufteilung: 
 *  Christoph Huber: test1, test5, Bauholz, Baurundholz, Baukantholz, MyInteger
 *  Michael Langowksi: test4, SortedList, Smaller
 *  Ines Rieder: test2, test3, BasicSet
 */

public class Test {
    public static BasicSet<Integer> integerBasicSet = new BasicSet<>();

    public static SortedSet<MyInteger> integerSortedSet = new SortedSet<>();

    public static SortedSet<Baurundholz> baurundholzSortedSet = new SortedSet<>();

    public static SortedSet<Baukantholz> baukantholzSortedSet = new SortedSet<>();

    public static SortedSet<Bauholz> bauholzSortedSet = new SortedSet<>();

    public static BasicSet<Bauholz> bauholzBasicSet = new BasicSet<>();

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("Teststate of Test1:\t"+test.test1());
        System.out.println("Teststate of Test2:\t"+test.test2());
        System.out.println("Teststate of Test3:\t"+test.test3());
        System.out.println("Teststate of Test4:\t"+test.test4());
        System.out.println("Teststate of Test5:\t"+test.test5());
    }

    public boolean test1() {

        // create Sets
        integerBasicSet.add(new Integer(1));
        integerBasicSet.add(new Integer(5));
        integerBasicSet.add(new Integer(2));
        integerBasicSet.add(new Integer(8));

        integerSortedSet.add(new MyInteger(1));
        integerSortedSet.add(new MyInteger(9));
        integerSortedSet.add(new MyInteger(4));
        integerSortedSet.add(new MyInteger(3));

        baurundholzSortedSet.add(new Baurundholz(10,20));
        baurundholzSortedSet.add(new Baurundholz(20,35));
        baurundholzSortedSet.add(new Baurundholz(15,10));
        baurundholzSortedSet.add(new Baurundholz(45,15));


        baukantholzSortedSet.add(new Baukantholz(10,10,10));
        baukantholzSortedSet.add(new Baukantholz(15,20,50));
        baukantholzSortedSet.add(new Baukantholz(5,5,15));
        baukantholzSortedSet.add(new Baukantholz(20,55,45));


        System.out.println("IntergerBasicSet:"+integerBasicSet.toString());
        System.out.println("IntergerSortedSet:\n"+integerSortedSet.toString());
        System.out.println("BaurundholzSortedSet:\n"+baurundholzSortedSet.toString());
        System.out.println("BaukantholzSortedSet:\n"+baukantholzSortedSet.toString());

        // remove and add new on
        Iterator<Integer> it = integerBasicSet.iterator();
        Integer test = new Integer(it.next());
        it.remove();
        Iterator<Integer> it1 = integerBasicSet.iterator();
        while (it1.hasNext()) {
            if (it1.next() == test) {
                System.out.println("The deleted Element is still present in the BasicSet of Integers");
                return false;
            }
        }
        int toTest1 = 10;
        integerBasicSet.add(toTest1);
        Iterator<Integer> it2 = integerBasicSet.iterator();
        while (it2.hasNext()) {
            if(it2.next() != toTest1){
                if(!(it2.hasNext())) {
                    System.out.println("The new inserted value is not preseent in the BasicSet of Integers");
                    return false;
                }
            }
        }

        System.out.println("new correct IntegerBasicSet:\t"+integerBasicSet.toString());


        Iterator<MyInteger> i = integerSortedSet.iterator();
        MyInteger toTestIntergerSortedSet = new MyInteger(it.next());
        it.remove();
        Iterator<MyInteger> i1 = integerSortedSet.iterator();
        while (i1.hasNext()) {
            if (i1.next() == toTestIntergerSortedSet) {
                System.out.println("The deleted Element is still present in the SortedSet of Integers");
                return false;
            }
        }

        MyInteger toTestIntegerSortedSet1 = new MyInteger(12);
        integerSortedSet.add(toTestIntegerSortedSet1);
        Iterator<MyInteger> i2 = integerSortedSet.iterator();
        while (i2.hasNext()) {
            if(i2.next() != toTestIntegerSortedSet1){
                if(!(i2.hasNext())) {
                    System.out.println("The new inserted value is not preseent in the SortedSet of Integers");
                    return false;
                }
            }
        }

        System.out.println("new correct IntegerSortedSet:\n"+integerSortedSet);

        return true;
    }

    public boolean test2() {

        for (Baurundholz tmp : baurundholzSortedSet) {
            bauholzSortedSet.add(tmp);
        }
        for (Baukantholz tmp : baukantholzSortedSet) {
            bauholzSortedSet.add(tmp);
        }

        SortedSet.ListElem<Baurundholz> currentBaurundholz = baurundholzSortedSet.head;
        SortedSet.ListElem<Baukantholz> currentBaukantholz = baukantholzSortedSet.head;

        for (Bauholz tmp : bauholzSortedSet) {
            if (tmp instanceof Baurundholz) {
                if (tmp != currentBaurundholz.getValue()) {
                    return false;
                }
                currentBaurundholz = currentBaurundholz.getNext();
            } else {
                if (tmp != currentBaukantholz.getValue()) {
                    return false;
                }
                currentBaukantholz = currentBaukantholz.getNext();
            }
        }

        return true;
    }

    public boolean test3() {

        bauholzBasicSet = bauholzSortedSet;

        SortedSet.ListElem<Baurundholz> currentBaurundholz = baurundholzSortedSet.head;
        SortedSet.ListElem<Baukantholz> currentBaukantholz = baukantholzSortedSet.head;

        for (Bauholz tmp : bauholzBasicSet) {
            if (tmp instanceof Baurundholz) {
                if (tmp != currentBaurundholz.getValue()) {
                    return false;
                }
                currentBaurundholz = currentBaurundholz.getNext();
            } else {
                if (tmp != currentBaukantholz.getValue()) {
                    return false;
                }
                currentBaukantholz = currentBaukantholz.getNext();
            }
        }

        return true;

    }

    public boolean test4() {
        // Tests for smaller
        MyInteger i1 = new MyInteger(3);
        MyInteger i2 = new MyInteger(4);
        Baurundholz brh1 = new Baurundholz(10, 4);
        Baurundholz brh2 = new Baurundholz(10, 5);
        Baukantholz bkh1 = new Baukantholz(10, 5, 4);
        Baukantholz bkh2 = new Baukantholz(10, 5, 5);
        return this.testSmallerLogic(i1, i2)
                && this.testSmallerLogic(brh1, brh2)
                && this.testSmallerLogic(bkh1, bkh2);
    }
    public boolean test5(){
        BasicSet<Integer> integerBasicSet1 = new BasicSet<>();

        Integer integer1 = new Integer(1);
        integerBasicSet1.add(integer1);
        integerBasicSet1.add(integer1);
        integerBasicSet1.add(new Integer(2));
        integerBasicSet1.add(new Integer(8));
        integerBasicSet1.add(new Integer(1));
        //zwei gleiche Zahlen im BasicSet, aber nicht gleiche Speicherstelle

        System.out.println("IntegerBasicSet in Test5:\t"+integerBasicSet1.toString());

        boolean state=false;
        Iterator<Integer> it = integerBasicSet1.iterator();
        while (it.hasNext()){
            if(it.next() == integer1){
                if (state==false){
                    state = true;
                }else{
                    System.out.println("An identical value occurs twice in the Set");
                    return false;
                }
            }
        }

        SortedSet<MyInteger> integerSortedSet1 = new SortedSet<>();

        MyInteger myInteger1 = new MyInteger(1);

        integerSortedSet1.add(myInteger1);
        integerSortedSet1.add(myInteger1);
        integerSortedSet1.add(new MyInteger(4));
        integerSortedSet1.add(new MyInteger(3));
        integerSortedSet1.add(new MyInteger(1));
        //zwei gleiche Zahlen im SortedSet, aber nicht gleiche Speicherstelle

        System.out.println("IntegerSortedSet in Test5:\n"+integerSortedSet1.toString());
        state=false;
        Iterator<MyInteger> i = integerSortedSet1.iterator();
        while (i.hasNext()){
            if(i.next() == myInteger1){
                if (state==false){
                    state = true;
                }else{
                    System.out.println("An identical value occurs twice in the Set");
                    return false;
                }
            }
        }

        return true;
    }

    private <T extends Smaller<? super T>> boolean testSmallerLogic(T s1, T s2) {
        return ((s1.smaller(s2)) && !(s2.smaller(s1)));
    }
}
