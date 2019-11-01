/*
 	Daniela Cruz Falquez
	Programming Assignment 4- Problem 1
	10/26/2019
*/
package cruzfalquez_p1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

public class DuplicateRemover {
    ArrayList<String> uniqueWords = new ArrayList<String>();

    public void remove(String dataFile) {
        String line = "";

        try {
            FileInputStream fileByteStream = new FileInputStream(dataFile);
            Scanner inFS = new Scanner(fileByteStream);

            //reads words into an arrayList without duplicates
            while (inFS.hasNext()) {
                line = inFS.next();
                if (!uniqueWords.contains(line)) {
                    uniqueWords.add(line);
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

            //prints words to output file
            for (int i = 0; i < uniqueWords.size(); i++) {
                outFS.println(uniqueWords.get(i));
                outFS.flush();
            }

            //cleans up resources allocated
            outFS.close();
            uniqueWords.clear();
            fileByteStream2.close();

        } catch (IOException closeExcpt) {
            System.out.println("Error closing file: " + closeExcpt.getMessage());
            System.exit(0);
        }
    }
}
