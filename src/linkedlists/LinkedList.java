package linkedlists;

class Node<T> {
	T data;
	Node<T> next;
	Node(T data) {
		this.data = data;
		this.next = null;
	}
	Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
}
public class LinkedList<T> {
	private Node<T> head;
	
	LinkedList(){
		head = null;
	}
	public void insertEnd(T data) {
		Node<T> newNode = new Node<T>(data);
		Node<T> current = head;
		if(isEmpty()) {
			head = newNode;
			return;
		}
		while(current.next != null) {
			current = current.next;
		}
		current.next = newNode;
		newNode.next = null;
	}
	public T removeEnd() {
		Node<T> current = this.head;
		if(isEmpty()) System.out.println("There are no elements in the Linked List");
		if(current.next == null) {
			head = null;
			return current.data;
		} 
		while(current.next.next != null) {
			current = current.next;
		}
		current.next = null;
		return current.data;
	}
	public boolean isEmpty(){
		if(head == null) return true;
		return false;
	}
	public void printList() {
		Node<T> current = this.head;
		if(current == null) return;
		while(current != null) {
			System.out.println(String.valueOf(current.data));
			current = current.next;
		}
	}
}
