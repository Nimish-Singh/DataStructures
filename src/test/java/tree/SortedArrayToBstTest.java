package tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SortedArrayToBstTest {
    private SortedArrayToBst bst = new SortedArrayToBst();

    @Test
    public void sampleInput1() {
        int[] array = new int[]{-10, -3, 0, 5, 9};
        TreeNode root = bst.sortedArrayToBST(array);

        assertEquals(0, root.key);
        assertEquals(-10, root.left.key);
        assertEquals(5, root.right.key);
        assertEquals(-3, root.left.right.key);
        assertEquals(9, root.right.right.key);
        assertNull(root.left.left);
        assertNull(root.right.left);
    }

    @Test
    public void sampleInput2() {
        int[] array = new int[]{1, 3};
        TreeNode root = bst.sortedArrayToBST(array);

        assertEquals(1, root.key);
        assertEquals(3, root.right.key);
        assertNull(root.left);
    }
}
