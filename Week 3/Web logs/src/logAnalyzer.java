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

    //This method returns an ArrayList of Strings of IP addresses that all have the maximum number of visits to this website
    public ArrayList iPsMostVisits(HashMap<String, Integer> ip) {
        ArrayList<String> iPList = new ArrayList<>();
        HashMap<String, Integer> iPMap;
        iPMap = countVisitsPerIP();//maps an IP address to the number of times that IP address appears in records
        int max = mostNumberVisitsByIP(iPMap);//maximum number of visits to webiste by single ip address
        for (String key : iPMap.keySet()) {
            if (iPMap.get(key).equals(max)) {
                iPList.add(key);
            }
        }

        return iPList;
    }

    public HashMap<String, ArrayList<String>> iPsForDays() {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (logEntry le : records) {
            ArrayList<String> IP = new ArrayList<>();
            String ipAddress = le.getIpAddress();
            String date = le.getAccessTime().toString();
            date = date.substring(4, 10);
            if (!map.containsKey(date)) {
                IP.add(ipAddress);
                map.put(date, IP);
            } else {
                // if the key has already been used,
                //  grab the array list and add the value to it
                ArrayList<String> tempIP = map.get(date);
                tempIP.add(ipAddress);
                map.put(date, tempIP);
            }
        }
        return map;

    }

  public String dayWithMostIPVisits(HashMap<String,ArrayList<String>> map){
       String day ="";
         int max =0;
         for(String key : map.keySet()){
             int size = map.get(key).size();
             if(size > max){
                 max = size;
                 day = key;
             }
         }
    return day;
  }
  public ArrayList iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> map, String day){
      ArrayList<String> list = map.get(day);
      HashMap<String, Integer> countIP = new HashMap<String, Integer>();
      int maxCount = 0;
      for (int count : countIP.values())
          if (count > maxCount) maxCount = count;

      // fill output list
      for (String ip : countIP.keySet())
          if (countIP.get(ip) == maxCount) {
              list.add(ip);
          }
      return list;
  }

}