package medical_action_tracking;

public class LinkedStack<T> {
    private class Node {
        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
        }
    }

    private Node top;
    private int size;

    public void push(T item) {
        if(item == null) {
            System.out.println("Rejected, can not add null");
            return;
        } 

        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if(!isEmpty()) {
            T value = top.data;
            top = top.next;
            size--;
            return value;
        }
        return null;
    }

    public T peek() {
        if(!isEmpty()) return top.data;
        return null;
    }

    public boolean isEmpty() {
        if(top == null) return true;
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {

        String list = "[";
        Node current = top;
        
        while(current != null) {
            list = list + current.data;

            if(current.next != null) {
                list = list + ", ";
            }
            current = current.next;
        }

        list = list + "]";
        return list;
    }
}
