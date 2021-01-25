package trie;

public class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void addWord(String word) {
        word = word.toLowerCase();
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            int index = translateToArrayIndex(word.charAt(i));
            if (temp.children[index] == null) {
                temp.children[index] = new Node();
            }
            temp = temp.children[index];
        }
        temp.isEndOfWord = true;
    }

    public boolean search (String word) {
        word = word.toLowerCase();
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            int index = translateToArrayIndex(word.charAt(i));
            if (temp.children[index] == null)
                return false;
            temp = temp.children[index];
        }
        return temp != null && temp.isEndOfWord;
    }

    private int translateToArrayIndex(char x) {
        return (int) x - 'a';
    }
}
