class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //if (matrix == null) return false;
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        
        int rowStart = 0;
        int rowEnd = m - 1;
        int colStart = 0;
        int colEnd = n - 1;
        
        // find row
        while (rowStart < rowEnd) {
            int rowMid = rowStart + (rowEnd - rowStart) / 2;
            if (target == matrix[rowMid][colEnd]) return true;
            else if (target < matrix[rowMid][colEnd]) rowEnd = rowMid;
            else rowStart = rowMid + 1;
        }
        
        // search in column
        while (colStart <= colEnd) {
            int colMid = colStart + (colEnd - colStart) / 2;
            if (target == matrix[rowStart][colMid]) return true;
            else if (target < matrix[rowStart][colMid]) colEnd = colMid - 1;
            else colStart = colMid + 1;
        }
        
        return false;
    }
}

// Or treat the matrix as a sorted array
// an array convert to m * n matrix => a[x] =>matrix[x / n][x % n];
// running time is same O(logMN) = O(logM + logN)