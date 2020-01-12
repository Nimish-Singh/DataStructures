package tree;

public class LeastCommonAncestor {
    TreeNode findLCA(TreeNode root, int key1, int key2) {
        return isKeyPresent(root, key1) && isKeyPresent(root, key2) ?
                findLCAWithKeyPresent(root, key1, key2) : null;
    }

    private TreeNode findLCAWithKeyPresent(TreeNode node, int key1, int key2) {
        if (node == null) {
            return null;
        }

        if (node.key == key1 || node.key == key2) {
            return node;
        }

        TreeNode lcaInLeftSubtree = findLCAWithKeyPresent(node.left, key1, key2);
        TreeNode lcaInRightSubtree = findLCAWithKeyPresent(node.right, key1, key2);

        if (lcaInLeftSubtree != null && lcaInRightSubtree != null) {
            return node;
        }
        return lcaInLeftSubtree == null ? lcaInRightSubtree : lcaInLeftSubtree;
    }

    private boolean isKeyPresent(TreeNode node, int key) {
        if (node == null) {
            return false;
        }
        if (node.key == key) {
            return true;
        }
        return isKeyPresent(node.left, key) || isKeyPresent(node.right, key);
    }
}
