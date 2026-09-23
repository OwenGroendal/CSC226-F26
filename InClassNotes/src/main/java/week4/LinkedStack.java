package week4;
import week3.StackInterface;

public class LinkedStack<T> implements StackInterface<T> {
    private LLNode<T> top;

    public LinkedStack(){
        this.top=null;
    }

    public void push(T element){
        LLNode<T> newNode = new LLNode<>(element);
        newNode.next = top;
        top = newNode;
        }

    public void pop(){
       if(!isEmpty()) {
         top = top.next;
       }
   }
    public T top(){
        if(!isEmpty()) return top.info;
        return null;
    }

    public boolean isEmpty(){
        if(top == null) return true;
        return false;
    }
    public boolean isFull(){
        return false; 
    }
}