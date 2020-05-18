438. Find All Anagrams in a String

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length())
            return result;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c: p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int start = 0;
        int end = 0;
        int len = p.length();
        int diff = len;
        /*
        for (end = 0; end < len; end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0)
                    diff--;
            }
        }
        */
        if (diff == 0) result.add(start);
        
        while(end < s.length()) {
            char c = s.charAt(start);
            if (end >= len) {
                // forward window, restore diff and map
                if (map.containsKey(c)) {
                    if (map.get(c) >= 0)
                        diff++;
                    map.put(c, map.get(c) + 1);
                }
                start++;
            }
            
            // process the end of the window
            c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    diff--;
                }
            }
            
            if (diff == 0) result.add(start);
            // forward window
            end++;
        }
              
        return result;
    }
}