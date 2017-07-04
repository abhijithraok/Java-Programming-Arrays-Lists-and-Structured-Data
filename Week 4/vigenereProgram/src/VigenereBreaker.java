/**
 * Created by Abhijith on 7/3/2017.
 */

import edu.duke.FileResource;

import java.util.*;

public class VigenereBreaker {

    public static void main(String[] args) {
        VigenereBreaker cc = new VigenereBreaker();
        //  cc.breakVigenere();
        cc.breakVigenere2();

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
        int[] key1 = tryKeyLength(encrypted, index + 1, 'e');
        VigenereCipher vc = new VigenereCipher(key1);
        return vc.decrypt(encrypted);
    }

    public void breakVigenere2() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        FileResource fr2 = new FileResource("dictionaries/English");
        HashSet<String> dictionary = readDictionary(fr2);
        String decrypt = breakForLanguage(message, dictionary);
        System.out.println(decrypt);
    }


}


