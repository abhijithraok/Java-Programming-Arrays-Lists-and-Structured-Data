/**
 * Created by Abhijith on 6/18/2017.
 */

import java.util.*;

import edu.duke.*;

public class charactersInPlay {
    private ArrayList<String> myWord;
    private ArrayList<Integer> myFreqs;

    public charactersInPlay() {
        myFreqs = new ArrayList<>();
        myWord = new ArrayList<>();
    }

    public static void main(String[] args) {
        charactersInPlay cc = new charactersInPlay();
        cc.tester();
    }

    public void update(String name) {
        String subString = "";
        int endLine = name.indexOf(".");//this finds the first occurrence of "."
        // if (endLine != -1) {
        subString = name.substring(0, endLine);
        // }
        subString =subString.trim();
        int index = myWord.indexOf(subString);//finding index of substring in myword list . if its not found add to list
        if (index == -1) {
            myWord.add(subString);
            myFreqs.add(1);//incrementing freqency by 1
        } else {
            int value = myFreqs.get(index);//if string is not unique find value of that word in myFreq list
            myFreqs.set(index, value + 1);//incrementing by 1
        }

    }

    public void findAllCharacters() {
        myWord.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        //reads line by line
        for (String line : fr.lines()) {
            //call update only if line contains .
            if (line.contains(".")) {
                update(line);
            }
        }
    }

    public int findMax() {
        int max = 0;
        int maxIndex = myFreqs.get(0);
        for (int i = 0; i < myFreqs.size(); i++) {
            if (myFreqs.get(i) > maxIndex) {
                maxIndex = myFreqs.get(i);
                max = i;
            }
        }
        return max;
    }

    public void charactersWithNumParts(int num1, int num2) {
        //prints list which has freqs greater than num1 and less than num2
        // int max = 0;
        for (int i = 0; i < myFreqs.size(); i++) {
            if (myFreqs.get(i) >= num1 && myFreqs.get(i) <= num2) {
                //  max = i;
                System.out.println("Count greater than  :" +num1+" " +"and less than"+ num2 +" "+ myWord.get(i) + "\t" + myFreqs.get(i));
            }
        }

    }

    public void tester() {
        findAllCharacters();
        charactersWithNumParts(10, 103);
        int index = findMax();
        System.out.println("Character with the most speaking parts " + myWord.get(index) + " " + myFreqs.get(index));
        for (int i = 0; i < myWord.size(); i++) {
            System.out.println(myWord.get(i) + "\t" + myFreqs.get(i));

        }
    }
}

