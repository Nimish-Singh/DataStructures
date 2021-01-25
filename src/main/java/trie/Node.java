package trie;

public class Node {
    private static int ALPHABET_SIZE = 26;

    boolean isEndOfWord;
    Node[] children;

    Node() {
        isEndOfWord = false;
        children = new Node[ALPHABET_SIZE];
    }
}
