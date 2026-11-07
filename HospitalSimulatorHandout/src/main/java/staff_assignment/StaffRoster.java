package staff_assignment;

import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.TreeSet;

import medical_action_tracking.TreatmentHistory;
import medical_action_tracking.TreatmentRecord;

public class StaffRoster {
    // Week 3 stack-based history; every assignment is recorded here so it can be undone.
    private final TreatmentHistory history = new TreatmentHistory();

    // Outer map groups staff by seniority; each inner set is sorted by StaffMember's ordering.
    private final TreeMap<Seniority, TreeSet<StaffMember>> tiers = new TreeMap<>();

    // TODO: Add the staff member to the correct tier, and reject a duplicate staffId.
    public void addStaff(StaffMember staff) {

        if(staff == null) throw new IllegalArgumentException("Can't be null");

        if(findById(staff.getStaffId()) != null) {
            throw new IllegalArgumentException("Can't be repeat staffId");
        }

        Seniority seniority = staff.getSeniority();

        tiers.putIfAbsent(seniority, new TreeSet<>());

        tiers.get(seniority).add(staff);

    }

    public void displayTreatmentHistory() {
        history.displayHistoryWithStaff();
}

    // TODO: Pick the least-loaded staff member at or above "required", raise their load by 1, and return them.
    public StaffMember assign(Seniority required) {

        StaffMember leastLoaded = null;

        for(TreeSet<StaffMember> set : tiers.tailMap(required).values()) {

            if(!set.isEmpty()) {
                 StaffMember staff = set.first();
                 
                 if(leastLoaded == null ||staff.getCaseLoad() < leastLoaded.getCaseLoad()) {
                    leastLoaded = staff;
                 }  
        }
    }
    
    if(leastLoaded == null) {
        throw new NoSuchElementException("No eligible staff member found");
    }
    changeLoad(leastLoaded, leastLoaded.getCaseLoad() + 1);
                 return leastLoaded; 
        
    }

    // TODO: Lower the staff member's load by 1 (never below 0) and keep the tree ordered.
    public void release(StaffMember staff) {

        if(staff == null) return;

         if(staff.getCaseLoad() == 0) return;
         changeLoad(staff, staff.getCaseLoad()-1);

    }

    // TODO: Return how many staff members are in the roster.
    public int size() {

        int count = 0;

        for(TreeSet<StaffMember> set : tiers.values()) {
            for(StaffMember member : set) {
                count++;
            }
        }

        return count;
    }

    // TODO: Print each tier, most senior first, listing its staff in order.
    public void displayRoster() {

        for(Seniority seniority: tiers.descendingKeySet()) {
           System.out.println(seniority + ": ");

           for(StaffMember member : tiers.get(seniority)) {
                System.out.println(" " + member);
           }
        }
    }

    // TODO: Remove the member, set the new load, then add them back (the only safe way to change a load).
    public void changeLoad(StaffMember member, int newLoad) {

        if(member == null) return;

        TreeSet<StaffMember> set = tiers.get(member.getSeniority());

        if(set == null) return;

        set.remove(member);
        member.setCaseLoad(newLoad);
        set.add(member);

    }

    // TODO: Call assign(), record the treatment in history with the chosen staffId, and return that staff member.
    public StaffMember assignTreatment(String patientID, String treatment, String timestamp, Seniority required) {

        StaffMember staff = assign(required);

        if(staff == null) return null;

        history.addTreatment(patientID, treatment, timestamp, staff.getStaffId());

        return staff;
    }

    // TODO: Pop the globally most recent treatment with your Week 3 undo, release whoever performed it, and return them (null if none).
    public StaffMember undoLastAssignment() {

        TreatmentRecord value = history.undoLastAction();

        if(value == null) return null;

          StaffMember staff = findById(value.getPerformedBy());

        release(staff);

        return staff;
    }

    // TODO: Return the staff member with this staffId, or null if they are not in the roster.
    public StaffMember findById(String staffId) {

        for(TreeSet<StaffMember> set : tiers.values()) {
            for(StaffMember member : set) {
                if(member.getStaffId().equals(staffId)) return member;
            }
        }

        return null;
    }
}
