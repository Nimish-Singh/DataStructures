package tree;

public class PathSum {
    Boolean doesPathExistForSum(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }

        if (node.left == null && node.right == null) {
            return node.key == sum;
        }

        return doesPathExistForSum(node.left, sum - node.key) || doesPathExistForSum(node.right, sum - node.key);
    }
}
