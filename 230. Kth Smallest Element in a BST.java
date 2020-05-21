230. Kth Smallest Element in a BST

1. dfs recursive
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list.get(k - 1);
    }
    
    public static void inOrder(TreeNode root, List<Integer> list) {
        //if (root == null) return;
        if (root.left != null)
            inOrder(root.left, list);
        list.add(root.val);
        if (root.right != null) 
            inOrder(root.right, list);
    }
}

2. dfs iterative
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        while (k != 0) {
            TreeNode node = stack.pop();
            k--;
            if (k == 0) return node.val;
            
            TreeNode right = node.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        
        return -1;
    }
}