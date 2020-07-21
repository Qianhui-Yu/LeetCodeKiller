199. Binary Tree Right Side View.java

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root == null) return res;
        queue.add(root);
        res.add(root.val);
        
        //TreeNode rightMost = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            //每一层开始的时候都要初始化rigtMost
            TreeNode rightMost = null;
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                    rightMost = cur.left;
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    rightMost = cur.right;
                }
            }
            if (rightMost != null) res.add(rightMost.val);
        }
        
        return res;
    }
}