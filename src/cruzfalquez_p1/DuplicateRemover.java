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
    ArrayList<String> uniqueWords = new ArrayList <String>();

     public void remove (FileInputStream dataFile){
        String line = "";
        inFS = new Scanner(dataFile);

        try{
            while(line != null){
                line = inFS.next();
                if(!uniqueWords.contains(line)){
                    uniqueWords.add(line);
                }
            }
        }catch(Exception e){
            //System.out.println("EXCEPTION");
        }

    }

    public void write (FileOutputStream outputFile) {
        outFS = new PrintWriter(outputFile);

        for(int i = 0; i< uniqueWords.size(); i++){
            outFS.println(uniqueWords.get(i));
            outFS.flush();
        }
        outFS.close();
    }

}
