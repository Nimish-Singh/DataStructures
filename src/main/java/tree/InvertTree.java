package tree;

public class InvertTree {
    TreeNode invert(TreeNode node) {
        if (node == null) {
            return node;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        invert(node.left);
        invert(node.right);
        return node;
    }
}
