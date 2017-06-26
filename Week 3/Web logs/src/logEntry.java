/**
 * Created by abhijith on 6/26/2017.
 */
import  java.util.*;
public class logEntry
{
    private String ipAddress;
    private Date accessTime;
    private String request;
    private int statusCode;
    private int bytesReturned;

    public logEntry(String ip, Date time, String req, int status, int bytes) {
        ipAddress = ip;
        accessTime = time;
        request = req;
        statusCode = status;
        bytesReturned = bytes;

    }

    public String getIpAddress() {
        return ipAddress;
    }
    public Date getAccessTime() {
        return accessTime;
    }
    public String getRequest() {
        return request;
    }
    public int getStatusCode() {
        return statusCode;
    }
    public int getBytesReturned() {
        return bytesReturned;
    }

    public String toString() {
        return ipAddress + " " + accessTime + " " + request
                + " " + statusCode + " " + bytesReturned;
    }
}
