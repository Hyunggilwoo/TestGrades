/*
 * Add appropriate documentation here
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
/**
 * Add appropriate documentation here
 *
 */
public class GradeDriver{
/**
 * Add appropriate documentation here
 *
 */
	public static void main(String[] theArgs){
      	Scanner input = null;
      	PrintStream output = null;
        try {
          input = new Scanner(new File("in4.txt"));
      		output = new PrintStream(new File("out4.txt"));
        }
        catch (FileNotFoundException e) {
          System.out.println("Error opening file: " + e);
      	}

	// Fill in the operations that create, manipulate, and output the
	// results of the TestGrades objects here
	// Use separate methods for reading in the data,
	// processing the data, and output


  }
    /**
    * Average of the student's grade should be stored in a separate array.
    * @requires The array size will = the first number from the input file.
    * @return a new array with the same size of an array that contains the average of each students.
    */
    
    
    /**
    * Inside an array, finds the index of the array that has the highest value.
    * 
    * @param theArray contains the average test scores for the individual.
    * @return the highest average from the list.
    */
    
    
    
    /**
    * Inside an array, finds the index with the lowest value.
    * if (int[i] < low) { low = int[i] 
    * @param theArray contains the average test scores for the individual.
    * @return the highest average from the list. 
    */
    
    
    /**
    * Inside an array, computes the average of the testcores inside the array.
    * (int[0]+int[1]+...int[n-2]+int[n-1]) / n
    * @param theArray The average testscores
    * @return the 
    */

}