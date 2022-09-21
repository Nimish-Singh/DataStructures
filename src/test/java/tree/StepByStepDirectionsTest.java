package tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StepByStepDirectionsTest {
    private final StepByStepDirections directions = new StepByStepDirections();
    private TreeNode root;

    @Test
    public void sampleInput1() {
        root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);

        assertEquals("UURL", directions.getDirections(root, 3, 6));
    }

    @Test
    public void sampleInput2() {
        root = new TreeNode(2);
        root.left = new TreeNode(1);

        assertEquals("L", directions.getDirections(root, 2, 1));
    }
}
