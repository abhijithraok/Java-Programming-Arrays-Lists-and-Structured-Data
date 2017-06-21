/**
 * Created by Abhijith on 6/20/2017.
 */

import edu.duke.*;

import java.util.*;

public class gladLib {
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    private ArrayList<String> adjectiveList;
    private ArrayList<String> nounList;
    private ArrayList<String> colorList;
    private ArrayList<String> countryList;
    private ArrayList<String> nameList;
    private ArrayList<String> animalList;
    private ArrayList<String> timeList;
    private ArrayList<String> verbList;
    private ArrayList<String> fruitList;
    private ArrayList<String> usedList;
    private Random myRandom;

    public gladLib() {
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }

    public gladLib(String source) {
        initializeFromSource(source);
        myRandom = new Random();
    }

    public static void main(String[] args) {
        gladLib cc = new gladLib();
        cc.makeStory();

    }

    private void initializeFromSource(String source) {
        adjectiveList = readIt(source + "/adjective.txt");
        nounList = readIt(source + "/noun.txt");
        colorList = readIt(source + "/color.txt");
        countryList = readIt(source + "/country.txt");
        nameList = readIt(source + "/name.txt");
        animalList = readIt(source + "/animal.txt");
        timeList = readIt(source + "/timeframe.txt");
        fruitList = readIt(source+"/fruit.txt");
        verbList = readIt(source+"/verb.txt");
        usedList = new ArrayList<>();
    }

    private String randomFrom(ArrayList<String> source) {
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }

    private String getSubstitute(String label) {
        if (label.equals("country")) {
            return randomFrom(countryList);
        }
        if (label.equals("color")) {
            return randomFrom(colorList);
        }
        if (label.equals("noun")) {
            return randomFrom(nounList);
        }
        if (label.equals("name")) {
            return randomFrom(nameList);
        }
        if (label.equals("adjective")) {
            return randomFrom(adjectiveList);
        }
        if (label.equals("animal")) {
            return randomFrom(animalList);
        }
        if (label.equals("timeframe")) {
            return randomFrom(timeList);
        }
        if (label.equals("number")) {
            return "" + myRandom.nextInt(50) + 5;
        }
        if (label.equals("fruit")) {
            return randomFrom(fruitList);
        }
        if (label.equals("verb")) {
            return randomFrom(verbList);
        }
        return "**UNKNOWN**";
    }

    private String processWord(String w) {
        int first = w.indexOf("<");
        int last = w.indexOf(">", first);
        if (first == -1 || last == -1) {
            return w;
        }
        String sub = getSubstitute(w.substring(first + 1, last));
        while (true){
           if(!usedList.contains(sub)){
            usedList.add(sub);
           // System.out.println(usedList);
            break;
        }
            sub = getSubstitute(w.substring(first + 1, last));

        }
        return sub;
    }

    private void printOut(String s, int lineWidth) {
        int charsWritten = 0;
        for (String w : s.split("\\s+")) {
            if (charsWritten + w.length() > lineWidth) {
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w + " ");
            charsWritten += w.length() + 1;
        }
    }

    private String fromTemplate(String source) {
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for (String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        } else {
            FileResource resource = new FileResource(source);
            for (String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }

    private ArrayList<String> readIt(String source) {
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for (String line : resource.lines()) {
                list.add(line);
            }
        } else {
            FileResource resource = new FileResource(source);
            for (String line : resource.lines()) {
                list.add(line);
            }
        }
        return list;
    }

    public void makeStory() {
        usedList.clear();
     //   System.out.println("\n");
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("\nreplaced word  "+usedList.size());
    }


}
