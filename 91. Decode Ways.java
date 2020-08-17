91. Decode Ways

class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        
        if (s.charAt(0) == '0') return 0;
        dp[0] = 1;
        for (int i = 0; i < s.length(); ++i) {
            boolean oneIsValid = checkOne(s.charAt(i));
            boolean twoIsValid = i > 0 ? checkTwo(s.charAt(i-1), s.charAt(i)) : false;
            
            if (oneIsValid && twoIsValid) {
                dp[i+1] = dp[i] + dp[i-1];
            }
            else if (oneIsValid && !twoIsValid) {
                dp[i+1] = dp[i];
            }
            else if (!oneIsValid && twoIsValid) {
                dp[i+1] = dp[i-1];
            }
            else return 0;
        }
        
        return dp[s.length()];
    }
    
    public boolean checkOne(char c) {
        if (c == '0') return false;
        return true;
    }
    
    public boolean checkTwo(char a, char b) {
        int sum = 10 * (a - '0') + b - '0';
        if (10 <= sum && sum <= 26)
            return true;
        else return false;
    }
}