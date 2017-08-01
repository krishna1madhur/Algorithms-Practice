package trees;

import java.util.List;

public class DriverMain {
	public static void main(String[] args) {
		Tree<String> tree1 = new Tree<String>();
		Node<String> root = tree1.addNode("Krishna", null);
		Node<String> spoorthi = tree1.addNode("Spoorthi", root);
		Node<String> sravya = tree1.addNode("Sravya", root);
		Node<String> murali = tree1.addNode("Murali", root);
		Node<String> dilip = tree1.addNode("Dilip", root);
		Node<String> atlanta = tree1.addNode("Atlanta", murali);
		Node<String> chicago = tree1.addNode("Chicago", sravya);
		
		tree1.printTree();
		Node<String> foundNode = tree1.DFS(root, atlanta);
		if(foundNode == null) return;
		System.out.println(foundNode.data +" " +foundNode.parent.data);
	}
}
