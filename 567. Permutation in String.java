567. Permutation in Strings

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] chars = new int[26];
        for (char c: s1.toCharArray()) {
            chars[c - 'a']++;
        }
        
        int start = 0;
        int end = 0;
        int len = s1.length();
        int diff = len;
        char c;
        
        while (end < s2.length()) {
            if (end >= len) {
                c = s2.charAt(start);
                if (chars[c - 'a'] >= 0)
                    diff++;
                chars[c - 'a']++;
                
                start++;
            }
            
            c = s2.charAt(end);
            chars[c - 'a']--;
            if (chars[c - 'a'] >= 0)
                diff--;
            if (diff == 0) return true;
            
            end++;
        }
        
        return false;
    }
}