/*
 	Daniela Cruz Falquez
	Programming Assignment 4- Problem 1
	10/26/2019
*/
package cruzfalquez_p1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        DuplicateRemover duplicateRemover = new DuplicateRemover();

        duplicateRemover.remove("problem1.txt");
        duplicateRemover.write("unique_words.txt");

    }
}