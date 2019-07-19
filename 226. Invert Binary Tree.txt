Soluton：Recursion

class Solution {
    public TreeNode invertTree(TreeNode root) {
        //end situation
        if (root == null || (root.left == null && root.right == null)){
            return root;
        }
        //recursion
        invertTree(root.left);
        invertTree(root.right);
        //act
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
       
        return root;
       
    }
}
