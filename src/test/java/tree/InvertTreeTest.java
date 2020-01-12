package tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class InvertTreeTest {
    private InvertTree invertTree = new InvertTree();

    @Test
    public void shouldInvertNullTree() {
        assertNull(invertTree.invert(null));
    }

    @Test
    public void shouldInvertSingleNodeTree() {
        assertEquals(1, invertTree.invert(new TreeNode(1)).key);
    }

    @Test
    public void shouldInvertBalancedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        TreeNode invertedTree = invertTree.invert(root);

        assertEquals(1, invertedTree.key);
        assertEquals(3, invertedTree.left.key);
        assertNull(invertedTree.left.left);
        assertEquals(5, invertedTree.left.right.key);
        assertEquals(2, invertedTree.right.key);
        assertNull(invertedTree.right.left);
        assertEquals(4, invertedTree.right.right.key);
    }

    @Test
    public void shouldBalanceUnbalancedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        TreeNode invertedTree = invertTree.invert(root);

        assertEquals(1, invertedTree.key);
        assertNull(invertedTree.left);
        assertEquals(2, invertedTree.right.key);
        assertNull(invertedTree.right.left);
        assertEquals(3, invertedTree.right.right.key);
        assertNull(invertedTree.right.right.left);
        assertEquals(4, invertedTree.right.right.right.key);
    }
}