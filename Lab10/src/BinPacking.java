import java.util.ArrayList;
import java.util.*;

class BinPacking {
    public static void main(String args[]) {

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

        // Displays info for FirstFit
        System.out.println("\nFirst Fit Results: ");
        FirstFit vectFirstFit = new FirstFit(upperBound, vect);
        vectFirstFit.printAllResults();

        System.out.println("-----------------------------");
        System.out.println("\nNext Fit Results: ");
        // Displats info for NextFit
        NextFit vectNextFit = new NextFit(upperBound, vect);
        vectNextFit.printAllResults();


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
