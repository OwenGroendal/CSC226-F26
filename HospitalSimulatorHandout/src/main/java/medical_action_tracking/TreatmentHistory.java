package medical_action_tracking;

public class TreatmentHistory {
    private LinkedStack<TreatmentRecord> allRecords;

    public TreatmentHistory() {
        allRecords = new LinkedStack<>();
    }

    public void addTreatment(String patientID, String treatment, String timestamp) {
        TreatmentRecord record = new TreatmentRecord(patientID, treatment, timestamp);
        allRecords.push(record);
    }

    public TreatmentRecord undoLastAction() {

        if(allRecords == null) return null;
        TreatmentRecord value = allRecords.pop();
        return value;
    }

    public String displayHistory() {
        if(allRecords == null) return null;
        return allRecords.toString();
}
}