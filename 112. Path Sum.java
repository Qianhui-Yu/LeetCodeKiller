112. Path Sum
1. recursion
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        boolean res = false;
        // stop 
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        else {
            res = hasPathSum(root.left, sum - root.val);
            if (res) return true;
            res = hasPathSum(root.right, sum - root.val);
        }
        
        return res;
    }
}
2. iterative