/**
 * Created by abhijith on 02-Jun-17.
 */

import edu.duke.*;

import java.io.*;
import java.util.*;

public class wordLengths {
    private static HashMap map = new HashMap();

    public static void main(String[] args) throws Exception {
        FileResource resource = new FileResource();
        int[] counts = new int[31];
        countWordLengths(resource, counts);
        System.out.println(indexOfMax(counts));
    }

    public static void countWordLengths(FileResource resource, int[] counts) {
        for (String word : resource.words()) {
            int wordLength = 0;
            StringBuilder sb = new StringBuilder(word);

            for (int i = 0; i < sb.length(); i++) {
                if (!Character.isLetter(sb.charAt(i))) {
                    sb.deleteCharAt(i);
                } else {
                    wordLength++;
                }

            }
            String result = sb.toString();
            map.put(result, wordLength);
            counts[wordLength]++;

        }
        for (int index = 0; index < counts.length; index++) {
            if (counts[index] != 0) {
               System.out.print(counts[index] + " word of length" + index + ": ");
                Set set = map.entrySet();
                Iterator i = set.iterator();
                while (i.hasNext()) {
                    Map.Entry me = (Map.Entry) i.next();
                    if (me.getValue().equals(index))
                       System.out.print(me.getKey() + " ");
                }
                System.out.println();
            }

        }
    }


    public static int indexOfMax(int[] values) {
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] >= max) {
                max = values[i];

            }

        }
        return max;
    }
}


