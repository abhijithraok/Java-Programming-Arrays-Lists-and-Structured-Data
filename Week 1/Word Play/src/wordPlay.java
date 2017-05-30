/**
 * Created by abhijith on 30-May-17.
 */
public class wordPlay {
    public boolean isVowel(Character ch) {
        boolean a = false;

        String vowel = "aeiou";
        for (int i = 0; i < vowel.length(); i++) {
            char currValue = vowel.charAt(i);
            if (ch.equals(currValue)) {
                return true;
            }
        }

        return false;
    }

    public void testWordplay() {
        Boolean ch = isVowel('a');
        System.out.println(ch);
    }

    public static void main(String[] args) {
        wordPlay a = new wordPlay();
        a.testWordplay();
    }
}

