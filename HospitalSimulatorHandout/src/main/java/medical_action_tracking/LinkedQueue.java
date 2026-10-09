package medical_action_tracking;

public class LinkedQueue<T> {
    private class Node {
        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(T item) {

        if(item == null) throw new IllegalArgumentException("Invalid argument");

        Node newNode = new Node(item);
        if(size == 0) {
            front = newNode;
            rear = newNode;
        }

        else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T dequeue() {
        if(isEmpty()) return null;

        T value = front.data;
        front = front.next;
        size--;

        if(size == 0) {
            front = null;
            rear = null;
        }
        return value;
    }

    public T peekFront() {
        if(isEmpty()) return null;
        return front.data;
    }

    public boolean isEmpty() {
        if(size == 0) return true;
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder value = new StringBuilder("[");
        appendNodesRecursively(front, value);
        value.append("]");
        return value.toString();
    }

    public void appendNodesRecursively(Node current, StringBuilder result) {

        if(current == null) return;

        result.append(current.data);

        if(current.next != null) result.append(", ");

        appendNodesRecursively(current.next, result);
    }

    //OPTIONAL
    //Need to call this function in test because front is private, this starts the recursion
    //Will compare result with size() in studentTest.java
    public int countNodesRecursively() {
         return countNodesRecursively(front);
    }

    public int countNodesRecursively(Node current) {
        if(current == null) return 0;
        return 1 + countNodesRecursively(current.next);
    }
}
