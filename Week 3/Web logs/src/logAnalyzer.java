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
        FileResource fileName = new FileResource(filename);
        for (String line : fileName.lines()) {
            // webLogParser.parseEntry(line);
            records.add(webLogParser.parseEntry(line));
        }
    }

    public void printAll() {
        for (logEntry le : records) {
            System.out.println(le);
        }
    }

    public void printAllHigherThanNum(int num) { //prints status code greater than num
        for (logEntry le : records) {
            int currIP = le.getStatusCode();
            if (currIP > num) {
                System.out.println(currIP);
            }
        }
    }

    public int countUniqueIPs() { //prints unique ip's
        ArrayList<String> uniqueIPs = new ArrayList<>(); //uses arraylist to store unique ip
        for (logEntry le : records) {
            String ipAddress = le.getIpAddress();
            if (!uniqueIPs.contains(ipAddress)) {
                uniqueIPs.add(ipAddress);
            }
        }
        return uniqueIPs.size();
    }

    //returns an ArrayList of Strings of unique IP addresses that had access on the given day
    public ArrayList<String> uniqueIPVisitsOnDay(String someday) {
        ArrayList<String> uniqueIPsOnDay = new ArrayList<>();
        for (logEntry le : records) {
            String ipAddress = le.getIpAddress();
            String date = le.getAccessTime().toString();
            if (someday.equals(date.substring(4, 10)) && !uniqueIPsOnDay.contains(ipAddress)) {
                uniqueIPsOnDay.add(ipAddress);
            }
        }
        return uniqueIPsOnDay;
    }

    //countUniqueIPsInRange that has two integer parameters named low and high. This method returns the number of unique IP addresses in records that have a status code in the range from low to high, inclusive
    public void countUniqueIPsInRange(int low, int high) {
        ArrayList<String> uniqueIP = new ArrayList<>();
        int count = 0;
        for (logEntry le : records) {
            String ipAddress = le.getIpAddress();
            int statusCode = le.getStatusCode();
            if (statusCode >= low && statusCode <= high && !uniqueIP.contains(ipAddress)) {
                uniqueIP.add(ipAddress);
            }
        }
        System.out.println(uniqueIP.size());
    }

    //This method returns a HashMap<String, Integer> that maps an IP address to the number of times that IP address appears in records
    public HashMap<String, Integer> countVisitsPerIP() {
        HashMap<String, Integer> counts = new HashMap<String, Integer>();
        for (logEntry le : records) {
            String IPAddress = le.getIpAddress();
            if (!counts.containsKey(IPAddress)) {
                counts.put(IPAddress, 1);
            } else {
                counts.put(IPAddress, counts.get(IPAddress) + 1);
            }
        }
        return counts;
    }

    //This method returns the maximum number of visits to this website by a single IP address
    public int mostNumberVisitsByIP(HashMap<String, Integer> IP) {
    /*    int max = 0;
        for (String key : IP.keySet()) {
            int currValue = IP.get(key);
            if (currValue > max) {
                max = currValue;
            }
        }
        return max;
    }*/

        return Collections.max(IP.values());
    }
}