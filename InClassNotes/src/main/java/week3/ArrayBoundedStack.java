package week3;

public class ArrayBoundedStack<T> implements StackInterface<T> {
    private final int DEFAULTCAP = 100;
    private T[] elements;
    private int topIndex=-1;

    public ArrayBoundedStack(){
        elements = (T[]) new Object[DEFAULTCAP];
    }
    public ArrayBoundedStack(int maxSize){
        elements = (T[]) new Object[maxSize];
    }
    public boolean isEmpty()
    {
        if(topIndex == -1) return true;
        return false;
    }

    public boolean isFull()
    {
        if(elements[elements.length-1] != null) return true;
        return false;
    }
    
    public void push(T element)
    {
       if(!isFull()) {
        topIndex++;
        elements[topIndex] = element;
       }
    }
    
    public void pop()
    {
        if(!isEmpty()) {
            elements[topIndex] = null;
            topIndex--;
        }

        else System.out.println("Nothing to pop, stack is empty");
    }
    
    public T top() {
      if(!isEmpty()) return elements[topIndex];
      return null;
    }
}