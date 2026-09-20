package triage_efficiency;

import java.util.*;
import patient_intake.Patient;

public class EfficiencyTester {

    public static Patient linearSearch(Patient[] patients, String pid) {

        for(int i = 0; i < patients.length; i++) {
            if(patients[i].getPatientID().equalsIgnoreCase(pid)) return patients[i];
        }
        return null;
    }

    public static Patient binarySearch(Patient[] patients, String pid) {

        int low = 0;
        int high = patients.length-1;
        
       while(low <= high) {

        int mid = (low + high) / 2;

        int compare = patients[mid].getPatientID().compareTo(pid);

        if(compare == 0) return patients[mid];
        else if(compare < 0) {
            low = mid + 1;
        }
        else {
            high = mid-1;
        }

       }

       return null;       
    }

    //OPTIONAL
    //Jump Search:
    //I learned about jump search on GeeksForGeeks 
    //(https://www.geeksforgeeks.org/dsa/jump-search/)
    //Jump search works as you are essentially going through the patients
    //array and going up in index by the square root of the patients.length
    //Proven to minimize amount of jumps in worst-case-scenario using the square root
    //At every jump, save the previous and the current index, and compare the current
    //patientID at the index to the pid. If you compare and get 0, they match, return patient
    // If less than 0, you still need to go further down array, and jump by the square root again
    //Once you compare and it's greater than 0, that means you just passed the string
    //Then go out of the while loop, and do linear search in that little block using
    //previous and current index to find the patient.
    
    public static Patient logNSearch(Patient[] patients, String pid) {

        int previous = 0;
        int jump = (int)Math.sqrt(patients.length);
        int current = jump;

        while(current < patients.length && patients[current].getPatientID().compareToIgnoreCase(pid) < 0) {
            previous = current;
            current = current + jump;
        }

        if(current >= patients.length) current = patients.length-1;

        for(int i = previous; i <= current; i++) {
            if(patients[i].getPatientID().equalsIgnoreCase(pid)) return patients[i];
        }
        return null;
    }
    
    public static void timeDemo() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int x = 5 + 5;
        }
        long endTime = System.nanoTime();

        System.out.println("The example addition took: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int x = 5 * 5;
        }
        endTime = System.nanoTime();
        System.out.println("The example multiplication took: " + (endTime - startTime) + " ns");
    }
}
