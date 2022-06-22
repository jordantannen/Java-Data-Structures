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

        String[] myClientsArray = {"Butler", "Samuels", "Bond", "Chang", "Baker", "Davis", "Zheng", "Joe"};
        int[] myClientNumbers = {108, 121, 188, 107, 122, 111, 203, 135};

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a client name to search: ");
        String name = input.nextLine();
        parallelSearchString(myClientsArray, myClientNumbers, name);

        System.out.println("Enter a number to search: ");
        int num = input.nextInt();
        parallelSearchInt(myClientsArray, myClientNumbers, num);

        System.out.println("\n-----------------------------------------------\n");

        String[] sortedClients = Arrays.copyOf(myClientsArray, myClientsArray.length);
        Arrays.sort(sortedClients);
        int[] sortedNumbers = Arrays.copyOf(myClientNumbers, myClientNumbers.length);
        Arrays.sort(sortedNumbers);

        System.out.println("Sorted Clients (Ascending): " + Arrays.toString(sortedClients));
        System.out.println("Sorted Numbers (Ascending): " + Arrays.toString(sortedNumbers));

        System.out.println("\n-----------------------------------------------\n");
        System.out.println("Sorted names with corresponding numbers: \n");
        System.out.println("Name    Number");
        System.out.println("------- -------");
        parallelSortedPrint(sortedClients, myClientsArray, myClientNumbers);

    }
    public static int linSearchString(String[] strArray, String search)
    {
        for(int i = 0; i < strArray.length; i++)
        {
            if (search.equals(strArray[i]))
            {
                return i;
            }
        }
        // -1 used as an error
        return -1;
    }
    public static int linSearchInt(int[] intArray, int num)
    {
        for(int i = 0; i < intArray.length; i++)
        {
            if (num == intArray[i])
            {
                return i;
            }
        }
        // -1 used as an error
        return -1;
    }
    public static void parallelSearchString(String[] clients, int[] numbers, String clientName){
        int index = linSearchString(clients, clientName);
        if (index != -1)
            System.out.println("Client name \"" + clientName + "\" with client number \"" + numbers[index] + "\" found at index \"" + index + ".\"");
        else
            System.out.println("Client name not found");
    }

    public static void parallelSearchInt(String[] clients, int[] numbers, int clientNum){
        int index = linSearchInt(numbers, clientNum);
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
