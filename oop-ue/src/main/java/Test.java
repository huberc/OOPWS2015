/**
 * @author Christoph Huber e1427322@student.tuwien.ac.at
 */
public class Test {

    public static void main(String[] args) {

    }

    public static boolean Test1(){

        BasicSet<Integer> integerBasicSet = new BasicSet<>();

        integerBasicSet.add(1);
        integerBasicSet.add(5);
        integerBasicSet.add(2);
        integerBasicSet.add(8);

        SortedSet<MyInteger> integerSortedSet = new SortedSet<>();

        integerSortedSet.add(new MyInteger(1));
        integerSortedSet.add(new MyInteger(9));
        integerSortedSet.add(new MyInteger(4));
        integerSortedSet.add(new MyInteger(3));

        SortedSet<Baurundholz> baurundholzSortedSet = new SortedSet<>();

        baurundholzSortedSet.add(new Baurundholz(10,20));
        baurundholzSortedSet.add(new Baurundholz(20,35));
        baurundholzSortedSet.add(new Baurundholz(15,10));
        baurundholzSortedSet.add(new Baurundholz(45,15));

        SortedSet<Baukantholz> baukantholzSortedSet = new SortedSet<>();

        baukantholzSortedSet.add(new Baukantholz(10,10,10));
        baukantholzSortedSet.add(new Baukantholz(15,20,50));
        baukantholzSortedSet.add(new Baukantholz(5,5,15));
        baukantholzSortedSet.add(new Baukantholz(20,55,45));

        return false;
    }

    public static boolean Test2(){

        return false;
    }
}
