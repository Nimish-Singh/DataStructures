package tree;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IdenticalTreesTest {
    private IdenticalTrees identicalTrees = new IdenticalTrees();

    @Test
    public void shouldReturnTrueForNullTrees() {
        assertTrue(identicalTrees.areIdentical(null, null));
    }

    @Test
    public void shouldReturnFalseForNullAndNotNullTrees() {
        assertFalse(identicalTrees.areIdentical(null, new TreeNode(1)));
    }

    @Test
    public void shouldReturnFalseForNonIdenticalTrees() {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);

        assertFalse(identicalTrees.areIdentical(root1, root2));
    }

    @Test
    public void shouldReturnTrueForIdenticalLeftSkewedTrees() {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);

        assertTrue(identicalTrees.areIdentical(root1, root2));
    }

    @Test
    public void shouldReturnTrueForIdenticalRightSkewedTrees() {
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);

        assertTrue(identicalTrees.areIdentical(root1, root2));
    }

    @Test
    public void shouldReturnTrueForIdenticalTrees() {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);

        assertTrue(identicalTrees.areIdentical(root1, root2));
    }
}