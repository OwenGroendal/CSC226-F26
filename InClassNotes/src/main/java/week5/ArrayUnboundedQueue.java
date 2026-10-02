package week5;

import java.util.Arrays;

public class ArrayUnboundedQueue<T> implements QueueInterface<T> {

    T[] list = (T[]) new Object[5];
    int numElements = 0;
    int front = 0;
    int rear = 0;

    @Override
    public void enqueue(T element) {
       if(numElements == list.length) {
            T[] newList = (T[]) new Object[list.length * 2];

             for(int i = 0; i < numElements; i++) {
                 int index = (front + i) % list.length;
                 newList[i] = list[index];
        }

        list = newList;
        front = 0;
        rear = numElements;

       }

       list[rear] = element;
       rear = (rear + 1) % list.length;
       numElements++;

    }

    @Override
    public T dequeue() {
        
         if(isEmpty()) return null;

         T value = list[front];
         list[front] = null;
         front = (front + 1) % list.length;
         numElements--;
         return value;

    }

    @Override
    public boolean isFull() {
       return false;
    }

    @Override
    public boolean isEmpty() {
        if(numElements == 0) return true;
        return false;
}

    public String toString() {

        String result = "[";

        for(int i = 0; i < numElements; i++) {
            int index = (front + i) % list.length;
            result = result + list[index];

            if(i < numElements - 1) {
               result = result + ", ";
            }
        }

        result = result + "]";
        return result;

    }
}