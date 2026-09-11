package patient_intake;
import java.util.Arrays;

// Switch from using ArrayList to a flat array implementation for patient storage.

public class PatientRegistry {
    // Flat array to store patients and a size field to track the number of stored patients.
    private Patient[] patientRegistry;
    private int size = 0; // track actual number of patients

    // Initial capacity for the flat array. Can be adjusted as needed.
    private static final int INITIAL_CAPACITY = 10;

    public PatientRegistry() {
        patientRegistry = new Patient[INITIAL_CAPACITY];
    }

    public void addPatient(Patient patient) {

        if(size >= patientRegistry.length) {
              patientRegistry = Arrays.copyOf(patientRegistry, patientRegistry.length + 1);
        }

        patientRegistry[size] = patient;
        size++;
    }

    /**
     * Returns the patients currently stored in the registry.
     * The optional encapsulation extension requires returning a defensive copy.
     */
    public Patient[] getPatientRegistry() {
        return Arrays.copyOf(patientRegistry, size);
    }

    public Patient getPatientByID(String patientID) {
       for(int i = 0; i < size; i++) {
            if(patientRegistry[i].getPatientID().equalsIgnoreCase(patientID)) return patientRegistry[i];
       }
       return null;
    }

    /**
     * Removes a patient from the registry by patientID.
     * @param patientID The ID of the patient to remove
     * @return true if patient was found and removed, false otherwise
     */
    public boolean removePatient(String patientID) {
        int targetIndex = -1;
        for(int i = 0; i < size; i++) {
            if(patientRegistry[i].getPatientID().equalsIgnoreCase(patientID)) targetIndex = i;
        }
        if(targetIndex == -1) return false;
        for(int i = targetIndex; i < size-1; i++) {
            patientRegistry[i] = patientRegistry[i+1];
        }
        patientRegistry[size-1] = null;
        size--;
        return true;
    }

    /**
     * Removes a patient from the registry by index.
     * @param index The index of the patient to remove
     * @return the removed Patient, or null if index is invalid
     */
    public Patient removePatient(int index) {

        if(index < 0 || index >= size) {
            return null;
        }

        Patient removedPatient = patientRegistry[index];

        for(int i = index; i < size-1; i++) {
            patientRegistry[i] = patientRegistry[i+1];
        }
        patientRegistry[size-1] = null;
        size--;

        return removedPatient;
    }

    /**
     * Updates a patient in the registry by matching patientID.
     * @param updatedPatient The patient with updated information
     * @return true if patient was found and updated, false otherwise
     */
    public boolean updatePatient(Patient updatedPatient) {
        for(int i = 0; i < size; i++) {
            if(patientRegistry[i].getPatientID().equalsIgnoreCase(updatedPatient.getPatientID())) {
                patientRegistry[i] = updatedPatient;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {

        String answer = "";

         for(int i = 0; i < size; i++) {
            answer = answer + patientRegistry[i] + "\n";
         }

         return answer;
    }

}

