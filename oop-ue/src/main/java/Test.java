import java.util.Iterator;

/**
 * @author Christoph Huber e1427322@student.tuwien.ac.at
 */
public class Test {
    private BasicSet<Integer> integerBasicSet = new BasicSet<>();

    private SortedSet<MyInteger> integerSortedSet = new SortedSet<>();

    private SortedSet<Baurundholz> baurundholzSortedSet = new SortedSet<>();

    private SortedSet<Baukantholz> baukantholzSortedSet = new SortedSet<>();
    
    private SortedSet<Bauholz> bauholzSortedSet = new SortedSet<>();
    
    private BasicSet<Bauholz> bauholzBasicSet = new BasicSet<>();

    public static void main(String[] args) {

    }

    public void Test1(){

        // create Sets
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


    }

    public boolean Test2(){
        
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
    
    public boolean Test3(){
        
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
}
