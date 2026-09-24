package week4;

import java.util.ArrayList;

public class LinkedListExamples {
    public static void main(String[] args){
        LinkedStack<String> stack = new LinkedStack<>();
        LLNode<String> head = new LLNode<>("First");
        head.setNext(new LLNode<>("Second"));
        head.getNext().setNext(new LLNode<>("Third"));
        head.getNext().getNext().setNext(new LLNode<>("Fourth"));

        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        stack.push("Fourth");
        stack.push("Fifth");
        stack.push("Sixth");
        System.out.println("Is Full: " + stack.isFull());
        System.out.println("The top value: " + stack.top());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("The top value after 4 pops: " + stack.top());
        System.out.println("Is Empty: " + stack.isEmpty());
        stack.pop();
        stack.pop();
        System.out.println("Is Empty after 2 more pops: " + stack.isEmpty());

        System.out.println("Original order: ");
        displayWithPositions(head);

        LLNode<String> newList = removeElement(head, "Second");
        System.out.println("After removing 'Second': ");
        displayWithPositions(newList);

        LLNode<String> newHead = removeAllElements(head);
        System.out.println("After removing all elements: ");
        displayWithPositions(newHead);

        LLNode<String> copyHead = copyList(head);
        System.out.println("After copying list: ");
        displayWithPositions(copyHead);

        boolean answer = contains(head, "Fourth");
        System.out.println("Finding target 'Fourth': " + answer);

        int length = getLength(head);
        System.out.println("Length of linked list: " + length);

        ArrayList<String> convertedList = toArrayList(head);
        System.out.println("Converts to array list: ");
        for(int i = 0; i < convertedList.size(); i++) {
            System.out.println(convertedList.get(i));
        }

        String valueElement = getElementAt(head, 2);
        System.out.println("Get element at position 2: " + valueElement);
            
    }
    
    public static <T> void displayWithPositions(LLNode<T> head) {
        int position = 0;
        LLNode<T> current = head;

        while(current != null) {
            System.out.println("Position " + position + ": " + current.getInfo());
            current = current.getNext();
            position++;
        }
        
    }
    
    public static <T> LLNode<T> removeElement(LLNode<T> head, T target) {

        if(head == null) return null;

        if(head.getInfo().equals(target)) return head.getNext();

        LLNode<T> current = head;

        while(current.getNext() != null) {

            if(current.getNext().getInfo().equals(target)) {
                current.setNext(current.getNext().getNext());
                return head;
            }
            current = current.getNext();
        }
        return head; 
    }
    
    public static <T> LLNode<T> removeAllElements(LLNode<T> head) {

        while(head != null) {
            head = head.getNext();
        }
        return head; 
    }
    
    public static <T> LLNode<T> copyList(LLNode<T> original) {

        if(original == null) return null;

        LLNode<T> newList = new LLNode<>(original.getInfo());
        LLNode<T> currentNew = newList;

        original = original.getNext();

        while(original != null) {
            currentNew.setNext(new LLNode<>(original.getInfo()));
            currentNew = currentNew.getNext();
            original = original.getNext();
        }
        return newList; 
    }
    
    public static <T> boolean contains(LLNode<T> head, T target) {

        if(head == null) return false;

        if(head.getInfo().equals(target)) return true;

        head = head.getNext();

        while(head != null) {
            if(head.getInfo().equals(target)) return true;
            head = head.getNext();
        }
        
        return false; 
    }
    
    public static <T> int getLength(LLNode<T> head) {

        int length = 0;

        while(head != null) {
            length++;
            head = head.getNext();
        }
        
        return length; 
    }

    public static <T> ArrayList<T> toArrayList(LLNode<T> head) {

        if(head == null) return new ArrayList<T>();

        ArrayList<T> convertedList = new ArrayList<T>();

        while(head != null) {
            convertedList.add(head.getInfo());
            head = head.getNext();
        }
        return convertedList;
    }
        
    public static <T> T getElementAt(LLNode<T> head, int position) {

        if(head == null) return null;

        int counter = 0;

        while(head != null) {
            if(counter == position) return head.getInfo();
            head = head.getNext();
            counter++;
        }
        return null; 
    }
}
