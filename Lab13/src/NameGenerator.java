import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class NameGenerator {
    public static void main(String[] args) throws IOException {
        String[] peoples =
                {"Bob", "Carol", "Ted", "Alice", };

        // Converted this from list to arraylist, per office hours, to make adding
        // to the list easier.
        ArrayList<String> names = new ArrayList<>(Arrays.asList(peoples));
        Collections.shuffle(names);
        System.out.println("Initial Shuffled Names:");
        for (String name : names) {
            System.out.print(name + " ");
        }

        // Create and display all potential names that could be inserted into the list
        String[] randNameList = {"Bob", "Carol", "Ted", "Alice", "Jordan",
                                "Nick", "Ben", "Bruce", "Jennie"};

        System.out.println("\n\nPool of Randomly Inserted Names: ");
        for (String name : randNameList){
            System.out.print(name + " ");
        }

        // Create a new random object to randomly add names to the list
        Random rand = new Random();

        for (int i = 0; i < 10; i++){
            names.add(randNameList[rand.nextInt(8) + 1]);
        }

        System.out.println("\n\nShuffled Names With 10 Inserted Names:");
        Collections.shuffle(names);
        for (String name : names) {
            System.out.print(name + " ");
        }

        //Write to names.dat

        BufferedWriter bw = new BufferedWriter(new FileWriter("names.dat"));

        for (String item : names){
            bw.write(item + " ");
        }
        bw.close();

    }
}