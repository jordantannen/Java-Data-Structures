import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DupFinder {
    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new File("names.dat"));
            HashMap<String, Integer> dupCount = new HashMap<>();
            ArrayList<String> sortedList = new ArrayList<>();

            // Modification to sorting list code. Adds each item from names.dat to a hashmap to keep track
            // of duplicates per name. Also adds each item once to an arraylist to make a sorted list.
            while (reader.hasNext()){
                String currentItem = reader.next();
                if (dupCount.containsKey(currentItem)){
                    dupCount.put(currentItem, dupCount.get(currentItem) + 1);
                }
                else {
                    dupCount.put(currentItem, 0);
                    sortedList.add(currentItem);
                }
            }

            // Sorts and prints sorted list
            Collections.sort(sortedList);
            System.out.println("Sorted List:");
            for (String item : sortedList){
                System.out.print(item + " ");
            }

            // Prints duplicates per name
            System.out.println("\n\nDuplicates Per Name:");
            System.out.println("\n***Note that duplicates are any copy of the name that appear AFTER the first copy");
            System.out.println("Example: If \"Bob\" appears 4 times, the name has 3 duplicates.***\n");
            int totalDups = 0;
            for (String name : dupCount.keySet()){
                System.out.println("The name \"" + name + "\" has " + dupCount.get(name) + " duplicate(s).");
                totalDups += dupCount.get(name);
            }

            System.out.println("\nTotal Duplicates in File: " + totalDups);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
