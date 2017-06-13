/**
 * Created by abhijith on 02-Jun-17.
 */

import edu.duke.*;

import java.io.*;
import java.util.*;

public class wordLengths {
    public static void main(String[] args) throws Exception {
    FileResource resource = new FileResource();
    int [] counts = new int[31];
    countWordLengths(resource,counts);
    System.out.println(counts);

    }

    public  static void countWordLengths(FileResource resource, int[] counts) {

    }
}

