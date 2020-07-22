105. Construct Binary Tree from Preorder and Inorder Traversal

1. recursive
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0, 0, inorder.length - 1, preorder, inorder);
    }
    
    public TreeNode build(int preRoot, int inStart, int inEnd, int[] preorder, int[] inorder) {
        // stop condition
        if (preRoot > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preRoot]);
        int inRoot = 0;
        for (int i = inStart; i <= inEnd; ++i) {
            if (root.val == inorder[i]) {
                inRoot = i;
            }
        }
        
        root.left = build(preRoot + 1, inStart, inRoot - 1, preorder, inorder);
        root.right = build(preRoot + 1 + inRoot - inStart, inRoot + 1, inEnd, preorder, inorder);
        return root;   
    }
}

2. recursive with hashmap O(N)
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        
        for (int i = 0; i < inorder.length; ++i) {
            inMap.put(inorder[i], i);
        }
        
        return build(0, 0, inorder.length - 1, preorder, inorder, inMap);
    }
    
    public TreeNode build(int preRoot, int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> inMap) {
        // stop condition
        if (preRoot > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preRoot]);
        int inRoot = inMap.get(root.val);
        
        root.left = build(preRoot + 1, inStart, inRoot - 1, preorder, inorder, inMap);
        root.right = build(preRoot + 1 + inRoot - inStart, inRoot + 1, inEnd, preorder, inorder, inMap);
        return root;   
    }
}

