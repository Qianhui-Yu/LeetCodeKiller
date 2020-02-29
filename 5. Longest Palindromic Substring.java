class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int n = s.length();
        boolean[][] pd = new boolean[n][n];
        // 注意状态转移方程导致的遍历顺序
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // dp状态转移方程
                // 可回文 = 首尾字符相同 && 中间可回文
                //       = 首尾字符相同 && (首尾差<3 || 中间可回文)
                // dp就是从头开始，记录信息，当前状态可以用到之前的状态信息，给出状态转移方程
                pd[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3 || pd[i + 1][j - 1]);
                if (pd[i][j] && j - i + 1 > res.length()) 
                    res = s.substring(i, j + 1);
            }
        }
        
        return res;
    }
}