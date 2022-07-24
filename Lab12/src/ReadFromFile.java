import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class ReadFromFile {

    public static void main(String args[]) throws ParseException {
        Scanner scan = null;
        int count = 0;
        boolean isFirstRow = true;

        // Creating HashMap of parallel arrays in the form of ArrayLists, as discussed in office hours
        HashMap<String, ArrayList<String>> parallelArrays = new HashMap<>();
        ArrayList<String> firstRow = new ArrayList<>();

        try {
            System.out.println("Data Set: \n");
            scan = new Scanner(new File("lab12.txt"));

            while (scan.hasNextLine()) {
                String[] arr = scan.nextLine().split(",");

                // Prints and formats each record
                for (int i = 0; i < arr.length; i++){
                    if ((i == 3 || i == 4 || i == 5) && !isFirstRow){
                        System.out.printf("$%-15s", arr[i]);
                    }
                    else {
                        System.out.printf("%-15s", arr[i]);
                    }

                    if (isFirstRow){
                        firstRow.add(arr[i]);
                        parallelArrays.put(arr[i], new ArrayList<>());
                    }
                    else {
                        parallelArrays.get(firstRow.get(i)).add(arr[i]);
                    }

                }
                // Counts each record, excluding the first row
                System.out.println();
                if (!isFirstRow)
                    count++;
                else {
                    System.out.println("-------------------------------------------------------------------------------------------");
                    isFirstRow = false;
                }
            }
            // Print total records
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println("Total Records: " + count);

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            scan.close();
        }

        // Calculate and print total reward cash
        System.out.println("-------------------------------------------------------------------------------------------");
        double totalCash = getTotal(parallelArrays.get(firstRow.get(5)));
        System.out.printf("Total Reward Cash Issued: $%.2f", totalCash);

        // Calculate and print ratio of total reward cash per total customer purchases
        double totalPurchases = getTotal(parallelArrays.get(firstRow.get(3)));
        System.out.println("\n-------------------------------------------------------------------------------------------");
        System.out.printf("Total Customer Purchases Issued: $%.2f", totalPurchases);
        System.out.printf("\nThe ratio of total reward cash to total customer purchases is: $%.2f" +
                " Reward Cash to $%.2f worth of total purchases.", totalCash, totalPurchases);
        System.out.printf("\nIn decimal format this is roughly $%.2f reward cash per dollar spent.", totalCash / totalPurchases);

        System.out.printf("\n\nPlease note, if this question is referring to reward cash per purchases made (as it how many times " +
                "things were bought, regardless of expense) \nthat ratio would be $%.2f reward cash per " + count + " total purchases." +
                " In decimal form this would be $%.2f reward cash per purchase.", totalCash, totalCash / count);

        // Determines and lists distinct customers that are not members of the rewards program
        System.out.println("\n-------------------------------------------------------------------------------------------");
        System.out.println("Customers Not in Rewards Program: ");
        ArrayList<String> hasBeenPrinted = new ArrayList<>();
        for (int i = 0; i < count; i++){
            if (Objects.equals(parallelArrays.get(firstRow.get(1)).get(i), "No")
                    && !hasBeenPrinted.contains(parallelArrays.get(firstRow.get(0)).get(i))){
                System.out.println(parallelArrays.get(firstRow.get(0)).get(i));
                hasBeenPrinted.add(parallelArrays.get(firstRow.get(0)).get(i));
            }
        }

        // Compare transaction dates
        // As discussed in office hours, we are able to code this assuming the transaction data is in order
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Range of Transaction Dates: ");

        // The last date is set to a string to avoid a really long line.
        String lastDateStr = parallelArrays.get(firstRow.get(2)).get(parallelArrays.get(firstRow.get(2)).size() - 1);

        Date firstDate = new SimpleDateFormat("MM/dd/yyyy").parse(parallelArrays.get(firstRow.get(2)).get(0));
        Date lastDate = new SimpleDateFormat("MM/dd/yyyy").parse(lastDateStr);
        System.out.println(lastDate.getDate() - firstDate.getDate() +
                " days ranging from " + parallelArrays.get(firstRow.get(2)).get(0) + " to " + lastDateStr);
    }

    public static double getTotal(ArrayList<String> list){
        double total = 0;
        for (String item : list)
            total += Double.parseDouble(item);
        return total;
    }
}

