236. Lowest Common Ancestor of a Binary Tree

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // stop condition
        if (root == null || root.val == p.val || root.val == q.val) 
            return root;
        // recursion
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // return 
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}