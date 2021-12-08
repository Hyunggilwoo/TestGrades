/*
 * Course: TCSS142 � Introduction to Object-Oriented Programming
 * File Name: GradeDriver.java
 * Assignment: 4
 * Due Date: December 7, 2021
 * Instructor: Mr. Schuessler
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This program computes the test averages stored in a file.
 * It relies on a TestGrade class to output the overall average
 * of the students, and the highest average, lowest average, and
 * the overall average of the students.
 */
public class GradeDriver{

    /** Number of Exams are kept here*/
    public static final int NUMBER_OF_EXAMS = 4;

    /**
     * Accepts a file to scan how many number of averages it will need to
     * compute. Requires the first line of the input file contain an int > 0.
     * // Method ignores the number of data entry from the first line.
     * Creates the TestGrades class from the main driver.
     *
     * @param theArgs accepts the command argument from the console.
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
            int[] Averages = generateArray(studentReport);
            output.println();
            output.println("Highest Student Average = " + highest(Averages));
            output.println("Lowest Student Average = " + lowest(Averages));
            output.println("Overall Class Average = " + overall(Averages));
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
        while(theConsole.hasNext()) {
            String firstName = theConsole.next();
            String lastName = theConsole.next();
            int[] scores = new int[NUMBER_OF_EXAMS];
            for (int j = 0; j < scores.length; j++) {
                scores[j] = theConsole.nextInt();
            }
            studentReport[count] = addGrades(firstName, lastName, scores);
            count++;
        }
        return studentReport;
    }

    /**
     * Helper method to add the names and the score into an array of the
     * students.
     *
     * @param theFirstName of a student.
     * @param theLastName of a student.
     * @param theScores on tests.
     * @return TestGrade object.
     */
    public static TestGrades addGrades (String theFirstName,
                                        String theLastName, int[] theScores) {
        return new TestGrades(theFirstName, theLastName, theScores);
    }

    /**
     * Receives the selection of TestGrade objects, then print every student
     * that are present in the file.
     *
     * @param theOutput prints the values into an output file
     * @param theReport is a data that is scanned.
     */
    public static void printStudents(PrintStream theOutput,
                                     TestGrades[] theReport) {
        for (TestGrades testGrades : theReport) {
            theOutput.println(testGrades.toString());
        }
    }

    /**
    * If the number of students are printed at the top of input file,
    * it prints the number of students in this file.
    *
    * @param theConsole adds an input from a file.
    * @param theOutput prints it on a file.
    * @return the number of student.
    */
    public static int numOfStudent(Scanner theConsole, PrintStream theOutput) {
        int numOfStudent = theConsole.nextInt();
        theOutput.println("Total number of students: " + numOfStudent);
        return numOfStudent;
    }

    /**
     * Generates an array of only the test averages in a sorted way
     * in ascending order.
     *
     * @param theStudent Array of Students.
     * @return the averages of the test score.
     */
    public static int[] generateArray(TestGrades[] theStudent) {
        int[] averages = new int[theStudent.length];
        for (int i = 0; i < theStudent.length; i++) {
            averages[i] =
                theStudent[i].getTestAverage(theStudent[i].getTestScores());
        }
        Arrays.sort(averages);
        return averages;
    }
    
    /**
    * Returns the highest average. max = int[n - 1]
    *
    * @param theTestAverages for all students.
    * @return the highest average from the list.
    */
    public static int highest(int[] theTestAverages) {
        int size = theTestAverages.length - 1;
        return theTestAverages[size];
    }
    
    /**
    * Returns the lowest average. min = int[0]
    *
    * @param theTestAverages for all students.
    * @return the highest average from the list. 
    */
    public static int lowest(int[] theTestAverages) {
        int size = 0;
        return theTestAverages[size];
    }    
    
    /**
    * Computes the average of the test scores inside the array.
    * (int[0]+int[1]+...int[n-2]+int[n-1]) / n
    *
    * @param theTestAverages The average test scores
    * @return overall average test scores for the group of students.
    */
    public static int overall(int[] theTestAverages) {
        int number = theTestAverages.length;
        int sum = 0;
        for (int theTestAverage : theTestAverages) {
            sum += theTestAverage;
        }
        return sum / number;
    }
}