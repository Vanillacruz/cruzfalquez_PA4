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

        FileInputStream fileByteStream = new FileInputStream("problem1.txt");
        FileOutputStream fileByteStream2 = new FileOutputStream("unique_words.txt");

        duplicateRemover.remove(fileByteStream);
        duplicateRemover.write(fileByteStream2);

        fileByteStream.close();
        fileByteStream2.close();
    }
}
