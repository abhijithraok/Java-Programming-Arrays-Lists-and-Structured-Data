/**
 * Created by abhijith on 6/15/2017.
 */
public class casesarDecryption {
    public static void main(String [] args) {

    }
    public static int [] countLetters(String message){
        int[] count = new int[26];
        String alph = "abcdefghijklmnopqrstuvwxyz";
        for(int k = 0; k < message.length();k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if(dex != -1){
                count[dex] +=1;
            }
        }
        return count;
    }
}
