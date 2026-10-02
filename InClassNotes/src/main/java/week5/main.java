package week5;

public class main {
    public static void main(String[] args) {

         ArrayUnboundedQueue<String> queue = new ArrayUnboundedQueue<>();

        System.out.println("Is empty: " + queue.isEmpty());

        String answer = queue.dequeue();
        System.out.println("Empty and did dequeue " + answer);
    
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.enqueue("E");

        System.out.println(queue.toString());

        System.out.println("Is empty: " + queue.isEmpty());
        System.out.println("Is full: " + queue.isFull());

        answer = queue.dequeue();
        System.out.println("Removed: " + answer);
        queue.dequeue();

        System.out.println(queue.toString());
        queue.enqueue("F");
        queue.enqueue("G");
        queue.enqueue("H");
        queue.enqueue("I");

        System.out.println(queue.toString());
        


    }
    
}
