package triage_efficiency;

import java.util.*;
import patient_intake.Patient;

public class EfficiencyTester {

    public Patient linearSearch(Patient[] patients, String pid) {

        for(int i = 0; i < patients.length; i++) {
            if(patients[i].getPatientId().equalsIgnoreCase(pid)) return patients[i];
        }
        return null;
    }

    public Patient binarySearch(Patient[] patients, String pid) {

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
    
    //Jump Search:
    //I learned about jump search on GeeksForGeeks 
    //(https://www.geeksforgeeks.org/dsa/jump-search/)
    //Jump search works as you are essentially going through the patients
    //array
    
    public Patient logNSearch(Patient[] patients, String pid) {

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
    
    public void timeDemo() {
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
