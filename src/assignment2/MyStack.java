
package assignment2;

import java.util.NoSuchElementException;

public class MyStack<E> {
    private MyDoublyLinkedList<E> MDLL;

    public MyStack(){
        this.MDLL = new MyDoublyLinkedList();
    }

    public void push(E element){
        this.MDLL.addFirst(element);
    }

    public E pop(){
        if (this.MDLL.size == 0){
            throw new NoSuchElementException("Nothing in the stack");
        }
        return this.MDLL.removeFirst();
    }

    public E peek(){
        if (this.MDLL.size == 0){
            throw new NoSuchElementException("Nothing in the stack");
        }
        return this.MDLL.peekFirst();
    }

    public boolean isEmpty(){
        return this.MDLL.isEmpty();
    }

    public void clear(){
        this.MDLL.clear();
    }

    public int getSize(){
        return this.MDLL.getSize();
    }

}
