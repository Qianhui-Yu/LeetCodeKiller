235. Lowest Common Ancestor of a Binary Search Tree

class Solution {
    TreeNode res;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // stop condition
        if (root.val == p.val) return p;
        if (root.val == q.val) return q;
        
        // recursion
        if (p.val < root.val && q.val < root.val) {
            res = lowestCommonAncestor(root.left, p, q);
        }
        else if (p.val >root.val && q.val > root.val) {
            res = lowestCommonAncestor(root.right, p, q);
        }
        else 
            res = root;
        
        return res;
    }
}