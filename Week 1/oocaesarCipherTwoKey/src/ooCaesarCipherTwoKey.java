/**
 * Created by Abhijith on 6/16/2017.
 */
public class ooCaesarCipherTwoKey {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int masterKey1;
    private int masterKey2;

    public ooCaesarCipherTwoKey(int key1, int key2) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        masterKey1 = key1;
        masterKey2 = key2;

    }

    public static void main(String[] args) {
        ooCaesarCipherTwoKey cc = new ooCaesarCipherTwoKey(21, 2);
        String encrypt = cc.encryptTwoKeys("The original name of Java was Oak.");
        System.out.println(encrypt);
        System.out.println(cc.decrypt(encrypt));
    }

    public String encryptTwoKeys(String input) {
        int i = 0;
        StringBuilder encrypt = new StringBuilder(input);
        //Compute the shifted alphabet
        for (i = 0; i < encrypt.length(); i += 2) {
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

    public String decrypt(String input) {
        ooCaesarCipherTwoKey cc = new ooCaesarCipherTwoKey(26 - masterKey1, 26 - masterKey2);
        return cc.encryptTwoKeys(input);
    }
}
