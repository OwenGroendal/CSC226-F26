package staff_assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentAddedTest {

    private StaffRoster roster;
    private StaffMember member1, member2, member3, member4, member5;

    @BeforeEach
    void setUp() {
        roster = new StaffRoster();
        member1 = new StaffMember("S001", "Member2", Seniority.ATTENDING);
        member2 = new StaffMember("S002", "Member2", Seniority.RESIDENT);
        member3 = new StaffMember("S003", "Member3", Seniority.NURSE);
        member4 = new StaffMember("S004", "Member4", Seniority.NURSE);
        member5 = new StaffMember("S005", "Member5", Seniority.TECH);
        for (StaffMember m : new StaffMember[]{member1, member2, member3, member4, member5}) {
            roster.addStaff(m);
        }
    }

    @Test
    void invalidSetCaseLoad() {
        assertThrows(IllegalArgumentException.class, () -> {
                member1.setCaseLoad(-1);
    });
}

    @Test 
    void validChangeLoad() {
        roster.changeLoad(member2, 3);
        assertEquals(3, member2.getCaseLoad());
    }

    @Test 
    void validFindById() {
        assertEquals(member3, roster.findById("S003"));
    }

    @Test 
    void invalidFindById() {
        assertNull(roster.findById("S010"));
    }

    @Test 
    void validAssignTreatment() {
        roster.changeLoad(member3, 1);
        assertEquals(member4, roster.assignTreatment("P001", "X-ray", "2026-11-23 9:35", Seniority.NURSE));
    }

    @Test 
    void validSize() {
        assertEquals(5, roster.size());
    }

}
