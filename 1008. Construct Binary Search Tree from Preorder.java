1008. Construct Binary Search Tree from Preorder Traversal

1. recursive
class Solution {
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode head = bst(preorder, Integer.MAX_VALUE);
        return head;
    }
    
    public TreeNode bst(int[] preorder, int parent) {
        // stop
        if (i == preorder.length || preorder[i] > parent) return null;
        TreeNode head = new TreeNode(preorder[i++]);
        head.left = bst(preorder, head.val);
        head.right = bst(preorder, parent);
        return head;
    }

}