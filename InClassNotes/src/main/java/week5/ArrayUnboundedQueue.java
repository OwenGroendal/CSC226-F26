package week5;

import java.util.Arrays;

public class ArrayUnboundedQueue<T> implements QueueInterface<T> {

    T[] list = (T[]) new Object[15];
    int numElements = 0;

    @Override
    public void enqueue(T element) {
       if(numElements == list.length) {
            list = Arrays.copyOf(list, list.length * 2);
       }

       list[numElements] = element;
       numElements++;

    }

    @Override
    public T dequeue() {
        
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