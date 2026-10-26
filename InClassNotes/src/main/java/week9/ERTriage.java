package week9;

class Patient {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public int getSeverity() {
        return this.severity;
    }

    @Override
    public String toString() {
        return name + "(" + severity + ")";
    }
}

class HeapPQ {
    private Patient[] heap;
    private int lastIndex = -1;

    HeapPQ(int capacity) {
        heap = new Patient[capacity];
    }

    boolean isEmpty() {
        return lastIndex == -1;
    }

    private void swap(int a, int b) {
        Patient temp1;
        temp1 = heap[a];
        heap[a] = heap[b];
        heap[b] = temp1;
    }

    // TODO Round 1: insert p in the next open slot, then restore the max-heap.
    void enqueue(Patient p) {
        lastIndex++;
        heap[lastIndex] = p;
        reheapUp(lastIndex);
    } 

    // TODO Round 1: swap upward while a patient's severity is greater than its parent's.
    // Parent of i: (i - 1) / 2
    private void reheapUp(int i) {

        int x = heap[i].getSeverity() - (heap[(i-1)/2].getSeverity());

        while(x > 0) {
            swap(i, (i-1) / 2);
            i = (i-1) / 2;
            x = heap[i].getSeverity() - (heap[(i-1)/2].getSeverity());
        }

    }

    // TODO Round 2: save the root, move the last patient to the root, shrink, and restore the heap.
    Patient dequeue() {
        Patient top = heap[0];
        heap[0] = heap[lastIndex];
        heap[lastIndex] = null;
        lastIndex--;
        reheapDown(0);
        return top;
    }

    // TODO Round 2: swap down with the larger child while the max-heap property is broken.
    // Children of i: 2 * i + 1 and 2 * i + 2
    private void reheapDown(int i) {
        int c1 = heap[i*2+1] == null ? -1 : heap[i*2+1].getSeverity();
        int c2 = heap[i*2+2] == null ? -1 : heap[i*2+2].getSeverity();
        int larger;
        boolean c1bigger;
        if (c1 == c2 && c1 == -1) {
            return;
        } else if (c1 > c2) {
            larger = c1;
            c1bigger = true;
        } else {
            larger = c2;
            c1bigger = false;
        }
        if (larger > heap[i].getSeverity()) {
            int index = c1bigger ? i*2+1 : i*2+2;
            swap(i, index);
            reheapDown(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i <= lastIndex; i++) {
            result.append(heap[i]);
            if (i < lastIndex) {
                result.append(", ");
            }
        }
        return result.append("]").toString();
    }
}

/**
 * Week 9 team activity: ER triage with a max-heap priority queue.
 * Work in pairs: one person drives while the other traces the heap and checks
 * the result. Switch roles after Round 1.
 */
public class ERTriage {
    public static void main(String[] args) {
        HeapPQ er = new HeapPQ(20);
        String[] names = {"Ana", "Ben", "Cruz", "Dee", "Eli", "Fay", "Gus", "Hal"};
        int[] severities = {3, 7, 5, 9, 2, 8, 6, 1};

        for (int i = 0; i < names.length; i++) {
            er.enqueue(new Patient(names[i], severities[i]));
        }

        
        System.out.println("CHECKPOINT 1: " + er);
        System.out.println("Treating: " + er.dequeue());
        System.out.println("Treating: " + er.dequeue());
        System.out.println("Ambulance arrives: Ivy(10)");
        er.enqueue(new Patient("Ivy", 10));

        while (!er.isEmpty()) {
            System.out.println("Treating: " + er.dequeue());
        }
    }
}

/* Questions to answer
1. Because we have to add the element at the very bottom of the array, so the only way it can move is then up the heap. You
need to compare it to its parent, and see if it's bigger.
2. Because once you remove the root, you need to replace it with some value, and it is easiest to use the lastIndex you added.
Then, you can run reheapDown to organized it from the top.
3. It must compare with the larger child to maintain the order of the heap. If the child is bigger than the parent, they must swap
in order to keep the highest priority correct.
4. In reheapDown, you have to compare 2 values that either can be null, or actual integer values. Errors can easily happen, and it's
important that you do the comparison correct so that the heap maintains the correct order. This we got wrong because we were having
null issues and had to go back and fix it.
*/
