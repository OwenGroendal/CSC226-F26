package medical_action_tracking;

import patient_intake.Patient;

public class EmergencyWaitingRoom {
    private LinkedQueue<Patient> level1;
    private LinkedQueue<Patient> level2;
    private LinkedQueue<Patient> level3;
    private LinkedQueue<Patient> level4;
    int levelCapacity = 5;

    public EmergencyWaitingRoom() {
         level1 = new LinkedQueue<>();
         level2 = new LinkedQueue<>();
         level3 = new LinkedQueue<>();
         level4 = new LinkedQueue<>();
    }

    public boolean addPatient(Patient patient) {

        if(patient == null) return false;

        int level = patient.getTriageLevel();

        if(level == 1) {
            if(level1.size() >= levelCapacity) return false;
            level1.enqueue(patient);
        }

        else if(level == 2) {
            if(level2.size() >= levelCapacity) return false;
            level2.enqueue(patient);
        }

        else if(level == 3) {
            if(level3.size() >= levelCapacity) return false;
            level3.enqueue(patient);
        }

        else if(level == 4) {
            if(level4.size() >= levelCapacity) return false;
            level4.enqueue(patient);
        }
        
        else return false;
        return true;
    }

    public Patient nextPatient() {

        if(!level1.isEmpty()) return level1.dequeue();
        else if(!level2.isEmpty()) return level2.dequeue();
        else if(!level3.isEmpty()) return level3.dequeue();
        else if(!level4.isEmpty()) return level4.dequeue();
        else return null;

    }

    public boolean isEmpty() {
        if(level1.isEmpty() && level2.isEmpty() && level3.isEmpty() && level4.isEmpty()) return true;
        return false;
    }

    public int size() {
        int size = 0;
        size = size + level1.size() + level2.size() + level3.size() + level4.size();
        return size;
    }
}
