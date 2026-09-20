package triage_efficiency;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import patient_intake.Patient;

public class StudentTestsAlgorithms {

    private Patient[] buildSortedPatients() {
        Patient[] patients = new Patient[6];
        patients[0] = new Patient("P00001", "Charlie", "Calla", 39, "Throbbing Migraine", 4, "Triage", "ER-120", 8, "INS-00013");
        patients[1] = new Patient("P00002", "Aaron", "Lyles", 65, "Back Pain", 3, "Recovery", "ER-010", 11, "INS-01122");
        patients[2] = new Patient("P00003", "Bailey", "Cynder", 19, "Numbness", 4, "Waiting", "ER-100", 3, "INS-00123");
        patients[3] = new Patient("P00004", "Jack", "Frost", 24, "Dizzy", 2, "Triage", "ER-234", 5, "INS-04012");
        patients[4] = new Patient("P00005", "Jenny", "Bilba", 45, "Leg Pain", 4, "Recovery", "ER-194", 4, "INS-00056");
        patients[5] = new Patient("P00006", "Ben", "Armstrong", 62, "Stomach Pain", 7, "Treatment", "ER-210", 8, "INS-00541");
        return patients;
    }

//This test does a linear search through the array and expects to see null because the ID is not
//one of the ID's in the array. This is important because we want to ensure that the algorithm 
//does not return a Patient object with an invalid/incorrect ID. It needs to be null
@Test 
void testLinearSearchReturnNull( ) {
    Patient[] patients = buildSortedPatients();
    Patient newPatient = EfficiencyTester.linearSearch(patients, "P02000");
    assertNull(newPatient);
}

//This test does a linear search through the array and expects to see the proper ID attached
//to the patient that was returned from the algorithm. This is important because we want to ensure
//that the algorithm does return a Patient object with a valid/correct ID that we were looking for.
@Test 
void testLinearSearchCorrectID( ) {
    Patient[] patients = buildSortedPatients();
    Patient newPatient = EfficiencyTester.linearSearch(patients, "P00001");
    assertEquals("P00001", newPatient.getPatientID());
}

//This test does a binary search through the array and expects to see null because the ID is not
//one of the ID's in the array. This is important because we want to ensure that the algorithm 
//does not return a Patient object with an invalid/incorrect ID. It needs to be null
@Test 
void testBinarySearchReturnNull() {
    Patient[] patients = buildSortedPatients();
    Patient newPatient = EfficiencyTester.binarySearch(patients, "P99999");
    assertNull(newPatient);
}

//This test does a binary search through the array and expects to see the proper ID attached
//to the patient that was returned from the algorithm. This is important because we want to ensure
//that the algorithm does return a Patient object with a valid/correct ID that we were looking for.
@Test 
void testBinarySearchReturnCorrectID() {
    Patient[] patients = buildSortedPatients();
    Patient newPatient = EfficiencyTester.binarySearch(patients, "P00006");
    assertEquals("P00006", newPatient.getPatientID());
}

//This test does a LogNSearch (jump search in my case) through the array and expects to see null 
//because the ID is not one of the ID's in the array. This is important because we want to ensure 
//that the algorithm does not return a Patient object with an invalid/incorrect ID. 
//It needs to be null
@Test 
void testLogNSearchReturnNull() {
    Patient[] patients = buildSortedPatients();
    Patient newPatient = EfficiencyTester.logNSearch(patients, "P00040");
    assertNull(newPatient);
}

//This test does a LogNSearch (jump search in my case) through the array and expects to see the proper
//ID attached to the patient that was returned from the algorithm. This is important because we want 
//to ensure that the algorithm does return a Patient object with a valid/correct ID that we
//were looking for.
@Test 
void testLogNSearchReturnCorrectID() {
    Patient[] patients = buildSortedPatients();
    Patient newPatient = EfficiencyTester.logNSearch(patients, "P00003");
    assertEquals("P00003", newPatient.getPatientID());
}
    
}
