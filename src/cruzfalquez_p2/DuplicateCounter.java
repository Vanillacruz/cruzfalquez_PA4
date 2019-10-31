/*
 	Daniela Cruz Falquez
	Programming Assignment 4- Problem 2
	10/26/2019
*/
package cruzfalquez_p2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//uses a Map of Strings to count how many times each word occurs in dataFile.
public class DuplicateCounter {
    //The counts should be stored in an instance variable called wordCounter.
    int wordCounter;
    Scanner inFS;
    PrintWriter outFS;
    ArrayList<String> uniqueWords = new ArrayList<String>();
    Map<String, Integer> map = new HashMap<String, Integer>();

    public void count(String dataFile) throws IOException {
        String line = "";

        try {
            FileInputStream fileByteStream = new FileInputStream(dataFile);
            inFS = new Scanner(fileByteStream);

            try{
                while (line != null) {
                    line = inFS.next();
                    if (!uniqueWords.contains(line)) {
                        uniqueWords.add(line);
                        map.put(line, wordCounter);
                    }
                }
            } catch (Exception e) {
                //Reached the end of the file
            }

            fileByteStream.close();

        }catch(IOException closeExcpt){
            System.out.println("Error closing file: " + closeExcpt.getMessage());
            System.exit(0);
        }
    }

    //writes the contents of wordCounter to the file pointed to by outputFile.
    public void write(String outputFile) throws IOException {
        try{
            FileOutputStream fileByteStream2 = new FileOutputStream(outputFile);
            outFS = new PrintWriter(outputFile);
            outFS.println(wordCounter);
            outFS.flush();
            outFS.close();

            map.clear();
            fileByteStream2.close();

        }catch(IOException closeExcpt){
            System.out.println("Error closing file: " + closeExcpt.getMessage());
            System.exit(0);
        }
    }
}
