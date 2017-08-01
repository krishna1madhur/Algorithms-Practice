package trie;
import java.util.*;

public class Trie {
	private TrieNode root;
	Trie() {
		root = new TrieNode();
	}
	public void insertWord(String word) {
		HashMap<Character, TrieNode> children = root.children;
		TrieNode current = root;
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			children = current.children;
			TrieNode newNode;
			if(children.containsKey(c)) {
				current = children.get(c);
			} else {
				newNode = new TrieNode(c);
				children.put(c,newNode);
				current = children.get(c);
			}
			if(i== (word.length()-1) ){
				current.isLeaf = true;
			}
		}
	}
	public void search(String word) {
		HashMap<Character, TrieNode> children = null;
		TrieNode current = root;
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			children = current.children;
			if(children.containsKey(c)){
				current = children.get(c);
				System.out.println("Node: " + c);
			} else {
				System.out.println("Word not found in the trie");
				return;
			}
			if(current.isLeaf == true){
				if(i == word.length()-1){
					System.out.println("The entire word is found");
				}
			}
		}
	}
}

class TrieNode {
	Character character;
	HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	boolean isLeaf = false;
	public TrieNode() {}
	public TrieNode(char character) {
		this.character = character;
	}
}
