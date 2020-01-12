package tree;

public class SymmetricTree {
    boolean isSymmetric(TreeNode node) {
        if (node == null) {
            return true;
        }
        return areTreesMirrorImages(node.left, node.right);
    }

    private boolean areTreesMirrorImages(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.key == root2.key
                && areTreesMirrorImages(root1.left, root2.right) && areTreesMirrorImages(root1.right, root2.left);
    }
}
