94. Binary Tree Inorder Traversal

1. recursive
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }
    
    public void inorder(TreeNode root, List<Integer> list) {
        // stop condition
        if (root == null) return;
        // left - root - right
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

2. iterative
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        
        return list;
    }
}