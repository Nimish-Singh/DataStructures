package tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeightTest {
    private Height height = new Height();

    @Test
    public void sampleInput1() {
        assertEquals(0, height.maxDepth(null));
    }

    @Test
    public void sampleInput2() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        assertEquals(2, height.maxDepth(root));
    }

    @Test
    public void sampleInput3() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        assertEquals(3, height.maxDepth(root));
    }
}
