/**
 * Created by Abhijith on 6/22/2017.
 */

import edu.duke.*;

import java.util.*;

public class codonCount {
    private HashMap<String, Integer> map;

    public codonCount() {
        map = new HashMap<String, Integer>();
    }

    public static void main(String[] args) {
        codonCount cc = new codonCount();
        FileResource fr = new FileResource();
        String dna = fr.asString();
        cc.buildCodonMap(0, dna);
        for (String w : cc.map.keySet()) {
            int number = cc.map.get(w);
            System.out.println(w + "\t" + number);
        }
    }

    public void buildCodonMap(int start, String dna) {
        dna = dna.toUpperCase();
        int stopIndex = 0;
        while (stopIndex <= dna.length() - 3) {
            stopIndex = start + 3;
            //  if(!(stopIndex >= dna.length()-2)) {
            dna = dna.substring(start, stopIndex);
            if (map.keySet().contains(dna)) {
                map.put(dna, map.get(dna) + 1);
            } else {
                map.put(dna, 1);

            }
            start += 3;
        }
        //  else {
        //   break;
    }
    // start++;
}







