package tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeastCommonAncestorTest {

    private LeastCommonAncestor lca = new LeastCommonAncestor();

    @Test
    public void shouldReturnNullIfTreeIsNull() {
        assertNull(lca.findLCA(null, 1, 2));
    }

    @Test
    public void shouldNotReturnLCAWhenOneKeyNotPresentInTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        assertNull(lca.findLCA(root, 2, 4));
    }

    @Test
    public void shouldNotReturnLCAWhenBothKeysNotPresentInTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        assertNull(lca.findLCA(root, 20, 30));
    }

    @Test
    public void shouldReturnLCAWhenBothKeysInLeftSubtree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        assertEquals(2, lca.findLCA(root, 2, 4).key);
    }

    @Test
    public void shouldReturnLCAWhenBothKeysInRightSubtree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        assertEquals(3, lca.findLCA(root, 3, 4).key);
    }

    @Test
    public void shouldReturnLCAWhenBothKeysInDifferentSubtrees() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        assertEquals(1, lca.findLCA(root, 3, 4).key);
    }
}