/**
 * Created by Abhijith on 6/23/2017.
 * Assignment 2: Words in Files
 * Write a program to determine which words occur in the greatest number of files, and for each word, which files they occur in
 */

import edu.duke.*;

import java.util.*;
import java.io.*;

public class wordsInFiles {
    private HashMap<String, ArrayList<String>> map;
    private ArrayList<String> word;

    public wordsInFiles() {
        map = new HashMap<>();
        word = new ArrayList<>();
    }

    public static void main(String[] args) {
        wordsInFiles cc = new wordsInFiles();
        cc.test();
    }

    private void addWordsFromFile(File f) {
        FileResource fr = new FileResource(f);
        String name = f.getName();
        for (String word : fr.words()) {
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<String>());
                map.get(word).add(name);
            } else if (map.containsKey(word)) {
                if (!map.get(word).contains(name)) {
                    map.get(word).add(name);
                }
            }
        }
    }

    public void buildWordFileMap() {
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            addWordsFromFile(f);

        }
    }

    public int maxNumber() {
        int current = 0;
        int max = 0;
        for (String word : map.keySet()) {
            current = map.get(word).size();
            if (max < current) {
                max = current;
            }
        }
        return max;
    }

    private ArrayList<String> wordsInNumFiles(int number) {
        int current = 0;
        ArrayList<String> list = new ArrayList<String>();
        for (String word : map.keySet()) {
            current = map.get(word).size();
            if (current == number) list.add(word);
        }
        return list;
    }

    private void printFilesIn(String word) {
        System.out.println("The files contain " + word + " are: \t");
        ArrayList<String> list = new ArrayList<String>();
        for (String current : map.keySet()) {
            if (current == word) list = map.get(current);
        }
        for (int k = 0; k < list.size(); k++) {
            System.out.println(list.get(k) + "\t");
        }
    }

    public void test() {
        buildWordFileMap();
        int max = maxNumber();
        ArrayList<String> list = wordsInNumFiles(max);
        System.out.println("The greatest number of files a word appears in is " + max + ", and there are " + list.size() + " such words: ");
        for (int k = 0; k < list.size(); k++) {
            System.out.println(list.get(k) + " ");
        }
        System.out.println("\t");
        for (int k = 0; k < list.size(); k++) {
            printFilesIn(list.get(k));
        }


    }
}



