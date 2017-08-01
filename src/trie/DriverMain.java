package trie;

public class DriverMain {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insertWord("krishna");
		trie.insertWord("kitty");
		trie.search("krishna");
		trie.search("kitt");
	}
}
