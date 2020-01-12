package tree;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SymmetricTreeTest {
    private SymmetricTree symmetricTree = new SymmetricTree();

    @Test
    public void shouldReturnTrueForNullTree() {
        assertTrue(symmetricTree.isSymmetric(null));
    }

    @Test
    public void shouldReturnTrueForSingleNodeTree() {
        assertTrue(symmetricTree.isSymmetric(new TreeNode(1)));
    }

    @Test
    public void shouldReturnTrueForSymmetricTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        assertTrue(symmetricTree.isSymmetric(root));
    }

    @Test
    public void shouldReturnFalseForAsymmetricTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        assertFalse(symmetricTree.isSymmetric(root));
    }
}