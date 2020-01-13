package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Traversal {
    List<Integer> iterativePreorder(TreeNode node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<Integer> output = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);

        while (!stack.isEmpty()) {
            TreeNode poppedNode = stack.pop();
            output.add(poppedNode.key);
            if (poppedNode.right != null) {
                stack.push(poppedNode.right);
            }
            if (poppedNode.left != null) {
                stack.push(poppedNode.left);
            }
        }
        return output;
    }

    List<Integer> iterativeInorder(TreeNode node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<Integer> output = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode iterator = node;

        while (!stack.isEmpty() || iterator != null) {
            while (iterator != null) {
                stack.push(iterator);
                iterator = iterator.left;
            }
            TreeNode poppedNode = stack.pop();
            output.add(poppedNode.key);
            iterator = poppedNode.right;
        }
        return output;
    }

    List<Integer> iterativePostorder(TreeNode node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<Integer> output = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        TreeNode previous = null;

        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();
            if (previous == null || previous.left == current || previous.right == current) {
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                } else {
                    stack.pop();
                    output.add(current.key);
                }
            } else if (current.left == previous) {
                if (current.right != null) {
                    stack.push(current.right);
                } else {
                    stack.pop();
                    output.add(current.key);
                }
            } else if (current.right == previous) {
                stack.pop();
                output.add(current.key);
            }
            previous = current;
        }
        return output;
    }
}
