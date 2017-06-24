/**
 * Created by Abhijith on 6/22/2017.
 *  Assignment 4: Codon Count
 * The program finds out how many times each codon occurs in a strand
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
        cc.tester();

    }

    public String getMostCommonCodeon() {
        String maxValue = "";
        int maxValueInMap = (Collections.max(map.values()));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                maxValue = entry.getKey();

            }
        }
        return maxValue;
    }
    public void printCodonCounts(int start, int end) {
        int count = 0;
        for (String key : map.keySet()) {
            int value = map.get(key);
            if (value >= start && value <= end) {
                count++;
                System.out.println(key + "\t" + value);
            }
        }
        System.out.println("number of unique codons  is"+count);
    }

    public void buildCodonMap(int start, String dna) {
        map.clear();
        dna = dna.toUpperCase();
        String currDna = "";
        int stopIndex = 0;
        while (stopIndex <= dna.length() - 3) {
            stopIndex = start + 3;
            currDna = dna.substring(start, stopIndex);
            if (map.keySet().contains(currDna)) {
                map.put(currDna, map.get(currDna) + 1);
            } else {
                map.put(currDna, 1);

            }

            start += 3;
        }

    }


    public void tester() {
        FileResource fr = new FileResource();
        String dna = fr.asString().trim();
        int start =1;
        int end = 100;
        buildCodonMap(0, dna);
        String largest = getMostCommonCodeon();
        System.out.println("Most common codon is "+largest+" with count "+map.get(largest)+"\t");
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);


        buildCodonMap(1, dna);
        largest = getMostCommonCodeon();
        System.out.println("\nMost common codon is "+largest+" with count "+map.get(largest)+"\t");
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);

        buildCodonMap(2, dna);
        largest = getMostCommonCodeon();
        System.out.println("\nMost common codon is "+largest+" with count "+map.get(largest)+"\t");
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);
    }
}







