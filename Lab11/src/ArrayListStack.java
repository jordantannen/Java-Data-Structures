import java.util.ArrayList;
import java.util.Collections;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class ArrayListStack
{
    // declare a class – level array list
    static ArrayList<String> list = new ArrayList<String>();

    public static void main(String args[])
    {

        // add an element to the array list
        list.add("client 1");
        // add an element to the array list
        list.add("client 2");
        // add an element to the array list
        list.add("client 3");
        // add an element to the array list
        list.add("client 4");

        // reverse the list to create the stack
        Collections.reverse(list);

        displayList();

        // push an element
        push("New client");
        displayList();

        System.out.println("Top() returns: " + top());

        // Print statement depending on ifEmpty()
        if (isEmpty())
            System.out.println("isEmpty() returned true. Arraylist is empty");
        else
            System.out.println("isEmpty() returned false. Arraylist is not empty");

        // pop an element
        pop();
        displayList();

        // pop an element
        pop();
        displayList();

        // push an element
        push("Another new client");
        displayList();

        // Removes remaining items in list
        while (!list.isEmpty())
            pop();

        // Final display
        displayList();

        // Print statement depending on ifEmpty()
        if (isEmpty())
            System.out.println("isEmpty() returned true. Arraylist is empty");
        else
            System.out.println("isEmpty() returned false. Arraylist is not empty");

    }

    // define the pop() method
    public static void pop()
    {
        // declare an object to manipulate the list
        Object obj = new Object();

        if (list.size() > 0)
        {
            obj = list.remove(0);
            System.out.println(obj + " is removed from ArrayList");
        }
        else
            System.out.println("empty list");
    }

    public static void push(Object input){
        Collections.reverse(list);
        list.add((String) input);
        System.out.println(input + " has been added to the ArrayList");
        Collections.reverse(list);
    }

    public static boolean isEmpty(){
        return list.isEmpty();
    }

    public static Object top(){
        if (isEmpty())
            return "Error. List ist empty";
        return list.get(0);
    }

    public static void displayList(){

        Date myDate = new Date();
        SimpleDateFormat dtToday = new SimpleDateFormat("MM/dd/yyyy");

        String currentList = "";

        for (Object element : list){
            currentList += element + "\n";
        }
        JOptionPane.showMessageDialog(null, dtToday.format(myDate) +
                "\n" + "display elements \n" + currentList);
    }
}
