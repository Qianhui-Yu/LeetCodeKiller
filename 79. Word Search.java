79. Word Search

class Solution {
    static boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == word.charAt(0) && search(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static boolean search(char[][] board, String word, int r, int c, int index) {
        if (index == word.length()) 
            return true;
        
        if (!inBound(board, r, c) || board[r][c] != word.charAt(index) || visited[r][c]) 
            return false;
        
        visited[r][c] = true;
        if (search(board, word, r+1, c, index+1) ||
            search(board, word, r, c+1, index+1) ||
            search(board, word, r-1, c, index+1) ||
            search(board, word, r, c-1, index+1)) {
            return true;
        }
        
        visited[r][c] = false;
        return false;
    }
    
    public static boolean inBound(char[][] board, int x, int y) {
        int r = board.length;
        int c = board[0].length;
        
        return 0 <= x && x < r && 0 <= y && y < c;
    }
}