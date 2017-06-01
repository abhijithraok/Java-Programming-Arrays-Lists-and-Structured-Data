/**
 * Created by abhijith on 31-May-17.
 */

import edu.duke.*;

public class caesarCipher {
    public static void main(String[] args) {
        caesarCipher a = new caesarCipher();
        a.testCaesarCipher();
        a.testEncryptTwoKeys();
    }

    /**
     * This method returns a String that has been encrypted using the Caesar Cipher algorithm
     */
    public String encrypt(String input, int key) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder encrypt = new StringBuilder(input);
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        for (int i = 0; i < input.length(); i++) {
            char currChar = encrypt.charAt(i);
            int ind = alphabet.indexOf(Character.toUpperCase(currChar));
            if (ind != -1) {
                if (currChar == Character.toUpperCase(currChar)) {
                    char shiftChar = shiftedAlphabet.charAt(ind);
                    encrypt.setCharAt(i, shiftChar);
                } else {
                    char shiftCar = shiftedAlphabet.charAt(ind);
                    encrypt.setCharAt(i, Character.toLowerCase(shiftCar));
                }

            }
        }
        return encrypt.toString();
    }

    public String encryptTwoKeys(String input, int key1, int key2) {
        caesarCipher a = new caesarCipher();
        int i = 0;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder encrypt = new StringBuilder(input);
        //Compute the shifted alphabet
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        for (i = 0; i < input.length(); i += 2) {
            char currChar = encrypt.charAt(i);
            int ind = alphabet.indexOf(Character.toUpperCase(currChar));
            if (ind != -1) {
                if (currChar == Character.toUpperCase(currChar)) {
                    char shiftChar = shiftedAlphabet1.charAt(ind);
                    encrypt.setCharAt(i, shiftChar);
                } else {
                    char shiftCar = shiftedAlphabet1.charAt(ind);
                    encrypt.setCharAt(i, Character.toLowerCase(shiftCar));
                }
            }

        }
        for (i = 1; i < input.length(); i += 2) {
            char currChar = encrypt.charAt(i);
            int ind = alphabet.indexOf(Character.toUpperCase(currChar));
            if (ind != -1) {
                if (currChar == Character.toUpperCase(currChar)) {
                    char shiftChar = shiftedAlphabet2.charAt(ind);
                    encrypt.setCharAt(i, shiftChar);
                } else {
                    char shiftCar = shiftedAlphabet2.charAt(ind);
                    encrypt.setCharAt(i, Character.toLowerCase(shiftCar));
                }

            }
        }

        return encrypt.toString();
    }

    public void testCaesarCipher() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, 15);
        System.out.println("key is " + 23 + "\n" + encrypted);
    }

    public void testEncryptTwoKeys() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        String b = encryptTwoKeys(message, 8, 21);
        System.out.println(b);
    }
}

