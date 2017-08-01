package trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node<T> {
   T data = null;
   List<Node<T>> children = new ArrayList<Node<T>>();
   Node<T> parent = null;
   
   Node(T data) {
	   this.data = data;
   }
   Node(T data, Node<T> parent) {
	   this.data = data;
	   this.parent = parent;
   }
}

public class Tree<T> {
	private Node<T> root;
	Tree(){
		root = null;
	}
	public Node<T> addNode(T data, Node<T> parent) {
		Node<T> newNode = new Node<T>(data,parent);
		if(root == null) {
			this.root = newNode;
		} else {
			parent.children.add(newNode);
		} 
		return newNode;
	}
	public Node<T> DFS(Node<T> current, Node<T> findNode) { 
		if(current == null) return null;
		if(current == findNode) return current;
		for(int i=0; i<current.children.size(); i++) {
			Node<T> tempResult = DFS(current.children.get(i), findNode);
			if(tempResult != null) return tempResult;
		}
		return null;
	}
	public void printTree(){
		Queue<Node<T>> parent = new LinkedList<Node<T>>();
		parent.add(root);
		Node<T> current = null;
		while(!parent.isEmpty()) {
			current = parent.remove();
			for(int i=0; i<current.children.size(); i++) {
				parent.add(current.children.get(i));
				System.out.print(current.children.get(i).data + " ");
			}
			System.out.println(" ");
		}
	}
}