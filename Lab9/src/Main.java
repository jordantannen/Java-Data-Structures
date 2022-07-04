import java.util.Comparator;
import java.util.PriorityQueue;
import java.lang.Integer;

public class Main {
    public static void main(String args[]) {

        // creating a priority queue of flights
        PriorityQueue<Flight> flights = new PriorityQueue<>(10, new SortQueue());

        // populating the priority queue
        flights.add(new Flight(new Data("0001", 2002), 1));
        flights.add(new Flight(new Data("0002", 200), 1));
        flights.add(new Flight(new Data("0003", 330), 2));
        flights.add(new Flight(new Data("0004", 300), 3));
        flights.add(new Flight(new Data("0005", 200), 1));
        flights.add(new Flight(new Data("0006", 550), 1));
        flights.add(new Flight(new Data("0007", 3000), 2));
        flights.add(new Flight(new Data("0008", 1130), 3));
        flights.add(new Flight(new Data("0009", 1220), 3));
        flights.add(new Flight(new Data("0010", 757), 3));

        // Printing all elements
        System.out.println("The queue elements:");

        // create an array of data
        Data[] dataRecs = new Data[10];

        // loop through each flight and adds the highest item in queue to the array
        int i = 0;
        while (!flights.isEmpty()) {
            // store data
            dataRecs[i++] = new Data(flights.poll());
        }

        // for each record in the dataRecords array, print the name, the miles, and the priority
        for (Data recs : dataRecs)
            System.out.println(recs.getName() + " " + recs.getMiles()
                    + " " + recs.getPriority());
    }
}

class SortQueue implements Comparator<Flight> {
    @Override
    public int compare(Flight f1, Flight f2)
    {
        Integer f1Priority = f1.getPriority();
        Integer f2Priority = f2.getPriority();
        int comparePriority = f1Priority.compareTo(f2Priority);

        if (comparePriority != 0)
            return comparePriority;

        Integer f1Distance = f1.getData().miles;
        Integer f2Distance = f2.getData().miles;

        return f2Distance.compareTo(f1Distance);
    }
}

class Flight {
    Data data;
    private final int priority;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    Flight(Data data2, int priority) {
        this.data = data2;
        this.priority = priority;
    }

    public Flight() { priority = 0; }

    public int getPriority() { return priority; }

    @Override
    public String toString() {
        return "Flight{ priority = " + priority + ", miles = " 		+ data.getMiles()
                + ", Flight name = " + data.getName() + " }";
    }
}
