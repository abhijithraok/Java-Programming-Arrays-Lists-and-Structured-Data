/**
 * Created by Abhijith on 6/16/2017.
 */
public class ooCaesarCipherTwoKey {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int masterKey1;
    private int masterKey2;
public ooCaesarCipherTwoKey(int key1, int key2){
     alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
     shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);

}
}
