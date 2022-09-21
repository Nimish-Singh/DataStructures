package tree;

// https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
public class StepByStepDirections {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue);
        StringBuilder sourcePath = new StringBuilder();
        getPathToNode(lca, startValue, sourcePath);
        for (int index = 0; index < sourcePath.length(); index++) {
            sourcePath.replace(index, index + 1, "U");
        }

        StringBuilder destinationPath = new StringBuilder();
        getPathToNode(lca, destValue, destinationPath);

        return String.valueOf(sourcePath.append(destinationPath));
    }

    private TreeNode getPathToNode(TreeNode root, int value, StringBuilder path) {
        if (root == null)
            return null;

        if (root.key == value)
            return root;

        path.append("L");
        TreeNode pathInLeftSubtree = getPathToNode(root.left, value, path);
        if (pathInLeftSubtree != null)
            return pathInLeftSubtree;

        path.replace(path.length() - 1, path.length(), "R");
        TreeNode pathInRightSubtree = getPathToNode(root.right, value, path);
        if (pathInRightSubtree != null)
            return pathInRightSubtree;

        path.deleteCharAt(path.length() - 1);
        return null;
    }

    private TreeNode findLCA(TreeNode root, int value1, int value2) {
        if (root == null)
            return null;

        if (root.key == value1 || root.key == value2)
            return root;

        TreeNode valueInLeftSubtree = findLCA(root.left, value1, value2);
        TreeNode valueInRightSubtree = findLCA(root.right, value1, value2);

        if (valueInLeftSubtree != null && valueInRightSubtree != null)
            return root;

        return valueInLeftSubtree == null ? valueInRightSubtree : valueInLeftSubtree;
    }
}
