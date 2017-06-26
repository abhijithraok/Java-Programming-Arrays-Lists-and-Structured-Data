/**
 * Created by abhijith on 6/26/2017.
 */
import edu.duke.*;
import java.util.*;
public class logAnalyzer {
    private ArrayList<logEntry> records;

    public logAnalyzer() {
        records = new ArrayList<logEntry>();
    }

    public void readFile(String filename) {
        FileResource fileName = new FileResource();
        for(String line :fileName.lines()){
          // webLogParser.parseEntry(line);
           records.add(webLogParser.parseEntry(line));
        }
    }

    public void printAll() {
        for (logEntry le : records) {
            System.out.println(le);
        }
    }
}
