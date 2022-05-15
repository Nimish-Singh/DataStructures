package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-right-side-view/
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        Deque<TreeNode> dQueue = new LinkedList<>();
        List<Integer> rightSideView = new ArrayList<>();
        dQueue.add(root);

        while (!dQueue.isEmpty()) {
            TreeNode lastNodeAtThisLevel = dQueue.peekLast();
            int nodesAtThisLevel = dQueue.size();
            rightSideView.add(lastNodeAtThisLevel.key);

            for (int nodesProcessed = 0; nodesProcessed < nodesAtThisLevel; nodesProcessed++) {
                TreeNode node = dQueue.pollFirst();
                if (node.left != null) dQueue.addLast(node.left);
                if (node.right != null) dQueue.addLast(node.right);
            }
        }
        return rightSideView;
    }
}
