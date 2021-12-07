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
    
    public static final int NUMBER_OF_EXAMS = 4;

    /**
     * Accepts a file to scan how many number of averages it will need to compute.
     * Requires the first line of the input file contain an int > 0.
     * // Method ignores the number of data entry from the first line.
     * Creates the TestGrades class from the main driver.
     *
     * I don't enjoy this input file. Can I just reorganize the input file into a 
     * way that I want?
     *
     */
	public static void main(String[] theArgs){
      	Scanner input = null;
      	PrintStream output = null;
        try {
            input = new Scanner(new File("in4.txt"));
            output = new PrintStream(new File("out4.txt"));
            numOfStudent(input, output);
            find(input, output);
        }
        catch (FileNotFoundException e) {
          System.out.println("Error opening file: " + e);
      	}
        
    }
    
    /**
    * Expects the 
    * Method to print out the number of test average of students from a file.
    *  
    * Post: Returns the averages of the exam to a new method.
    */
    public static void find(Scanner theConsole, PrintStream theOutput) {
        while(theConsole.hasNext()) {
            String firstName = theConsole.next();
            String lastName = theConsole.next();
            int[] scores = new int[NUMBER_OF_EXAMS];
            for (int j = 0; j < scores.length; j++) {
                scores[j] = theConsole.nextInt();
            }
            TestGrades student = new TestGrades(firstName, lastName, scores);
            theOutput.println(student.toString());
        }
    }
    
    /**
    * Method that parses the number of student from the input file.
    *
    */
    public static int numOfStudent(Scanner theConsole, PrintStream theOutput) {
        int numOfStudent = theConsole.nextInt();
        theOutput.println("Total number of students: " + numOfStudent);
        return numOfStudent;
    }
    
    /**
    * Average of the student's grade should be stored in a separate array.
    * @requires The array size will = the first number from the input file.
    * @return a new array with the same size of an array that contains the average of each students.
    */
    public static int[] sortAverages() {
    
    }
    
    
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