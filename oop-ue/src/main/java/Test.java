import java.util.Iterator;

/**
 * @author Christoph Huber e1427322@student.tuwien.ac.at
 */
public class Test {
    public static BasicSet<Integer> integerBasicSet = new BasicSet<>();

    public static SortedSet<MyInteger> integerSortedSet = new SortedSet<>();

    public static SortedSet<Baurundholz> baurundholzSortedSet = new SortedSet<>();

    public static SortedSet<Baukantholz> baukantholzSortedSet = new SortedSet<>();

    public static SortedSet<Bauholz> bauholzSortedSet = new SortedSet<>();

    public static BasicSet<Bauholz> bauholzBasicSet = new BasicSet<>();

    public static void main(String[] args) {
      test1();
    }

    public static void test1(){

        // create Sets
        integerBasicSet.add(1);
        integerBasicSet.add(1);
        integerBasicSet.add(5);
        integerBasicSet.add(2);
        integerBasicSet.add(8);

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


        System.out.println(integerBasicSet.toString());
        System.out.println(integerSortedSet.toString());
        System.out.println(baurundholzSortedSet.toString());
        System.out.println(baukantholzSortedSet.toString());

        // remove and add new on
        Iterator<Integer> it = integerBasicSet.iterator();
        it.next();
        it.remove();

    }

    public boolean test2(){
        
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
            }
            else {
                if (tmp != currentBaukantholz.getValue()) {
                    return false;
                }
                currentBaukantholz = currentBaukantholz.getNext();
            }
        }
        
        return true;
    }
    
    public boolean test3(){
        
        bauholzBasicSet = bauholzSortedSet;

        SortedSet.ListElem<Baurundholz> currentBaurundholz = baurundholzSortedSet.head;
        SortedSet.ListElem<Baukantholz> currentBaukantholz = baukantholzSortedSet.head;
        
        for (Bauholz tmp : bauholzBasicSet) {
            if (tmp instanceof Baurundholz) {
                if (tmp != currentBaurundholz.getValue()) {
                    return false;
                }
                currentBaurundholz = currentBaurundholz.getNext();
            }
            else {
                if (tmp != currentBaukantholz.getValue()) {
                    return false;
                }
                currentBaukantholz = currentBaukantholz.getNext();
            }
        }
        
        return true;
        
    }
    
    public boolean test4(){
    	// Tests for smaller
    	MyInteger i1 = new MyInteger(3);
    	MyInteger i2 = new MyInteger(4);
    	Baurundholz brh1 = new Baurundholz(5, 10);
    	Baurundholz brh2 = new Baurundholz(4, 10);
    	Baukantholz bkh1 = new Baukantholz(5, 5, 10);
    	Baukantholz bkh2 = new Baukantholz(5, 4, 10);
    	return this.testSmallerLogic(i1, i2)
    			&& this.testSmallerLogic(brh1, brh2)
    			&& this.testSmallerLogic(bkh1, bkh2);
    }
    
    private <T extends Smaller<? super T>> boolean testSmallerLogic(T s1, T s2){
    	return ((s1.smaller(s2)) && !(s2.smaller(s1)));
    }
}
