/*
 	Daniela Cruz Falquez
	Programming Assignment 4- Problem 1
	10/26/2019
*/
package cruzfalquez_p1;

public class Application {

    public static void main(String[] args) {
        DuplicateRemover duplicateRemover = new DuplicateRemover();

        duplicateRemover.remove("problem1.txt");
        duplicateRemover.write("unique_words.txt");

    }
}