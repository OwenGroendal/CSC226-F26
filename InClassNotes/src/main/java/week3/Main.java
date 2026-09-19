package week3;

public class Main {

    public static void main(String args[]) {

        ArrayBoundedStack<Integer> elements = new ArrayBoundedStack<>(5);

        elements.push(1);
        elements.push(2);

        if(elements.isFull()) System.out.println("The stack is full (After adding 2 elements)");
        else System.out.println("The stack is not full (After adding 2 elements)");

        elements.push(3);
        elements.push(4);
        elements.push(5);

        if(elements.isFull()) System.out.println("The stack is full (After adding 5 elements)");
        else System.out.println("The stack is not full (After adding 5 elements)");

        while(!elements.isEmpty()) {
            System.out.println(elements.top());
            elements.pop();
        }

        if(elements.isEmpty()) System.out.println("The stack is empty");
        else System.out.println("The stack is not empty");

        System.out.println(elements.top());
        elements.pop();

    }//end of main
}//end of class