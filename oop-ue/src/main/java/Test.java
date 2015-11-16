import java.util.Iterator;

/**
 * @author Christoph Huber e1427322@student.tuwien.ac.at
 */
public class Test {
    private BasicSet<Integer> integerBasicSet = new BasicSet<>();

    private SortedSet<MyInteger> integerSortedSet = new SortedSet<>();

    private SortedSet<Baurundholz> baurundholzSortedSet = new SortedSet<>();

    private SortedSet<Baukantholz> baukantholzSortedSet = new SortedSet<>();

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

    public static boolean Test2(){

        return false;
    }
}
