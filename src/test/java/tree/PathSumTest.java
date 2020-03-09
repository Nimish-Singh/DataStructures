package tree;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class PathSumTest {
    private PathSum pathSum = new PathSum();

    @Test
    public void shouldReturnFalseIfTreeIsNull() {
        assertFalse(pathSum.doesPathExistForSum(null, 4));
    }

    @Test
    public void shouldReturnTrueIfRootHasSum() {
        assertTrue(pathSum.doesPathExistForSum(new TreeNode(5), 5));
    }

    @Test
    public void shouldReturnTrueIfPathExists() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        assertTrue(pathSum.doesPathExistForSum(root, 22));
    }

    @Test
    public void shouldReturnFalseIfPathDoesNotExist() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(4);
        assertFalse(pathSum.doesPathExistForSum(root, 50));
    }
}