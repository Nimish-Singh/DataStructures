package tree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RightSideViewTest {
    private RightSideView rsv = new RightSideView();

    @Test
    public void sampleInput1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        List<Integer> view = rsv.rightSideView(root);

        assertEquals(3, view.size());
        assertArrayEquals(new int[]{1, 3, 4}, view.stream().mapToInt(x -> x).toArray());
    }

    @Test
    public void sampleInput2() {
        assertTrue(rsv.rightSideView(null).isEmpty());
    }

    @Test
    public void sampleInput3() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);

        List<Integer> view = rsv.rightSideView(root);

        assertEquals(2, view.size());
        assertArrayEquals(new int[]{1, 3}, view.stream().mapToInt(x -> x).toArray());
    }

    @Test
    public void sampleInput4() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);

        List<Integer> view = rsv.rightSideView(root);

        assertEquals(4, view.size());
        assertArrayEquals(new int[]{1, 3, 4, 5}, view.stream().mapToInt(x -> x).toArray());
    }
}
