package assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> extends MyLinkedList<E> {
	private DNode head;
	private DNode tail;
	
	public void add(E element){
		DNode newNode = new DNode();
		newNode.element = element;
		if (this.size == 0){
			this.head = newNode;
			this.tail = newNode;
		}
		else {
			newNode.prev = this.tail;
			this.tail.next = newNode;
			this.tail = this.tail.next;
		}
		this.size++;

	}

	public void clear(){
		DNode newNode = new DNode();

		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public E remove(){
		DNode newNode = new DNode();
		if (this.size == 0){
			throw new IllegalArgumentException("Nothing to remove");
		}
		if (this.size == 1){
			newNode.element = this.tail.element;
			this.head = null;
			this.tail = null;
			this.size--;
			return newNode.element;
		}
		newNode.element = this.tail.element;
		this.tail = this.tail.prev;
		this.tail.next.prev = null;
		this.tail.next = null;
		this.size--;
		return newNode.element;
	}

	public void addFirst(E element) {
		DNode newNode = new DNode();
		newNode.element = element;
		newNode.next = this.head;
		if (head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
		}
		this.size++;
	}

	public void addLast(E element){
		DNode newNode = new DNode();
		newNode.element = element;
		if (this.size ==0){
			this.head = newNode;
			this.tail = newNode;
		}
		newNode.prev = tail;
		this.tail.next = newNode;
		this.tail = tail.next;
		this.size = this.size +1 ;
	}

	public E removeFirst(){
		if (this.size == 0){
			throw new NoSuchElementException("Nothing to remove");
		}
		if (this.size == 1){
			DNode newNode = this.head;
			this.tail=null;
			this.head=null;
			this.size--;
			return newNode.element;
		}
		DNode newNode = new DNode();
		newNode.element = this.head.element;

		this.head.next.prev = null;
		this.head = this.head.next;
		this.size--;
		return newNode.element;
	}

	public E removeLast(){
		DNode newNode = new DNode();
		if (this.size == 0){
			throw new IllegalArgumentException("Nothing to remove");
		}
		if (this.size == 1){
			newNode.element = this.tail.element;
			this.head = null;
			this.tail = null;
			this.size--;
			return newNode.element;
		}
		newNode.element = this.tail.element;
		this.tail = this.tail.prev;
		this.tail.next.prev = null;
		this.tail.next = null;
		this.size--;
		return newNode.element;
	}

	public E peekFirst(){
		if (this.size == 0){
			throw new NoSuchElementException("Nothing to peek");
		}
		DNode newNode = new DNode();
		newNode.element = this.head.element;
		return newNode.element;
	}

	public E peekLast(){
		if (this.size == 0){
			throw new NoSuchElementException("Nothing to peek");
		}
		DNode newNode = new DNode();
		newNode.element = this.tail.element;
		return newNode.element;
	}

	public boolean equals(Object object){
		if ((object instanceof MyDoublyLinkedList)) {

			if (this.size != ((MyDoublyLinkedList<E>) object).size) {
				return false;
			}

			if (this.size == 0 && ((MyDoublyLinkedList<E>) object).size == 0){
				return true;
			}
			Iterator<E> iter1 = (Iterator<E>) ((MyDoublyLinkedList<E>) object).iterator();
			Iterator<E> iter2 = this.iterator();

			while (iter1.hasNext() && iter2.hasNext()) {
				if (!(iter1.next().equals(iter2.next()))) {
					return false;
				}
			}
			if (!(this.peekLast().equals(((MyDoublyLinkedList<E>) object).peekLast()))) {
				return false;
			}
			return true;
		}
		else{
			return false;
		}
	}
	/*
	 * ADD YOUR CODE HERE
	 */

	
	public Iterator<E> iterator() {
		return new DLLIterator();
	}

	private class DNode {
		private E element;
		private DNode next;
		private DNode prev;
	}

	private class DLLIterator implements Iterator<E> {
		DNode curr;

		public DLLIterator() {
			this.curr = head;
		}

		public boolean hasNext() {
			return this.curr != null;
		}

		public E next() {
			if (!this.hasNext())
				throw new NoSuchElementException();

			E element = this.curr.element;
			this.curr = this.curr.next;
			return element;
		}
	}
}
