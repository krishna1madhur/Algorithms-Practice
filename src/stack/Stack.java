package stack;

public class Stack<T>{
	private Node<T> top;
	int capacity;
	Stack(int capacity){
		this.capacity = capacity;
	}
	public boolean isFull() {
		if(capacity == 0) return true;
		return false;
	}
	public boolean isEmpty(){
		if(top == null) return true;
		return false;
	}
	public void push(T data) {
		Node<T> newNode = new Node<T>(data);
		if(isEmpty()) {
			top = newNode;
			top.next = null;
			capacity--;
			return;
		}
		if(isFull()) {
			System.out.println("Cannot add the element. Stack is full");
		}
		Node<T> current = top;
		newNode.next = current;
		top = newNode;
		capacity--;
	}
	
	public T pop(){
		if(isEmpty()) {
			System.out.println("The stack is Empty");
			return null;
		}
		T result = top.data;
		top = top.next;
		capacity++;
		return result;
	}
	
	public void printElements(){
		Node<T> current = top;
		if(isEmpty()) System.out.println("Unable to delete, stack is Empty");
		while(current != null){
			System.out.println(String.valueOf(current.data));
			current = current.next;
		}
	}
}
class Node<T> {
	T data;
	Node<T> next;
	Node(T data) {
		this.data = data;
		this.next = null;
	}
}
