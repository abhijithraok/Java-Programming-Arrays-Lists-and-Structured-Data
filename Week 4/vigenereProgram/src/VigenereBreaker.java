/**
 * Created by Abhijith on 7/3/2017.
 */

import edu.duke.*;
import java.io.*;
import java.util.*;

public class VigenereBreaker {

    public static void main(String[] args
    ) {
        VigenereBreaker cc = new VigenereBreaker();
       // cc.breakVigenere();
      cc.breakVigenere2();
     // cc.breakVigenere3();
    }

    //This method returns a String consisting of every totalSlices-th character from message, starting at the whichSlice-th character
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder sb = new StringBuilder();
        for (int i = whichSlice; i < message.length(); i += totalSlices) {
            sb.append(message.charAt(i));

        }
        return sb.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker(mostCommon);
        for (int i = 0; i < klength; i++) {
            String s = sliceString(encrypted, i, klength);
            int dkey = cc.getKey(s);
            key[i] = dkey;
        }
        return key;
    }

    public void breakVigenere() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        int[] key = tryKeyLength(message, 4, 'e');
        //  System.out.println(Arrays.toString(key));
        VigenereCipher vc = new VigenereCipher(key);
        String decrypt = vc.decrypt(message);
        System.out.println(decrypt);
    }


    //The method returns the HashSet representing the words in a dictionary
    public HashSet<String> readDictionary(FileResource fr) {
        HashSet<String> hashSet = new HashSet<>();
        for (String line : fr.words()) {
            String words = line.toLowerCase();
            if (!hashSet.contains(words)) {
                hashSet.add(words);
            }
        }
        return hashSet;
    }

    public int countWords(String message, HashSet<String> dictionary) {
        int count = 0;
        String[] wordList = message.split("\\W+");
        for (String word : wordList) {
            String tempWord = word.toLowerCase();
            if (dictionary.contains(tempWord)) {
                count += 1;
            }
        }
        return count;
    }

    public String breakForLanguage(String encrypted, HashSet<String> dictionary) {
        int largest = 0;
        int index = 0;
        for (int i = 0; i < 100; i++) {
            int[] key = tryKeyLength(encrypted, i + 1, 'e');
            VigenereCipher vc = new VigenereCipher(key);
            String result = vc.decrypt(encrypted);
            int tempCount = countWords(result, dictionary);
            if (tempCount > largest) {
                largest = tempCount;
                index = i;
            }
        }
        int realKey = index+1;
        char mostCommonChar = mostCommonCharIn(dictionary).charAt(0);//not working
         System.out.println("Key Length is: "+index+" word count is: "+largest);
        int[] key1 = tryKeyLength(encrypted, realKey, mostCommonChar);
        VigenereCipher vc = new VigenereCipher(key1);
        return vc.decrypt(encrypted);
    }

    public void breakVigenere2() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        FileResource fr2 = new FileResource("dictionaries/German");
        HashSet<String> dictionary = readDictionary(fr2);
        String decrypt = breakForLanguage(message, dictionary);
        System.out.println(decrypt);

    }

    public String mostCommonCharIn(HashSet<String> dictionary) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : dictionary) {
            word.toLowerCase();
            String [] letters = word.split("");
            for (String letter : letters) {
                if (!map.containsKey(letter)) {
                    map.put(letter, 1);
                } else {
                    map.put(letter, map.get(letter) + 1);
                }
            }
        }
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }

        }

        return maxEntry.getKey();
    }

    public HashMap<String, String> breakForAllLanguages(String encrypted, HashMap<String, HashSet<String>> languages){
        HashMap<String, String> decrpytedMessages = new HashMap<String, String>();
        String language = "";
        int wordcount = 0;
        for (String lang: languages.keySet()) {
            System.out.println("Currently breaking into "+lang);
            String decrypted_string = breakForLanguage(encrypted, languages.get(lang));
            int count = countWords(decrypted_string, languages.get(lang));
            if (wordcount < count) {
                wordcount = count;
                language = lang;
            }

            System.out.println();
            decrpytedMessages.put(lang, decrypted_string);
        }
        System.out.println("The language of this message is " + language);
        System.out.println(wordcount + " valid words\n");
        return decrpytedMessages;
    }

    public void breakVigenere3() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        HashMap<String, HashSet<String>> languages = new HashMap<String, HashSet<String>>();
        DirectoryResource dr = new DirectoryResource();
        for (File d: dr.selectedFiles()) {
            FileResource fr2 = new FileResource(d.toString());
            HashSet<String> result = new HashSet<String>();
            for (String line: fr2.lines()) {
                line = line.toLowerCase();
                result.add(line);
            }
            languages.put(d.getName(), result);

        }
        HashMap<String, String> decrypted = breakForAllLanguages(message, languages);

    }

}





