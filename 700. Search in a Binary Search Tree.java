700. Search in a Binary Search Tree

1. recursive
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        // stop condition
        if (root == null) return null;
        // recursion
        if (root.val == val) return root;
        else if (root.val > val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
        
        //return null;
    }
}

2. iterative
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val)
                return root;
            else if (root.val > val)
                root = root.left;
            else 
                root = root.right;
        }
        
        return root;
    }
}