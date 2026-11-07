package staff_assignment;

import medical_action_tracking.TreatmentRecord;

public class Main {

    //TODO, create a main file to demonstrate your roster: add staff, assign treatments, undo one, release cases,
    //and show each treatment's performedBy staffId

    public static void main(String[] args) {

        StaffRoster roster = new StaffRoster(); 

        StaffMember member1 = new StaffMember("S001", "Rebecca Pierce", Seniority.TECH);
        StaffMember member2 = new StaffMember("S002", "James Winser", Seniority.NURSE);
        StaffMember member3 = new StaffMember("S003", "Ben Lawrence", Seniority.RESIDENT);
        StaffMember member4 = new StaffMember("S004", "Ashley Pilger", Seniority.ATTENDING);
        StaffMember member5 = new StaffMember("S005", "Frank Layer", Seniority.TECH);
        StaffMember member6 = new StaffMember("S006", "Alyssa Thompson", Seniority.RESIDENT);
        StaffMember member7 = new StaffMember("S007", "Damian Shields", Seniority.NURSE);
        StaffMember member8 = new StaffMember("S008", "Trevor Munksy", Seniority.ATTENDING);

        roster.addStaff(member1);
        roster.addStaff(member2);
        roster.addStaff(member3);
        roster.addStaff(member4);
        roster.addStaff(member5);
        roster.addStaff(member6);
        roster.addStaff(member7);
        roster.addStaff(member8);

        System.out.println("\nPrinting Roster: ");
        roster.displayRoster();

        StaffMember value = member1;
        System.out.println("Before assign: " + value);
        value = roster.assign(Seniority.TECH);
        System.out.println("After assign: " + value);

        roster.release(member1);
        System.out.println("\nAfter running release: " + member1);

        int size = roster.size();
        System.out.println("\nSize of roster: " + size);

        System.out.println("\nBefore change load: " + member4);
        roster.changeLoad(member4, 3);
        System.out.println("After change load: " + member4);

        value = roster.assignTreatment("P010", "Blood Test", "2026-11-23 11:05", Seniority.NURSE);
        System.out.println("\nThe staff helping after calling assignTreatment(): " + value);
        System.out.println("\nTreatment History: ");
        roster.displayTreatmentHistory();

        value = roster.assignTreatment("P012", "X-ray", "2026-06-12 12:35", Seniority.TECH);
        System.out.println("\nThe staff helping after calling assignTreatment(): " + value);
        System.out.println("\nTreatment History: ");
        roster.displayTreatmentHistory();

        value = roster.assignTreatment("P014", "Head Exam", "2026-07-13 08:25", Seniority.RESIDENT);
        System.out.println("\nThe staff helping after calling assignTreatment(): " + value);
        System.out.println("\nTreatment History: ");
        roster.displayTreatmentHistory();

        value = roster.undoLastAssignment();
        System.out.println("\nUndoing last assignment... " + value);

        System.out.println("\nUpdated Treatment History: ");
        roster.displayTreatmentHistory();

        value = roster.findById("S005");
        System.out.println("\nStaff Member S005: " + value);
    }
}
