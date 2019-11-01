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
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {

    Map<String, Integer> wordCounter = new HashMap<String, Integer>();

    //Counts the number of times each word occurs in the input file
    public void count(String dataFile) {
        String word = "";

        try {
            FileInputStream fileByteStream = new FileInputStream(dataFile);
            Scanner inFS = new Scanner(fileByteStream);

            //loops until end of file is reached
            while (inFS.hasNext()) {
                word = inFS.next();

                //updates number of times word is found
                if (wordCounter.get(word) == null) {
                    wordCounter.put(word, 1);
                } else {
                    wordCounter.put(word, wordCounter.get(word) + 1);
                }
            }

            fileByteStream.close();

        } catch (IOException closeExcpt) {
            System.out.println("Error closing file: " + closeExcpt.getMessage());
            System.exit(0);
        }
    }

    public void write(String outputFile) {
        try {
            FileOutputStream fileByteStream2 = new FileOutputStream(outputFile);
            PrintWriter outFS = new PrintWriter(outputFile);

            //Writes data to the file
            for (String key : wordCounter.keySet()) {
                outFS.println(wordCounter.get(key) + " \t" + key);
                outFS.flush();
            }

            //cleans up resources
            outFS.close();
            wordCounter.clear();
            fileByteStream2.close();

        } catch (IOException closeExcpt) {
            System.out.println("Error closing file: " + closeExcpt.getMessage());
            System.exit(0);
        }
    }
}
