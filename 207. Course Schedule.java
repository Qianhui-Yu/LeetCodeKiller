207. Course Schedule

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // indegree
        int[] inDegree = new int[numCourses];
        // adj list: graph
        List<Integer>[] g = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            g[i] = new ArrayList<Integer>();
        }
        
        for (int[] pre: prerequisites) {
            int u = pre[1];
            int v = pre[0];
            inDegree[v]++;
            g[u].add(v);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }
        
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            list.add(u);
            for (int i = 0; i < g[u].size(); ++i) {
                int v = g[u].get(i);
                if (--inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        
        return list.size() == numCourses;
    }
}