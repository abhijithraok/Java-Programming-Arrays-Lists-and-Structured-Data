import java.util.Scanner;

/**
 * Created by Abhijith on 6/16/2017.
 */
public class oocaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int masterkey;

    public oocaesarCipher(int key) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        masterkey = key;
    }

    public static void main(String[] args) {
        oocaesarCipher cc = new oocaesarCipher(15);
        String encrypt = cc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
        System.out.println(encrypt);
        System.out.println(cc.decrypt(encrypt));

    }


    public String encrypt(String input) {
        StringBuilder encrypt = new StringBuilder(input);
        //Compute the shifted alphabet
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

    public String decrypt(String input) {
        oocaesarCipher cc = new oocaesarCipher(26 - masterkey);
        return cc.encrypt(input);
    }
}