/**
 * Created by Abhijith on 7/3/2017.
 */
import edu.duke.FileResource;

import java.util.* ;
public class VigenereBreaker {

    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder sb = new StringBuilder();
        for(int i = whichSlice;i< message.length();i+=totalSlices){
            sb.append(message.charAt(i));

        }
        return sb.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker(mostCommon);
        for (int i = 0; i < klength ; i++) {
            String s = sliceString(encrypted, i, klength);
            int dkey = cc.getKey(s);
            key[i] = dkey;
        }
        return key;
    }

    public void breakVigenere () {
        FileResource fr = new FileResource();
        String message = fr.asString();
        int [] key =tryKeyLength(message,5,'e');
        VigenereCipher vc = new VigenereCipher(key);
        String decrypt = vc.decrypt(message);
        System.out.println(decrypt);
    }

    public static void main(String [] args){
        VigenereBreaker cc = new VigenereBreaker();
        cc.breakVigenere();

        }




    }


