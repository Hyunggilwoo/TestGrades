/*
* Course: TCSS 142 – Introduction to Object-Oriented Programming
* File Name: Personality.java
* Due Date: December 7, 2021
* Instructor: Professor David Schuessler
*/

import java.util.*;

/**
* TestGrades class stores the students' first name, last name, and test scores
* to compute them by the driver of the program.
*
* @author Hyunggil Woo
* @version 2021/12/07
*/
public class TestGrades {

    /** Number of exams are accounted here.*/
    public final int NUMBER_OF_EXAMS = 4;
    
    /** Count of students in the constructor.*/
    private static int myStudentCount = 0;
    
    /** Student's first name is stored. */
    private String myFirstName;
    
    /** Student's last name is stored. */
    private String myLastName;
    
    /** Scores of 4 tests are stored.*/
    private int[] myTestScores;
    
    /**
    * Constructor of the TestGrade.
    *
    * @theFirstName of a student.
    * @theLastName of a student.
    * @theTestScores of a student.
    */
    public TestGrades (String theFristName, String theLastName,
                                                        int[] theTestScores) {
        myFirstName = theFristName;
        myLastName = theLastName;
        myTestScores = theTestScores;
        myStudentCount++;
    }
    
    /**
    * Computes the average test scores in the array, except for the 0th index.
    *
    * @param theTestScores contains the test scores.
    * @return the average of top n - 1 scores on the exam.
    */
    public int getTestAverage(int[] theTestScores) {
        Arrays.sort(theTestScores);
        int number = theTestScores.length;
        int total = 0;
        for (int i = 1; i < number; i++) {
            total += theTestScores[i];
        }
        return total / (number - 1);    
    }

    /**
    * @Requires the test number is greater 0 and less than 5.
    * and the test score must be between 0 and 100.
    *
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
    * Accessor of myFirstName.
    *
    * @return copy of myFirstName.
    */
    public String getFirstName() {
        return myFirstName;
    }
    
    /**
    * Accessor of myLastName.
    *
    * @return copy of myLastName.
    */    
    public String getLastName() {
        return myLastName;
    }
    
    /**
    * Accessor of myStudentCount.
    *
    * @return copy of myStudentCount.
    */
    public int getStudentCount() {
        return myStudentCount;
    }

    /**
    * Accessor of myTestScores.
    *
    * @return copy of myTestScores.
    */
    public int[] getTestScores() {
        return myTestScores;
    }
    
    /**
    * Returns String of (First name + last name + list of test scores +
    * the average test scores).
    *
    * @return toString format for testGrades.
    */
    public String toString() {
        String output = getFirstName() + " ";
        output += getLastName() + " ";
        output += Arrays.toString(getTestScores()) + " ";
        output += "Average = " + getTestAverage(getTestScores());
        return output;  
    }
}