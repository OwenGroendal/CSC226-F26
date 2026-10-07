package medical_action_tracking;

import java.util.Arrays;

//OPTIONAL
//Functionally, both a circular array and linkedqueue do the same thing, as they both
//use FIFO for a queue. However, the main difference is how they store and track the data.
//Linked queues use nodes that point to the next object that stores the data.
//Also, you can add to a linkedqueue forever without having to do any extra steps
//With a circular array, instead of using nodes, it uses an array to keep track 
//of the values. However, arrays get full. So when it gets full, you have to copy
//the array and double the size. And then, you have to reindex everything so
//front starts at index 0. You have to keep track of the front index, and the rear index at
//all times alongside how many elements are in the array. The circular array is cool in the
//way that even if u get to the last index, if there is space at index 0, the array wraps
//around and keeps the same order. Overall though, the circular array takes a lot more work
//and forces you to write functions to fix/keep track of indexes and update sizes. Using
//a linked queue is a lot easier and doesn't require as much work.

public class CircularArray<T> {
    
    T[] list = (T[]) new Object[5];
    int front = 0;
    int rear = 0;
    int numElements = 0;
   
    public void enqueue(T item) {
        if(numElements == list.length) {
            T[] copy = Arrays.copyOf(list, list.length * 2); 

            for(int i = 0; i < numElements; i++) {
                 int index = (front + i) % list.length;
                 copy[i] = list[index];
        } 

        list = copy;
        front = 0;
        rear = numElements;

    }

       list[rear] = item;
       rear = (rear + 1) % list.length;
       numElements++;
    }


    public T dequeue() {
        
         if(numElements == 0) return null;

         T value = list[front];
         list[front] = null;
         front = (front + 1) % list.length;
         numElements--;

        if(numElements == 0) {
            front = 0;
            rear = 0;
        }

         return value;

    }

}
