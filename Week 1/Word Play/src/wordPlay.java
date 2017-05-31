import javax.print.DocFlavor;

/**
 * Created by abhijith on 30-May-17.
 */
public class wordPlay {
    public boolean isVowel(char ch) {
        boolean a = false;
        String vowel = "aeiouAEIOU";
        for (int i = 0; i < vowel.length(); i++) {
            char currValue = vowel.charAt(i);
            if (currValue == ch) {
                a = true;
            }
        }

        return a;
    }

    public String replaceVowels(String phrase, char ch) {
        StringBuilder replace = new StringBuilder(phrase);
        for (int i = 0; i < phrase.length(); i++) {
            char currChar = replace.charAt(i);
            if (isVowel(currChar)) {
                replace.setCharAt(i, ch);
            }

        }
        return replace.toString();
    }

    public String emphasize(String phrase, char ch) {
        StringBuilder replace = new StringBuilder(phrase);
        for (int i = 0; i < replace.length(); i++) {
            char currChar = replace.charAt(i);
            if ((i % 2 == 0) && (currChar == Character.toLowerCase(ch) || currChar == Character.toUpperCase(ch))) {
                replace.setCharAt(i, '*');
            } else {
                if (currChar == Character.toLowerCase(ch) || currChar == Character.toUpperCase(ch)) {
                    replace.setCharAt(i, '+');
                }
            }

        }
        return replace.toString();

    }


    public void testWordplay() {
        Boolean ch = isVowel('a');
        System.out.println(ch);
    }

    public void testreplaceVowels() {
        String a = replaceVowels("Hello World", '*');
        System.out.println(a);

    }

    public void testEmphasize() {
        String a = emphasize("Mary Bella Abracadabra", 'a');
        System.out.println(a);
    }

    public static void main(String[] args) {
        wordPlay a = new wordPlay();
         a.testWordplay();
         a.testreplaceVowels();
        a.testEmphasize();
    }

}

