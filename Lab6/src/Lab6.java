import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Lab6 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
//        FileWriter file = new FileWriter("data.txt");
//        PrintWriter outFile = new PrintWriter(file);
        FileReader inFile = new FileReader("data.txt");
        BufferedReader br = new BufferedReader(inFile);

        int numRecords = 0;
        String desc = "";
        double cost = 0;
        int quantity = 0;
        char location = '\0';

//        System.out.println("How many records are for processing?");
//        numRecords = input.nextInt();
//
//        for (int i = 0; i < numRecords; i++){
//            input.nextLine();
//            System.out.println("item description");
//            desc = input.nextLine();
//
//            System.out.println("item cost");
//            cost = input.nextDouble();
//
//            System.out.println("item quantity");
//            quantity = input.nextInt();
//
//            System.out.println("item location");
//            location = input.next().charAt(0);
//
//            outFile.print(desc + ",");
//            outFile.print(cost + ",");
//            outFile.print(quantity + ",");
//            outFile.println(location);
//        }
        System.out.println("Item, Cost, Quantity, Location Code");
        System.out.println("-----------------------------------");
        String line = "";
        try{
            double sum = 0;
            int count = 0;
            int costOver100 = 0;

            HashMap<String, Integer> locations = new HashMap<>();

            while((line = br.readLine()) != null){
                // Default Output
                String[] data = line.split(",");
                System.out.println(data[0] + ", $" + data[1] + ", " + data[2] + ", " + data[3]);

                // To determine avg item quantity
                sum += Integer.parseInt(data[2]);
                count++;

                // To determine how many items have a total cost over $100
                if (Double.parseDouble(data[1]) * Double.parseDouble(data[2]) > 100)
                    costOver100++;

                if(!locations.containsKey(data[3])){
                    locations.put(data[3], 1);
                }
                else{
                    locations.put(data[3], locations.get(data[3]) + 1);
                }
            }
            System.out.println("-----------------------------------");
            System.out.println("Average quantity: " + sum / count);
            System.out.println("-----------------------------------");
            System.out.println("Amount of items with a total cost over $100: " + costOver100);
            System.out.println("-----------------------------------");
            for (String i : locations.keySet()){
                System.out.println("Location " + i + " has " + locations.get(i) + " value(s).");
            }

        } catch (IOException e){
            e.printStackTrace();
        }
//        input.close();
//        outFile.close();
    }
}
