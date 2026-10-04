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
        // TODO: Remove and return the front item, or return null if empty.
        // TODO: When removing the last item, make both front and rear null.
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
        // TODO: Recursively build a string from front to rear without changing the queue.
        return "[]";
    }

    private void appendNodesRecursively(Node current, StringBuilder result) {
        // TODO: Add the current node's data, then recursively visit current.next.
        // TODO: Stop at the null-node base case.
    }
}
