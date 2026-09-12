package patient_intake;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentAdditionalTests {

    PatientRegistry registry = new PatientRegistry();

 //This test verifies that we are able to getPatientID from a patient object. This is important because we need to get patientID
 //from patient's so that we can match the correct ID to the correct person. We also use patientID for other functions, and we need
 //to make sure that it will get the correct one every time.
@Test     
public void testPatientId() {
    Patient patient = new Patient("P001", "Nathan", "Odeen", 30, 
    "Headache", 4, "Waiting", "Room 20", 2, "INS409");

    assertEquals("P001", patient.getPatientID());
}

//This test verifies that we are able to set the patient's complaint to a different value. This is important because in real hospitals,
//a patient's condition status will change all the of time. It's critical that we are able to update their complaint in the system
//so that doctor's would know what they are dealing with.
@Test 
public void testSetChiefComplaint() {
    Patient patient = new Patient("P001", "Nathan", "Odeen", 30, 
    "Headache", 4, "Waiting", "Room 20", 2, "INS409");

    patient.setChiefComplaint("Migraine");

    assertEquals("Migraine", patient.getChiefComplaint());
}

//This test verifies that people when setting age, can not do a number below 0, or above 120. This is important because we don't
//want innaccurate information being present in the patient's profile. We want to make sure that the setAge() function works
//properly, and only accepts valid ages.
@Test 
public void testInvalidAge() {
    Patient patient = new Patient("P001", "Nathan", "Odeen", 30, 
    "Headache", 4, "Waiting", "Room 20", 2, "INS409");

    patient.setAge(180);

    assertEquals(30, patient.getAge());
}

//This test verifies that we are able to update a patient's information using the updatePatient() function. It's important because
//there is going to be times where multiple things change in a patient (triagelevel, currentstage, roomnumber etc.), and
//we need to make sure to test the function and be able to accurately update that information
@Test 
public void testUpdatedPatient() {
    Patient patient = new Patient("P001", "Nathan", "Odeen", 30, 
    "Headache", 4, "Waiting", "Room 20", 2, "INS409");

    registry.addPatient(patient);

    Patient newPatient = new Patient("P001", "Nathan", "Odeen", 30, 
    "Throbbing Headache", 2, "Waiting", "Room 10", 2, "INS409");

    assertEquals(true, registry.updatePatient(newPatient));
}

//This test verfies that we are able to remove a patient from the patientRegistry array. This is important because
//patients will come and go out of the hospital. Once a patient is gone, it's critical that we are able to
//remove them from the array, so that we will have space for future patients, and no longer have to worry about that patient.
@Test
public void testRemovePatient() {
    Patient patient = new Patient("P001", "Nathan", "Odeen", 30, 
    "Headache", 4, "Waiting", "Room 20", 2, "INS409");

    registry.addPatient(patient);

    assertEquals(true, registry.removePatient("P001"));
}

//This test verifies that we are able to use the getPatientByID() function by inputting a patientID and in return getting the patient
//object that matches with that ID. This is important because there are times where we might have the ID of a patient, but need
//to get the name and other information as well. So, we can use this function to easily find that name and all other information
//about the patient in the database.

//
@Test 
public void testGetPatientByID() {
    Patient patient = new Patient("P001", "Nathan", "Odeen", 30, 
    "Headache", 4, "Waiting", "Room 20", 2, "INS409");

    registry.addPatient(patient);

    assertEquals(patient, registry.getPatientByID("P001"));
}

}

