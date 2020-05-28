886. Possible Bipartition

1. dfs
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        // adj list
        List<Integer>[] graph = new ArrayList[N];
        
        for (int i = 0; i < N; ++i) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge: dislikes) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph[u].add(v);
            graph[v].add(u);
        }
        // 0 - unvisited, 1/-1 2 colors
        int[] color = new int[N];
        color[0] = 1;
        
        for (int i = 0; i < N; ++i) {
            if (!bipart(graph, color, i)) return false;
        }
        
        return true;
    }
    
    public boolean bipart(List<Integer>[] graph, int[] color, int u) {
        for (int i = 0; i < graph[u].size(); ++i) {
            int v = graph[u].get(i);
            if (color[v] == 0) {
                color[v] = (color[u] == 1)? -1: 1;
                if (!bipart(graph, color, v)) return false;
            }
            else {
                if (color[v] == color[u]) return false;
            }
        }
        
        return true;
    }
}

2. bfs
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        // adj list
        List<Integer>[] graph = new ArrayList[N];
        
        for (int i = 0; i < N; ++i) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge: dislikes) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph[u].add(v);
            graph[v].add(u);
        }
        // 0 - unvisited, 1/-1 2 colors
        int[] color = new int[N];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < N; ++i) {
            if (color[i] == 0) {
                color[i] = 1;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    for (int v: graph[u]) {
                        if (color[v] == 0) {
                            color[v] = (color[u] == 1) ? -1 : 1;
                            queue.offer(v);
                        }
                        else {
                            if (color[v] == color[u]) return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}