状态转移方程：
valid[ i ] = valid[ j ] && substringValid(j,i)

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // valid[n] = valid[j] && wordValid(j+1,n)
        // space O(n) 
        // valid[j]和valid[n]都需要遍历，所以time O(n^2)
        
        Set<String> set = new HashSet<>();
        for(String word: wordDict) {
            set.add(word);
        }
        
        boolean valid[] = new boolean[s.length() + 1];
        valid[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (valid[j] && set.contains(s.substring(j, i))) {
                    valid[i] = true;
                    break;
                }
            }
        }
        
        return valid[s.length()];
    }
}