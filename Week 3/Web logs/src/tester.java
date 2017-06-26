/**
 * Created by abhijith on 6/26/2017.
 */
import java.util.*;

public class tester
{
    public void testLogEntry() {
        logEntry le = new logEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        logEntry le2 = new logEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }

    public void testLogAnalyzer() {
        logAnalyzer cc = new logAnalyzer();
        cc.readFile("http://www.dukelearntoprogram.com/java/short-test_log");
        cc.printAll();
    }
    public static void main(String [] args ){
        tester cc = new tester();
        cc.testLogEntry();
        cc.testLogAnalyzer();
    }
}
