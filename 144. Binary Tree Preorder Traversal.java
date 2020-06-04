144. Binary Tree Preorder Traversal
1. recursive
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }
    
    public void preorder(TreeNode root, List<Integer> list) {
        // stop condition
        if (root == null) return;
        // root - left - right
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}

2. iterative
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                list.add(cur.val);
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        
        return list;
    }
}