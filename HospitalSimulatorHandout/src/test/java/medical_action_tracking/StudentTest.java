package medical_action_tracking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import patient_intake.Patient;

public class StudentTest {
    
    @Test
    void testDequeueReturnNullCircularArray() {
        CircularArray<String> queue = new CircularArray<>();
        String value = queue.dequeue();
        assertNull(value);
    }

    @Test
    void testDequeueReturnValueCircularArray() {
        CircularArray<String> queue = new CircularArray<>();
        queue.enqueue("Cat");
        queue.enqueue("Dog");
        queue.enqueue("Penguin");

        String value = queue.dequeue();
        assertEquals("Cat", value);
    }

    @Test 
    void testAddPatient() {

        EmergencyWaitingRoom room = new EmergencyWaitingRoom();

        Patient newPatient = new Patient("P001", "Abby", "Rora", 
        32,"Migraine", 2, "Waiting",
        "ER-001", 9, "INS-001");

        boolean answer = room.addPatient(newPatient);

        assertEquals(true, answer);
    }

    @Test 
    void testAddNullPatient() {
        EmergencyWaitingRoom room = new EmergencyWaitingRoom();
        boolean answer = room.addPatient(null);
        assertEquals(false, answer);
    }

    @Test
    void testCountNodesRecursively() {

        LinkedQueue<String> queue = new LinkedQueue<>();

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");

        int value = queue.countNodesRecursively();

        assertEquals(4, value);
        assertEquals(4, queue.size());
    }

    @Test
    void testCountNodesRecursivelyWhenEmpty() {
        LinkedQueue<String> queue = new LinkedQueue<>();
        int value = queue.countNodesRecursively();
        assertEquals(0, value);
    }
}
