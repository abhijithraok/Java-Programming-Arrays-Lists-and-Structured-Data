/**
 * Created by abhijith on 6/26/2017.
 */

import java.util.*;

public class tester {
    public static void main(String[] args) {
        tester cc = new tester();
        cc.testLogEntry();
         cc.testLogAnalyzer();
       cc.testUniqueIPs();
       cc.testPrintAllHigherThanNum();
      cc.testUniqueIPVisitOnDay();
       cc.testCountUniqueIpInRange();
    cc.testCountsVisitPerIP();
    cc.testMostNumberVisitsByIP();
      cc.testIPsMostVisits();
     cc.testIPsForDays();
      cc.testDayWIthMostIpVisits();
    cc.testIPsWithMostVisitsOnDay();
    }

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

    public void testUniqueIPs() {
        logAnalyzer cc = new logAnalyzer();
        cc.readFile("weblog2_log");
        int uniqueIPs = cc.countUniqueIPs();
        System.out.println("There are " + uniqueIPs + " " + "IPs");
    }

    public void testPrintAllHigherThanNum() {
        logAnalyzer cc = new logAnalyzer();
        cc.readFile("weblog2_log");
        cc.printAllHigherThanNum(400);

    }

    public void testUniqueIPVisitOnDay() {
        logAnalyzer cc = new logAnalyzer();
        cc.readFile("weblog2_log");
        int sizeArray = cc.uniqueIPVisitsOnDay("Sep 27").size();
        System.out.println(cc.uniqueIPVisitsOnDay("Sep 27") + "\n " + "size is:" + sizeArray);
    }

    public void testCountUniqueIpInRange() {
        logAnalyzer cc = new logAnalyzer();
        cc.readFile("weblog2_log");
        cc.countUniqueIPsInRange(400, 499);
    }
    public void testCountsVisitPerIP(){
        logAnalyzer cc = new logAnalyzer();
        cc.readFile("weblog1_log");
        HashMap<String,Integer> counts = cc.countVisitsPerIP();
        System.out.println(counts);
    }
    public void testMostNumberVisitsByIP(){
        logAnalyzer cc = new logAnalyzer();
        cc.readFile("weblog2_log");
        HashMap<String,Integer> counts = cc.countVisitsPerIP();
        int max = cc.mostNumberVisitsByIP(counts);
        System.out.println(max);
    }
    public void testIPsMostVisits(){
        logAnalyzer cc = new logAnalyzer();
        cc.readFile("weblog2_log");
        HashMap<String,Integer> counts = cc.countVisitsPerIP();
        System.out.println(cc.iPsMostVisits(counts));
    }
    public void testIPsForDays(){
        logAnalyzer cc = new logAnalyzer();
        cc.readFile("weblog2_log");
        System.out.println(cc.iPsForDays());
    }
    public void testDayWIthMostIpVisits(){
        logAnalyzer cc = new logAnalyzer();
        cc.readFile("weblog2_log");
       String day = cc.dayWithMostIPVisits(cc.iPsForDays());
       System.out.println(day);
    }
    public void testIPsWithMostVisitsOnDay(){
        logAnalyzer cc = new logAnalyzer();
        cc.readFile("weblog2_log");
        HashMap<String, ArrayList<String>> map = cc.iPsForDays();
       // ArrayList<String> IP = cc.iPsWithMostVisitsOnDay(map,"Mar 17");
        //System.out.println(IP);
        System.out.println(cc.iPsWithMostVisitsOnDay(map,"Sep 30"));

    }
}
