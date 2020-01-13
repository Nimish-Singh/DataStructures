package tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TraversalTest {
    private Traversal traversal = new Traversal();
    private TreeNode root;

    @Before
    public void setUp() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
    }

    @Test
    public void shouldReturnPreorderTraversal() {
        Integer[] expectedOutput = {1, 2, 4, 5, 7, 3, 6};
        assertArrayEquals(expectedOutput, traversal.iterativePreorder(root).toArray());
    }

    @Test
    public void shouldReturnInorderTraversal() {
        Integer[] expectedOutput = {4, 2, 5, 7, 1, 6, 3};
        assertArrayEquals(expectedOutput, traversal.iterativeInorder(root).toArray());
    }

    @Test
    public void shouldReturnPostorderTraversal() {
        Integer[] expectedOutput = {4, 7, 5, 2, 6, 3, 1};
        assertArrayEquals(expectedOutput, traversal.iterativePostorder(root).toArray());
    }
}