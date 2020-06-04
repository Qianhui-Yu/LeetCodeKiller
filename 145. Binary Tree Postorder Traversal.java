145. Binary Tree Postorder Traversal

1. recursive
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }
    
    public void postorder(TreeNode root, List<Integer> list) {
        // stop condition
        if (root == null) return;
        // left - right - root
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }
}

2.iterative
2.1 normal real postorder iterative
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            // 注意为了不让cur重复遍历左子树，要保留跳出while loop的cur == null的状态
            // 所以换用temp
            TreeNode temp = stack.peek();
            if (temp.right != null) {
                cur = temp.right;
            }
            else {
                temp = stack.pop();
                // 当左右子树都是空的时候，才add这个点
                list.add(temp.val);
                // 如果这个点是父节点的右子树，说明父节点的左子树已经遍历过了，所以直接把父节点加入结果
                // 如果不是右子树，那么进行外侧while loop遍历父节点的左子树
                while (!stack.isEmpty() && temp == stack.peek().right) {
                    temp = stack.pop();
                    list.add(temp.val);
                }
            }
        }
        
        return list;
    }
}
2.2 cool real postorder iterative
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            stack.pop();
            if (!stack.isEmpty() && stack.peek() == cur) {
                if (cur.right != null) {
                    stack.push(cur.right);
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                    stack.push(cur.left);
                }
            }
            else {
                list.add(cur.val);
            } 
        }
        
        return list;
    }
}
2.3 fake postorder iterative (reverse order of preorder)
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        // use LinkedList and addFirst which only costs O(1), otherwise costs O(n) in ArrayList to add at head
        // 不能用接口List<> 因为这样实例出来的list不能使用LinkedList独有的addFirst
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        // reverse root - left - right = left - right - root
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.addFirst(cur.val);
            // 注意这里还是先left后right，因为addFirst会添加到头部，所以结果中优先的要最后addFirst，所以最先入栈
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        
        return list;
    }
}