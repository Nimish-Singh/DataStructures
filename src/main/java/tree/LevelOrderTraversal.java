package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<List<Integer>> traversal = new ArrayList<>();
        while (!queue.isEmpty()) {
            int nodesAtThisLevel = queue.size();
            List<Integer> levelTraversal = new ArrayList<>();

            for (int nodesProcessedSoFar = 0; nodesProcessedSoFar < nodesAtThisLevel; nodesProcessedSoFar++) {
                TreeNode node = queue.poll();
                levelTraversal.add(node.key);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            traversal.add(0, levelTraversal);
        }
        return traversal;
    }
}
