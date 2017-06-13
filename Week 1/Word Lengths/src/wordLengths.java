/**
 * Created by abhijith on 02-Jun-17.
 */

import edu.duke.*;

import java.io.*;
import java.util.*;

public class wordLengths {
    public static HashMap hm = new HashMap();
    public static void main(String[] args) throws Exception {
        FileResource resource = new FileResource();
        ArrayList<Integer> array = new ArrayList<Integer>();

      //  int[] counts = new int[31];
        countWordLengths(resource, array);
        System.out.println(hm);
       int max = indexOfMax(array);
    System.out.print(max);
    }

    public static void countWordLengths(FileResource resource, ArrayList<Integer> array) {
        for (String word : resource.words()) {
            int wordLength = 0;
            StringBuilder sb = new StringBuilder(word);
            //  System.out.println(sb);
            for (int i = 0; i < sb.length(); i++) {
                if (!Character.isLetter(sb.charAt(i))) {
                    sb.deleteCharAt(i);
                }
                //   else if(i ==sb.length()-1 && !Character.isLetter(sb.charAt(i))){
                //    sb.deleteCharAt(i);
                // }
                else {
                    wordLength++;
                }

            }
            String result = sb.toString();
            hm.put(result,wordLength);
            array.add(wordLength++);
           // System.out.println(result);


        }

    }

    public static  int indexOfMax(ArrayList<Integer> values) {
        int max = 0;
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) >= max) {
                max = values.get(i);

            }

        }
        return max;
    }
}


