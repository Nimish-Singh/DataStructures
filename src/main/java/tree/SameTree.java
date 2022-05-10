package tree;

// https://leetcode.com/problems/same-tree/
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        return p.key == q.key && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
