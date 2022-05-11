package tree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LevelOrderTraversalTest {
    private LevelOrderTraversal lot = new LevelOrderTraversal();

    @Test
    public void sampleInput1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> traversal = lot.levelOrderBottom(root);

        assertEquals(3, traversal.size());
        assertArrayEquals(new int[] {15, 7}, traversal.get(0).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[] {9, 20}, traversal.get(1).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[] {3}, traversal.get(2).stream().mapToInt(x -> x).toArray());
    }

    @Test
    public void sampleInput2() {
        TreeNode root = new TreeNode(1);
        List<List<Integer>> traversal = lot.levelOrderBottom(root);

        assertEquals(1, traversal.size());
        assertArrayEquals(new int[] {1}, traversal.get(0).stream().mapToInt(x -> x).toArray());
    }

    @Test
    public void sampleInput3() {
        List<List<Integer>> traversal = lot.levelOrderBottom(null);
        assertEquals(0, traversal.size());
    }
}
