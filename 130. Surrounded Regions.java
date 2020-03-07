法一：BFS
class Solution {
    public void solve(char[][] board) {
        if (board.length == 0) return;
        //char[][] visited = Arrays.copyOf(board, board.length);
        int row = board.length;
        int col = board[0].length;
        char[][] visited = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = board[i][j];
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j] == 'O') {
                    bfs(board, visited, i, j);
                }
            }
        }
        
        return;
    }
    
    private static void bfs(char[][] board, char[][] visited, int i, int j) {
        int[] deltaX = {0, -1, 0, 1};
        int[] deltaY = {-1, 0, 1, 0};
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> rigion = new ArrayList<>();
        queue.offer(new int[]{i, j});
        rigion.add(new int[]{i, j});
        visited[i][j] = 'X';
        boolean flag = true;
        if (onBorder(board, i, j)) flag = false;
        //boolean flag = onBorder(board, i, j)? false: true;
        
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            for (int n = 0; n < deltaX.length; n++) {
                int newX = x + deltaX[n];
                int newY = y + deltaY[n];
                if (!inBound(board, newX, newY)) continue;
                if (visited[newX][newY] == 'O') {
                    queue.offer(new int[]{newX, newY});
                    rigion.add(new int[]{newX, newY});
                    visited[newX][newY] = 'X';
                    if (onBorder(board, newX, newY)) flag = false;
                }
            }
        }
        
        if (flag) {
            for (int[] node: rigion) {
                board[node[0]][node[1]] = 'X';
            }
        }
        
        return;
    }
    
    private static boolean inBound(char[][] board, int i, int j) {
        int row = board.length;
        int col = board[0].length;
        return 0 <= i && i < row && 0 <= j && j < col;
    }
    
    private static boolean onBorder(char[][] board, int i, int j) {
        int row = board.length;
        int col = board[0].length;
        return i == 0 || i == row - 1 || j == 0 || j == col - 1;
    }
}
法2：DFS
class Solution {
    public void solve(char[][] board) {
        if (board.length == 0) return;
        int row = board.length;
        int col = board[0].length;
        
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            if (board[i][col - 1] == 'O')
                dfs(board, i, col - 1);
        }
        
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O')
                dfs(board, 0, j);
            if (board[row - 1][j] == 'O')
                dfs(board, row - 1, j);
        }
        
        for (int i = 0; i < row; i++) {
            for ( int j = 0; j < col; j++) {
                if (board[i][j] == '-')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        return;
    }
    
    private static void dfs(char[][] board, int i, int j) {
        board[i][j] = '-';
        int[] deltaX = {0, -1, 0, 1};
        int[] deltaY = {-1, 0, 1, 0};
        
        for (int n = 0; n < deltaX.length; n++) {
            int x = i + deltaX[n];
            int y = j + deltaY[n];
            if (!inBound(board, x, y)) continue;
            if (board[x][y] == 'O')
                dfs(board, x, y);
        }
        
        return;
    }
    
    private static boolean inBound(char[][] board, int i, int j) {
        int row = board.length;
        int col = board[0].length;
        return 0 <= i && i < row && 0 <= j && j < col;
    }