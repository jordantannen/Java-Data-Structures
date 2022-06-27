import java.util.ArrayList;
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

// Name: Jordan Tannenbaum
public class ArrayListQueue
{
    // declare an array list
    static ArrayList<String> list = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args)
    {
        // declare a Date object and its formatting
        Date myDate = new Date();
        String myDateFormat = "MM/dd/yyyy";
        SimpleDateFormat dtToday = new SimpleDateFormat(myDateFormat);

        // populate the list with some initial elements (queue)
        list.add("customer 1");
        list.add("customer 2");
        list.add("customer 3");
        list.add("customer 4");
        list.add("customer 5");
        enqueue("Steve");
        enqueue("Lance");
        enqueue("Betsy");
        dequeue();
        enqueue("Marissa");
        dequeue();
        dequeue();
        dequeue();
        enqueue("Raul");
        enqueue("Sandy");
        dequeue();
        enqueue("Jordan");
        enqueue("Ben");
        enqueue("Bruce");
        dequeue();
        dequeue();

        // declare a StringBuilder object to display the list elements
        StringBuilder sb = new StringBuilder();
        // declare an Iterator object to cycle through the list elements
        Iterator<String> itr = list.iterator();

        // use a looping structure to display the list elements
        System.out.println("iterate through ArrayList elements ...");
        while(itr.hasNext())
        {
            // append the elements to the StringBuilder object
            sb.append(itr.next()).append("\n");
        }

        // display the elements that are in the list (queue)
        JOptionPane.showMessageDialog(null, dtToday.format(myDate) +
                "\nDisplay Queue \nCustomers Served: " + count + "\nNote: The bottom of this list is the front of the queue" +
                "\n--------------------------------------------\n" + sb);
    }

    public static void enqueue(String name){
        list.add(0, name);
    }

    public static String dequeue(){
        if (!isEmpty()){
            custCount();
            return list.remove(list.size() - 1);
        }
        return "Error, queue is empty";
    }

    public static boolean isEmpty(){
        return list.isEmpty();
    }

    public static void custCount(){
        count++;
    }
}
