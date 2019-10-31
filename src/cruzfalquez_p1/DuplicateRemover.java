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
    Scanner inFS;
    PrintWriter outFS; // Output stream
    ArrayList<String> uniqueWords = new ArrayList<String>();

    public void remove(String dataFile) throws IOException {
        String line = "";

        try {
            FileInputStream fileByteStream = new FileInputStream(dataFile);
            inFS = new Scanner(fileByteStream);

            try{
                while (line != null) {
                    line = inFS.next();
                    if (!uniqueWords.contains(line)) {
                        uniqueWords.add(line);
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

    public void write(String outputFile) throws IOException {
        try{
            FileOutputStream fileByteStream2 = new FileOutputStream(outputFile);
            outFS = new PrintWriter(outputFile);
            for (int i = 0; i < uniqueWords.size(); i++) {
                outFS.println(uniqueWords.get(i));
                outFS.flush();
            }
            outFS.close();
            uniqueWords.clear();
            fileByteStream2.close();

        }catch(IOException closeExcpt){
            System.out.println("Error closing file: " + closeExcpt.getMessage());
            System.exit(0);
        }
    }
}
