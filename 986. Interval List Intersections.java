986. Interval List Intersections

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0;
        int j = 0;
        List<int[]> list = new ArrayList<>();
        
        while (i < A.length && j < B.length) {
            int leftMax = Math.max(A[i][0], B[j][0]);
            int rightMin = Math.min(A[i][1], B[j][1]);
            
            if (leftMax <= rightMin) {
                list.add(new int[]{leftMax, rightMin});        
            }
            
            if (A[i][1] == rightMin) i++;
            if (B[j][1] == rightMin) j++;
        }
        
        return list.toArray(new int[0][0]);
    }
}