import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;

public class ArrayLab {
    public static void main(String[] args) {

        // Personal Data
        Date myDate = new Date();
        SimpleDateFormat dtToday = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println("Today's Date is: " +  dtToday.format(myDate));
        System.out.println("Programmer: Jordan Tannenbaum");
        System.out.println("-----------------------------------------------\n");

        // Instantiating arrays
        // Note that I shortened the instantiation from the lab. They are functionally identical, but I found this
        // easier to read.
        String[] myClientsArray = {"Butler", "Samuels", "Bond", "Chang", "Baker", "Davis", "Zheng", "Joe"};
        int[] myClientNumbers = {108, 121, 188, 107, 122, 111, 203, 135};

        // Original output
        System.out.println("Original output: ");
        linSearchString(myClientsArray, "Baker");
        linSearchInt(myClientNumbers, 108);
        System.out.println("\n-----------------------------------------------\n");

        // Getting user input
        System.out.println("Modified output: ");

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a client name to search: ");
        String name = input.nextLine();
        parallelSearchString(myClientsArray, myClientNumbers, name);

        System.out.println("\nEnter a number to search: ");
        int num = input.nextInt();
        parallelSearchInt(myClientsArray, myClientNumbers, num);

        System.out.println("\n-----------------------------------------------\n");

        // Creating copies of arrays. Used copyOf method as setting 2 arrays equal to each other only sets their
        // references equal, not their values.
        String[] sortedClients = Arrays.copyOf(myClientsArray, myClientsArray.length);
        Arrays.sort(sortedClients);
        int[] sortedNumbers = Arrays.copyOf(myClientNumbers, myClientNumbers.length);
        Arrays.sort(sortedNumbers);

        System.out.println("Sorted Clients (Ascending): " + Arrays.toString(sortedClients));
        System.out.println("Sorted Numbers (Ascending): " + Arrays.toString(sortedNumbers));

        System.out.println("\n-----------------------------------------------\n");

        // Printing sorted arrays with corresponding numbers
        System.out.println("Sorted names with corresponding numbers: \n");
        System.out.println("Name    Number");
        System.out.println("------- -------");
        parallelSortedPrint(sortedClients, myClientsArray, myClientNumbers);

    }

    // These use zero as an index. I put the if statement into the for loop as it was more readable for me
    public static void linSearchString(String[] strArray, String search) {
        int flag = 0;
        for(int i = 0; i < strArray.length; i++) {
            if (search.equals(strArray[i])) {
                System.out.println("item found at position " + (i));
                flag = 1;
            }
        }
        if (flag == 0)
            System.out.println("item not found");
    }

    public static void linSearchInt(int[] intArray, int num) {
        int flag = 0;
        for(int i = 0; i < intArray.length; i++) {
            if (num == intArray[i]) {
                System.out.println("item found at position " + (i));
                flag = 1;
            }
        }
        if (flag == 0)
            System.out.println("item not found");
    }

    // I modified this along with linSearchInt() from the lab's sample code to better work with my parallel search
    // methods.
    public static int linSearchStringNew(String[] strArray, String search) {
        for(int i = 0; i < strArray.length; i++) {
            if (search.equals(strArray[i])) {
                return i;
            }
        }
        // -1 used as an error
        return -1;
    }
    public static int linSearchIntNew(int[] intArray, int num) {
        for(int i = 0; i < intArray.length; i++) {
            if (num == intArray[i]) {
                return i;
            }
        }
        // -1 used as an error
        return -1;
    }

    // This method, along with parallelSearchInt print indexes under the assumption of index 0.
    public static void parallelSearchString(String[] clients, int[] numbers, String clientName){
        int index = linSearchStringNew(clients, clientName);
        if (index != -1)
            System.out.println("Client name \"" + clientName + "\" with client number " + numbers[index] + " found at index " + index + ".");
        else
            System.out.println("Client name not found");
    }

    public static void parallelSearchInt(String[] clients, int[] numbers, int clientNum){
        int index = linSearchIntNew(numbers, clientNum);
        if (index != -1)
            System.out.println("Client name \"" + clients[index] + "\" with client number \"" + clientNum + "\" found at index \"" + index + ".\"");
        else
            System.out.println("Client name not found");
    }

    public static void parallelSortedPrint(String[] sortedClients, String[] unsortedClients, int[] unsortedNumbers){
        for (String sortedClient : sortedClients) {
            for (int j = 0; j < unsortedClients.length; j++) {
                if (sortedClient.equals(unsortedClients[j])) {
                    System.out.printf("%-7s %-7s \n", sortedClient, unsortedNumbers[j]);
                }
            }
        }
    }
}
