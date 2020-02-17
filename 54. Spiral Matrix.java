class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        
        if (matrix.length == 0) return list;
        
        int rowU = 0;
        int rowD = matrix.length - 1;
        int colL = 0;
        int colR = matrix[0].length - 1;
        
        // 核心思想：不停向右下左上走，每走一次把边向内缩一行，直至rowU > rowD或者colL > colR(缩成一个点后，反向扩大了)
        while (rowU <= rowD && colL <= colR) {
            // traverse right
            for (int i = colL; i <= colR; i++) {
                list.add(matrix[rowU][i]);
            }
            rowU++;
            
            // traverse down
            for (int i = rowU; i <= rowD; i++) {
                list.add(matrix[i][colR]);
            }
            colR--;
            
            // traverse left
            // 注意这里因为上面rowU自增，所以while内的row条件需要重新判断
            // 因为朝左走其实是让rowD上升一行，如果rowU已经在rowD下面就没有必要这一步了，所以是判断row
            if (rowU <= rowD) {
                for (int i = colR; i >= colL; i--) {
                    list.add(matrix[rowD][i]);
                }
            }
            rowD--;
            
            // traverse up
            if (colL <= colR) {
                for (int i = rowD; i >= rowU; i--) {
                    list.add(matrix[i][colL]);
                }
            }
            colL++;
            
        }
        return list;
    }
}