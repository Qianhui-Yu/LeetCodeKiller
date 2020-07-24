103. Binary Tree Zigzag Level Order Traversal

1 reverse ArrayList 
Collections.reverse(level);

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        //bfs
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            // visit new level
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            //res.add(depth % 2 == 0 ? level : Collections.reverse(level));
            if (depth % 2 == 0)
                res.add(level);
            else {
                Collections.reverse(level);
                res.add(level);
            }
            depth++; 
        }
        
        return res;
        
    }
}
2 add at 0 index in ArrayList

if (x) { list.add(cur.val); } 
else { list.add(0, cur.val); }

3 two queues

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null){
            return results;
        }
        Queue<TreeNode> queue_A = new LinkedList<>();
        Queue<TreeNode> queue_B = new LinkedList<>();
        queue_A.offer(root);
        queue_B.offer(root);
        int count = 0;
        while(!queue_A.isEmpty()){
            int size = queue_A.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode head_A= queue_A.poll();
                TreeNode head_B= queue_B.poll();
                if (count % 2 == 0){
                    currentLevel.add(head_A.val);
                }
                else{
                    currentLevel.add(head_B.val);
                }
                if (head_B.right != null){
                    queue_B.offer(head_B.right);
                }
                if (head_B.left != null){
                    queue_B.offer(head_B.left);
                }
                if (head_A.left != null){
                    queue_A.offer(head_A.left);
                }
                if (head_A.right != null){
                    queue_A.offer(head_A.right);
                }
            }
            count++;
            results.add(currentLevel);
        }
    return results;
    }
}
