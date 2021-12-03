/*
* Course: TCSS 142 – Introduction to Object-Oriented Programming
* File Name: Personality.java
* Due Date: December 7, 2021
* Instructor: Professor David Schuessler
*/
import java.io.*;
import java.util.*;

/**
* This program prints a the statistics of the class average personality test involving
* the Keirsey test. When the test results in a text file is scanned, the user can 
* expect the statistics result of the user's test case.
* Personality test is first on Extrovert/Introvert 10 questions,
* Thinking/Feeling 20 questions, Judging/Perceiving 20 questions

* @author Hyunggil Woo
* @version 2021/12/01
*/

public class TestGrades {
    
    /** Counts how many student objects have been created.*/
    private static int counter = 0;
    
    /** Student's first name is stored here. */
    private static String myFirstName;
    
    /** Student's last name is stored here. */
    private static String myLastName;
    
    /** Scores of 4 tests are stored here. Each index does not contain null value.*/
    private static int[] myTestScores;
    
    /**
    * TestGrade class contains test values that will create certain values in the beginning.
    *
    *
    */
    public TestGrades (String theFristName, String theLastName, int[] theTestScores) {
        myFirstName = theFristName;
        myLastName = theLastName;
        myTestScores = theTestScores;
    }
    
    /**
    * From the int array, takes the average of the top n - 1 scores in the array.
    * Find the index with the minimum value. 
    * @param theArray contains the test scores.
    * @return the average
    */
    public int getAverage(int[] theTestScores) {
        Arrays.sort(theTestScores);
        int number = theTestScores.length;
        int total = 0;
        for (int i = 1; i < number; i++) {
            total += theTestScores[i];
        }
        return total / number;    
    }
    
    /**
    * Returns the first name of the TestGrades object.
    * @return myFirstName
    */
    public String getFirstName() {
        return myFirstName;
    }
    
    /**
    * Returns the last name of the TestGrades object.
    * @return the last name of the object.
    */    
    public String getLastName() {
        return myLastName;
    }
    
    /**
    * A copy of the test grades are printed.
    *
    */
    public int[] getTestScores() {
        return myTestScores;
    }
    
    /**
    * Returns the above formatted String
    * First name + last name + list of test scores + the average test scores.
    * @return 
    */
    public String toString() {
        String output = getFirstName() + " ";
        output += getLastName() + " ";
        output += Arrays.toString(getTestScores()) + " ";
        output += "Average = " + getAverage(getTestScores());
        return output;  
    }
}