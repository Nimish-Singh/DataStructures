package tree;

public class IdenticalTrees {
    boolean areIdentical(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.key == node2.key && areIdentical(node1.left, node2.left) && areIdentical(node1.right, node2.right);
    }
}
