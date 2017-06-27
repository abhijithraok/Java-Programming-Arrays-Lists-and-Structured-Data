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
        cc.readFile("short-test_log");
        cc.printAll();
    }
    public void testUniqueIPs(){
        logAnalyzer cc = new logAnalyzer();
        cc.readFile("short-test_log");
        int uniqueIPs = cc.countUniqueIPs();
        System.out.println("There are "+ uniqueIPs +" " +"IPs");
    }
    public  void testPrintAllHigherThanNum(){
        logAnalyzer cc = new logAnalyzer();
        cc.readFile("short-test_log");
        cc.printAllHigherThanNum(200);

    }
    public void testUniqueIPVisitOnDay(){
        logAnalyzer cc = new logAnalyzer();
        cc.readFile("short-test_log");
       System.out.println(cc.uniqueIPVisitsOnDay("Sep 30"));
    }
public void testCountUniqueIpInRange(){
    logAnalyzer cc = new logAnalyzer();
    cc.readFile("short-test_log");
   cc.countUniqueIPsInRange(300,399);
}
    public static void main(String [] args ){
        tester cc = new tester();
       cc.testLogEntry();
       cc.testLogAnalyzer();
        cc.testUniqueIPs();
        cc.testPrintAllHigherThanNum();
        cc.testUniqueIPVisitOnDay();
        cc.testCountUniqueIpInRange();
    }
}
