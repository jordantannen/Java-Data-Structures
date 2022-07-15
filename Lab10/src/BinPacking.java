import java.util.ArrayList;
import java.util.*;

class BinPacking {
    int capacity;
    int[] itemsToPack = new int[100];
    int binNumber;
    int totalNumBins;

    public static void main(String args[]) {
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(7);
        testList.add(8);
        testList.add(1);
        testList.add(2);
        testList.add(4);
        testList.add(6);
        FirstFit test = new FirstFit(8, testList);
        test.sortBins();


        ArrayList<Integer> vect = new ArrayList<>();
        int count = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("how many items are to be packed? ");
        int number = sc.nextInt();

        System.out.println("enter the bin capacity? ");
        int upperBound = sc.nextInt();

        while (count < number) {
            vect.add(getRandomValue(upperBound));
            count++;
        }

        System.out.println("-----------------------------");
        System.out.println("\nitems to pack: ");
        print(vect);

    }
    public static int getRandomValue(int ub)
    {
        return Math.abs(new Random().nextInt()) % ub + 1;
    }
    public static void print(ArrayList<Integer>  a)
    {
        for (Integer integer : a) System.out.print(integer + " ");
        System.out.println("\n-----------------------------");
    }

}
