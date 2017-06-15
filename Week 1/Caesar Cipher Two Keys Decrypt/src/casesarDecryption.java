/**
 * Created by abhijith on 6/15/2017.
 */
import edu.duke.*;
public class casesarDecryption {
    public static void main(String[] args) {
      String message1 = "Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu";
       System.out.println("Encrypted message is :" + message1);
        String b = decrypt(message1);
        System.out.println("Decrypted message is :"+ b);
        decryptTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko");

        FileResource fr = new FileResource();
        String message = fr.asString();
        String s1 = halfOfString(message, 0);
        String s2 = halfOfString(message, 1);
        System.out.println(s1);
        System.out.println(s2);
        int key1 = getKey(s1);
        int key2 = getKey(s2);
        System.out.println("Two keys found: key1= " + key1 + ", key2= " + key2);
        CaesarCipher cc = new CaesarCipher();
        System.out.println(cc.encryptTwoKeys(message, 26-key1, 26-key2));


    }

    public static int[] countLetters(String message) {
        int[] count = new int[26];
        String alph = "abcdefghijklmnopqrstuvwxyz";
        for (int k = 0; k < message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1) {
                count[dex] += 1;
            }
        }
        return count;
    }

    public static int maxIndex(int[] count) {
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= count[max]) {
                max = i;
            }

        }
        return max;
    }

    public static String decrypt(String encrypted) {

        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = 4 - maxDex;

        if(maxDex > 4) {

            dkey = 26 - (maxDex - 4);

        }



        System.out.println("Key is " + dkey);

        return cc.encrypt(encrypted, 26-dkey);

    }

    public static String halfOfString(String message, int start) {
        String answer = "";
        for (int i = start; i < message.length(); i += 2) {
            answer = answer + message.charAt(i);
        }
        return answer;
    }

    public static int getKey(String s) {
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        return dkey;
    }

    public  static void decryptTwoKeys(String encrypted){
        String s1 = halfOfString(encrypted, 0);
        String s2 = halfOfString(encrypted, 1);
        System.out.println(s1);
        System.out.println(s2);
        int key1 = getKey(s1);
       int key2 = getKey(s2);
        System.out.println("Two keys found: key1= " + key1 + ", key2= " + key2);
      CaesarCipher cc = new CaesarCipher();
        System.out.println(cc.encryptTwoKeys(encrypted, 26-key1, 26-key2));
    }
}
