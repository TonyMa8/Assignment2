package assignment2;

import java.util.NoSuchElementException;

public class MyQueue<E> {
    private MyDoublyLinkedList<E> MDLL;

    public MyQueue(){
        this.MDLL = new MyDoublyLinkedList();
    }

    public void enqueue(E element){
        this.MDLL.addLast(element);
    }

    public E dequeue(){
        if (this.MDLL.size == 0){
            throw new NoSuchElementException();
        }
        return this.MDLL.removeFirst();
    }
    public boolean isEmpty(){
        return this.MDLL.isEmpty();
    }

    public void clear(){
        this.MDLL.clear();
    }

    public boolean equals(Object object){
       if (!(object instanceof MyQueue<?>)){
           return false;
       }
       return this.MDLL.equals(((MyQueue<E>) object).MDLL);
    }
}
