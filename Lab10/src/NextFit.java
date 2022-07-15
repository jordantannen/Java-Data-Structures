import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

public class NextFit extends FirstFit{

    public static final int DEFAULT_CAPACITY = 10;
    public NextFit(int binCapacity, ArrayList<Integer> itemsToPack){
        this.binCapacity = binCapacity;
        this.itemsToPack = itemsToPack;
        bins.put(1, new ArrayList<>());
    }
    public void sortBins(){
        boolean needBin = false;

        for (int item : itemsToPack) {
            for (int key : bins.keySet()){
                if (sumBin(bins.get(key)) + item <= binCapacity && key == bins.size()) {
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
}
