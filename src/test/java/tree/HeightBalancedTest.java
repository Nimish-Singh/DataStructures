package tree;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HeightBalancedTest {

    private HeightBalanced heightBalanced = new HeightBalanced();

    @Test
    public void shouldReturnTrueForNull() {
        assertTrue(heightBalanced.isBalanced(null));
    }

    @Test
    public void shouldReturnTrueForSingleNode() {
        assertTrue(heightBalanced.isBalanced(new TreeNode(1)));
    }

    @Test
    public void shouldReturnTrueForBalancedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right= new TreeNode(5);
        root.right.left = new TreeNode(6);
        assertTrue(heightBalanced.isBalanced(root));
    }

    @Test
    public void shouldReturnFalseForNonBalancedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        assertFalse(heightBalanced.isBalanced(root));
    }
}