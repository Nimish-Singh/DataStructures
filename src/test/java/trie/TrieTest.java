package trie;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TrieTest {
    private Trie trie = new Trie();

    @Test
    public void shouldAddWord() {
        trie.addWord("apple");
        assertTrue(trie.search("apple"));
    }

    @Test
    public void shouldReturnCaseInseneitiveMatch() {
        trie.addWord("apple");
        assertTrue(trie.search("ApPlE"));
    }

    @Test
    public void shouldReturnFalseIfWordNotFound() {
        trie.addWord("Apple");
        assertFalse(trie.search("ball"));
    }

    @Test
    public void shouldNotReturnAMatchForOnlySubstringOfWord() {
        trie.addWord("apple");
        assertFalse(trie.search("app"));
    }
}
