/**
 * Created by Abhijith on 7/2/2017.
 */
import java.util.*;
import edu.duke.*;
public class vigenereCipher {
    caesarCipher[] ciphers;

    public vigenereCipher(int[] key) {
        ciphers = new caesarCipher[key.length];
        for (int i = 0; i < key.length; i++) {
            ciphers[i] = new caesarCipher(key[i]);
        }
    }

    public String encrypt(String input) {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {
            int cipherIndex = i % ciphers.length;
            caesarCipher thisCipher = ciphers[cipherIndex];
            answer.append(thisCipher.encryptLetter(c));
            i++;
        }
        return answer.toString();
    }

    public String decrypt(String input) {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {
            int cipherIndex = i % ciphers.length;
            caesarCipher thisCipher = ciphers[cipherIndex];
            answer.append(thisCipher.decryptLetter(c));
            i++;
        }
        return answer.toString();
    }

    public String toString() {
        return Arrays.toString(ciphers);
    }

}

