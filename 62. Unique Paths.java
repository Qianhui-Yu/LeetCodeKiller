状态转移方程：path[i][j] = path[i-1][j] + path[i][j-1];
Time = O(nm)
Space = O(nm)

class Solution {
    public int uniquePaths(int m, int n) {
        if (m > n) return uniquePaths(n, m);
        
        int[][] path = new int[m][n];
        if (m == 1) return 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    path[i][j] = 1;
                    //path[j][i] = path[i][j];
                }
                else {
                    path[i][j] = path[i-1][j] + path[i][j-1];
                    //path[j][i] = path[i][j];
                }
            }
        }
        
        return path[m-1][n-1];
    }
}