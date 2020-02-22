要注意更新左指针的时候要比较现在的位置和重复的元素位置+1哪个大
因为左指针不能滚回

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j), j);
            max = Math.max(max, j - i + 1);
        }
        
        return max;
    }
}