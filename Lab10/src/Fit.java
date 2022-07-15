import java.util.HashMap;
import java.util.ArrayList;

public class Fit {
    private ArrayList<Integer> itemsToPack = new ArrayList<>();
    private HashMap<Integer, ArrayList<Integer>> bins = new HashMap<>();
    private int binCapacity;
    private int totalBins;
    public static final int DEFAULT_CAPACITY = 10;

    public Fit(){
        this(DEFAULT_CAPACITY, new ArrayList<>());
    }

    public Fit(int binCapacity, ArrayList<Integer> itemsToPack){
        this.binCapacity = binCapacity;
        this.itemsToPack = itemsToPack;
        bins.put(1, new ArrayList<>());
        totalBins++;
    }

    public int getTotalBins(){
        return totalBins;
    }

    public void printBinTotals(){
        for (int key : bins.keySet()){
            System.out.println("Bin " + key + " value is : " + sumBin(bins.get(key)));
        }
    }

    private int sumBin(ArrayList<Integer> bin){
        int count = 0;
        for (int item : bin)
            count += item;
        return count;
    }
}
