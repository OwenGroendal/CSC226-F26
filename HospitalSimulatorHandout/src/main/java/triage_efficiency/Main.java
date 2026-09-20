package triage_efficiency;

import patient_intake.Patient;

public class Main {
    public static void main(String[] args) {

        Patient[] patients = generatePatients(100);
        patients = sortByPatientId(patients);

        System.out.println("Linear Search: ");
        Patient newPatient = EfficiencyTester.linearSearch(patients, "P000008");
        System.out.println("Patient found: " + newPatient);

        newPatient = EfficiencyTester.linearSearch(patients, "P100000");
        System.out.println("Patient not found: " + newPatient);
        System.out.println();

        System.out.println("Binary Search: ");
        newPatient = EfficiencyTester.binarySearch(patients, "P000064");
        System.out.println("Patient found: " + newPatient);

        newPatient = EfficiencyTester.binarySearch(patients, "P012300");
        System.out.println("Patient not found: " + newPatient);
        System.out.println();

        System.out.println("Jump Search: ");
        newPatient = EfficiencyTester.logNSearch(patients, "P000042");
        System.out.println("Patient found: " + newPatient);
        
        newPatient = EfficiencyTester.logNSearch(patients, "P999999");
        System.out.println("Patient not found: " + newPatient);
        System.out.println();
        
        //OPTIONAL TIME DEMO TESTING
        
        System.out.println("Time Demo Testing: ");
        System.out.println("100 patients: ");
        long startTime = System.nanoTime();
        newPatient = EfficiencyTester.linearSearch(patients, "P000078");
        long endTime = System.nanoTime();
        System.out.println("Patient found: " + newPatient);
        System.out.println("Linear search took: " + (endTime - startTime) + " ns");
        System.out.println();

        startTime = System.nanoTime();
        newPatient = EfficiencyTester.binarySearch(patients, "P000078");
        endTime = System.nanoTime();
        System.out.println("Patient found: " + newPatient);
        System.out.println("Binary search took: " + (endTime - startTime) + " ns");
        System.out.println();

        startTime = System.nanoTime();
        newPatient = EfficiencyTester.logNSearch(patients, "P000078");
        endTime = System.nanoTime();
        System.out.println("Patient found: " + newPatient);
        System.out.println("Jump search took: " + (endTime - startTime) + " ns");
        System.out.println();

        patients = generatePatients(1000);
        patients = sortByPatientId(patients);

        System.out.println("1000 patients: ");
        startTime = System.nanoTime();
        newPatient = EfficiencyTester.linearSearch(patients, "P000224");
        endTime = System.nanoTime();
        System.out.println("Patient found: " + newPatient);
        System.out.println("Linear search took: " + (endTime - startTime) + " ns");
        System.out.println();

        startTime = System.nanoTime();
        newPatient = EfficiencyTester.binarySearch(patients, "P000224");
        endTime = System.nanoTime();
        System.out.println("Patient found: " + newPatient);
        System.out.println("Binary search took: " + (endTime - startTime) + " ns");
        System.out.println();

        startTime = System.nanoTime();
        newPatient = EfficiencyTester.logNSearch(patients, "P000224");
        endTime = System.nanoTime();
        System.out.println("Patient found: " + newPatient);
        System.out.println("Jump search took: " + (endTime - startTime) + " ns");
        System.out.println();

        patients = generatePatients(10000);
        patients = sortByPatientId(patients);

        System.out.println("10000 patients: ");
        startTime = System.nanoTime();
        newPatient = EfficiencyTester.linearSearch(patients, "P006109");
        endTime = System.nanoTime();
        System.out.println("Patient found: " + newPatient);
        System.out.println("Linear search took: " + (endTime - startTime) + " ns");
        System.out.println();

        startTime = System.nanoTime();
        newPatient = EfficiencyTester.binarySearch(patients, "P006109");
        endTime = System.nanoTime();
        System.out.println("Patient found: " + newPatient);
        System.out.println("Binary search took: " + (endTime - startTime) + " ns");
        System.out.println();

        startTime = System.nanoTime();
        newPatient = EfficiencyTester.logNSearch(patients, "P006109");
        endTime = System.nanoTime();
        System.out.println("Patient found: " + newPatient);
        System.out.println("Jump search took: " + (endTime - startTime) + " ns");
        System.out.println();

        patients = generatePatients(100000);

        System.out.println("100000 patients: ");
        startTime = System.nanoTime();
        newPatient = EfficiencyTester.linearSearch(patients, "P099145");
        endTime = System.nanoTime();
        System.out.println("Patient found: " + newPatient);
        System.out.println("Linear search took: " + (endTime - startTime) + " ns");
        System.out.println();

        startTime = System.nanoTime();
        newPatient = EfficiencyTester.binarySearch(patients, "P099145");
        endTime = System.nanoTime();
        System.out.println("Patient found: " + newPatient);
        System.out.println("Binary search took: " + (endTime - startTime) + " ns");
        System.out.println();

        startTime = System.nanoTime();
        newPatient = EfficiencyTester.logNSearch(patients, "P099145");
        endTime = System.nanoTime();
        System.out.println("Patient found: " + newPatient);
        System.out.println("Jump search took: " + (endTime - startTime) + " ns");
        System.out.println();

    }

    public static Patient[] generatePatients(int count) {

        Patient[] patients = new Patient[count];

         for(int i = 0; i < count; i++) {
            patients[i] = new Patient(String.format("P%06d", i), "Test", 
            "Patient", 30, "Headache",
            4, "Waiting", "ER-200", 10, "INS-" + i);
         }
            return patients;
        }

    public static Patient[] sortByPatientId(Patient[] patients) {

        for(int i = 0; i < patients.length-1; i++) {
            for(int a = 0; a < patients.length-1; a++) {
                if(patients[a].getPatientID().compareToIgnoreCase(patients[a+1].getPatientID()) > 0) {
                Patient temp = patients[a];
                patients[a] = patients[a+1];
                patients[a+1] = temp;
            }
            }
        }
        return patients; 
    }
}
