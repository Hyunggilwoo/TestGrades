/*
 * Add appropriate documentation here
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
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
     *
     *
     */
    public static void main(String[] theArgs){
        Scanner input = null;
        PrintStream output = null;
        try {
            input = new Scanner(new File("in4.txt"));
            output = new PrintStream(new File("out4.txt"));
            int number = numOfStudent(input, output);
            TestGrades[] studentReport = find(input, number);
            printStudents(output, studentReport);
            int[] testAverages = generateArray(studentReport);
            output.println();
            output.println("Highest Student Average = " + max(testAverages));
            output.println("Lowest Student Average = " + min(testAverages));
            output.println("Overall Class Average = " + overallAverage(testAverages));
        }
        catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + e);
        }
    }

    /**
     * Constructs the TestGrades object student(firstName, lastName, scores)
     * Method to print out the number of test average of students from a file.
     *
     * @param theConsole scans the input file
     * @return the array of of student information in the array.
     */
    public static TestGrades[] find(Scanner theConsole, int theNumber) {
        TestGrades[] studentReport = new TestGrades[theNumber];
        int count = 0;
        // prints toString() of a student
        while(theConsole.hasNext()) { // 
            String firstName = theConsole.next(); // {Sally}
            String lastName = theConsole.next();  // {Soso}
            // somehow the every test scores are based on the last student's. error.
            int[] scores = new int[NUMBER_OF_EXAMS];
            for (int j = 0; j < scores.length; j++) {
                scores[j] = theConsole.nextInt(); // { [78, 67, 72, 75]} 
            }
            // Sally Soso [78, 67, 72, 75] Average ...
            studentReport[count] = addGrades(firstName, lastName, scores);
            count++;
        }
        return studentReport;
    }

    /**
     * Helper method to add the names and the score into an array of the students.
     * @param theFirstName
     * @param theLastName
     * @param theScores
     * @return
     */
    public static TestGrades addGrades (String theFirstName, String theLastName, int[] theScores) {
        TestGrades student = new TestGrades(theFirstName, theLastName, theScores);
        return student;

    }

    /**
     * Receives the selection of TestGrade objects, then print all of the students
     * that are present in the file.
     * @param theOutput prints the values into an output file
     * @param theReport is a data that is scanned.
     */
    public static void printStudents(PrintStream theOutput, TestGrades[] theReport) {
        for (int i = 0; i < theReport.length; i++) {
            theOutput.println(theReport[i].toString());
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
     * Generates an array of only the test averages in a sorted way
     * in an ascending order.
     * @param theStudent Array of Students.
     * @return the averages of the test score.
     */
    public static int[] generateArray(TestGrades[] theStudent) {
        int[] averages = new int[theStudent.length];
        for (int i = 0; i < theStudent.length; i++) {
            averages[i] = theStudent[i].getTestAverage(theStudent[i].getTestScores());
        }
        Arrays.sort(averages);
        return averages;
    }
    
    /**
    * Inside an array, finds the index of the array that has the highest value.
    * 
    * @param theTestAverages contains the average test scores for the individual.
    * @return the highest average from the list.
    */
    public static int max(int[] theTestAverages) {
        int size = theTestAverages.length - 1;
        return theTestAverages[size];
    }
    
    
    /**
    * Inside an array, finds the index with the lowest value.
    * if (int[i] < low) { low = int[i] 
    * @param theTestAverages contains the average test scores for the individual.
    * @return the highest average from the list. 
    */
    public static int min(int[] theTestAverages) {
        int size = 0;
        return theTestAverages[size];
    }    
    
    /**
    * Computes the average of the testcores inside the array.
    * (int[0]+int[1]+...int[n-2]+int[n-1]) / n
    * @param theTestAverages The average testscores
    * @return overall average test scores for the group of students.
    */
    public static int overallAverage(int[] theTestAverages) {
        int number = theTestAverages.length;
        int sum = 0;
        for (int i = 0; i < number; i++) {
            sum += theTestAverages[i];
        }
        return sum / number;
    }
}