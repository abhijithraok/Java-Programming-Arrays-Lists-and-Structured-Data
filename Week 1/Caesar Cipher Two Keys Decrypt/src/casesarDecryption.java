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
    public static int maxIndex(int[] count){
        int max = 0;
        for(int i = 0; i < count.length;i++){
            if(count[i] >= max){
                max = count[i];
            }

        }
        return max;
    }
    
    public static String decrypt(String encrypted){
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex-4;
        if(maxDex < 4){
            dkey = 26-(4-maxDex);
        }
        return encrypt(encrypted,26-dkey);
    }
}
