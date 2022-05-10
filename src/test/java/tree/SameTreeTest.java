package tree;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SameTreeTest {
    private SameTree sameTree = new SameTree();

    @Test
    public void shouldReturnTrueForNullTrees() {
        assertTrue(sameTree.isSameTree(null, null));
    }

    @Test
    public void shouldReturnFalseIfOneTreeIsNotNull() {
        TreeNode root = new TreeNode(4);
        assertFalse(sameTree.isSameTree(root, null));
        assertFalse(sameTree.isSameTree(null, root));
    }

    @Test
    public void sampleInput1() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        assertTrue(sameTree.isSameTree(p, q));
    }

    @Test
    public void sampleInput2() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);

        assertFalse(sameTree.isSameTree(p, q));
    }

    @Test
    public void sampleInput3() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(1);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);

        assertFalse(sameTree.isSameTree(p, q));
    }
}
