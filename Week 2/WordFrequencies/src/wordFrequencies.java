/**
 * Created by abhijith on 6/18/2017.
 */

import java.util.*;
import java.util.Collection;

import edu.duke.*;

public class wordFrequencies {
    private ArrayList<String> myWord;
    private ArrayList<Integer> myFreqs;

    public wordFrequencies() {
        myWord = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }

    public static void main(String[] args) {
        wordFrequencies cc = new wordFrequencies();
        cc.tester();
    }

    public void findUnique() {
        myFreqs.clear();
        myWord.clear();
        FileResource fr = new FileResource();
        for (String s : fr.words()) {
            s = s.toLowerCase();
            int index = myWord.indexOf(s);
            if (index == -1) {
                myWord.add(s);
                myFreqs.add(1);
            } else {
                int value = myFreqs.get(index);
                myFreqs.set(index, value + 1);
            }
        }
    }

    public int findMaxIndex() {
        int max = 0;
        for (int i = 0; i < myFreqs.size(); i++) {
            if (myFreqs.get(i) > max) {
                max = myFreqs.get(i);
            }
        }
        return max;
    }

    public void tester() {
        findUnique();
        System.out.println("#unique works : " + myWord.size());
        for (int i = 0; i < myWord.size(); i++) {
            System.out.println(myFreqs.get(i) + "\t" + myWord.get(i));
        }
        System.out.println("Most occured word is: " + findMaxIndex());
    }


}
