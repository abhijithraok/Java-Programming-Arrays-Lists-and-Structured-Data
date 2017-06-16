/**
 * Created by Abhijith on 6/16/2017.
 */
import edu.duke.*;

public class testCaesarCipherTwoKey
{

public static void main(String [] args ) {
        testCaesarCipherTwoKey cc = new testCaesarCipherTwoKey();
        FileResource fr = new FileResource();
        String message = fr.asString();
        ooCaesarCipherTwoKey c = new ooCaesarCipherTwoKey(17,3);
        String encrypted = c.encryptTwoKeys(message);
        System.out.println(encrypted);
        System.out.println(c.decrypt(encrypted));
       cc.breakCaesarCipher("Akag ");
      cc. breakCaesarCipher("Aal ");
    }

    private int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int k = 0; k<message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1) {
                counts[dex] += 1;
            }
        }
        return counts;
    }

    private int maxIndex(int[] values){
        int max=0;
        for(int i=0; i< values.length;i++){
            if(values[i] > values[max]){
                max = i;
            }
        }
        return max;
    }

    private String decrypt(String encrypted, int key){
        CaesarCipher cc = new CaesarCipher();
        String message = cc.encrypt(encrypted, 26-key);
        return message;
    }

    private String halfOfString(String message, int start){
        String answer = "";
        for (int k = start; k< message.length() ; k+= 2) {
            answer = answer + message.charAt(k);
        }
        return answer;
    }

    private int getKey(String s){
        int[] letterFreqs = countLetters(s);
        int maxindex = maxIndex(letterFreqs);
        int dkey = maxindex - 4;
        if (maxindex < 4) {
            dkey = 26 - (4-maxindex);
        }
        return dkey;
    }


    public void breakCaesarCipher(String input){
        String s1 = halfOfString(input, 0);
        String s2 = halfOfString(input, 1);
        int key1 = getKey(s1);
        int key2 = getKey(s2);
        ooCaesarCipherTwoKey c = new ooCaesarCipherTwoKey(key1,key2);
        System.out.println("\nEncrypted message:" + input);
        System.out.println("Two keys found: key1= " + key1 + ", key2= " + key2);
        System.out.println("Decrypted message:" + c.decrypt(input));

    }
}