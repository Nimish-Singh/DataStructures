package tree;

public class HeightBalanced {

    public boolean isBalanced(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean isLeftSubtreeBalanced = isBalanced(node.left);
        boolean isRightSubtreeBalanced = isBalanced(node.right);
        int heightDifferenceOfSubtrees = Math.abs(height(node.left) - height(node.right));

        return isLeftSubtreeBalanced && isRightSubtreeBalanced && heightDifferenceOfSubtrees <= 1;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
