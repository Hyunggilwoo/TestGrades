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

    /** Number of exams are accounted here.*/
    public final int NUMBER_OF_EXAMS = 4;
    
    /** Count of students in the constructor.*/
    private static int myStudentCount = 0;
    
    /** Student's first name is stored here. */
    private String myFirstName;
    
    /** Student's last name is stored here. */
    private String myLastName;
    
    /** Scores of 4 tests are stored here. Each index does not contain null value.*/
    private int[] myTestScores;
    

    
    /**
    * TestGrade class contains test values that will create certain values in the beginning.
    *
    *
    */
    public TestGrades (String theFristName, String theLastName, int[] theTestScores) {
        myFirstName = theFristName;
        myLastName = theLastName;
        myTestScores = theTestScores;
        myStudentCount++;
    }
    
    /**
    * From the int array, takes the average of the top n - 1 scores in the array.
    * Find the index with the minimum value. 
    * @param theTestScores contains the test scores.
    * @return the average of top 3 scores on the exam.
    */
    public int getTestAverage(int[] theTestScores) {
        Arrays.sort(theTestScores);
        int number = theTestScores.length;
        System.out.println(number);
        int total = 0;
        for (int i = 1; i < number; i++) {
            total += theTestScores[i];
        }
        return total / (number - 1);    
    }

    /**
    * @Requires the test number is greater 0 and less than 5.
    * and the test score must be between 0 and 100.
    * @param theIndex the place to set the score
    * @param theScore the revised score.
    */
    public void setScore(int theIndex, int theScore) {
        // Sets the score in the index to meet the criteria.
        if (theIndex < 0 || theIndex > NUMBER_OF_EXAMS) {
            throw new IllegalArgumentException("The exam number must be " +
                                "at least 0 and less than NUMBER_OF_EXAMS.");
        }
        if (theScore < 0 || theScore > 100) {
            throw new IllegalArgumentException("The exam score must be " + 
                                                    "between 0 and 100.");
        }
        myTestScores[theIndex] = theScore;        
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
    *
    *
    */
    public int getStudentCount() {
        return myStudentCount;
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
        output += "Average = " + getTestAverage(getTestScores());
        return output;  
    }
}