import java.util.HashMap;
import java.util.ArrayList;

public class FirstFit {
    private ArrayList<Integer> itemsToPack;
    private int binCapacity;
    private int totalBins;
    private HashMap<Integer, ArrayList<Integer>> bins = new HashMap<>();

    public static final int DEFAULT_CAPACITY = 10;

    public FirstFit(){
        this(DEFAULT_CAPACITY, new ArrayList<>());
    }

    public FirstFit(int binCapacity, ArrayList<Integer> itemsToPack){
        this.binCapacity = binCapacity;
        this.itemsToPack = itemsToPack;
        bins.put(1, new ArrayList<>());
        totalBins++;
    }

    public void sortBins(){
        boolean needBin = false;

        for (int item : itemsToPack) {
            for (int key : bins.keySet()){
                if (sumBin(bins.get(key)) + item <= binCapacity) {
                    bins.get(key).add(item);
                    needBin = false;
                    break;
                }
                needBin = true;
            }
            if (needBin) {
                bins.put(bins.size() + 1, new ArrayList<>());
                bins.get(bins.size()).add(item);
                totalBins++;
            }
        }
        System.out.println(bins);
    }

    public int getTotalBins(){
        return totalBins;
    }

    public void printBinTotals(){
        for (int key : bins.keySet()){
            System.out.println("Bin " + key + " value is : " + sumBin(bins.get(key)));
        }
    }

    int sumBin(ArrayList<Integer> bin){
        int count = 0;
        for (int item : bin)
            count += item;
        return count;
    }

}
