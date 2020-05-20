76. Minimum Window Substring

class Window {
    int start;
    int end;
    public Window(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        Map<Integer, Window> map = new HashMap<>();
        String result;
        int start = 0; int end = 0; int diff = t.length();
        int[] chars = new int[58];
        int min = Integer.MAX_VALUE;
        
        for (char c: t.toCharArray()) {
            chars[c - 'A']++;
        }
        
        char c;
        while (end < s.length()) {
            c = s.charAt(end);
            chars[c - 'A']--;
            if (chars[c - 'A'] >= 0) 
                diff--;
            if (diff == 0) {
                min = end + 1;
                map.put(min, new Window(start, end));
                break;
            }
            end++;
        }
        
        if (end >= s.length() || min > s.length()) return "";
        
        while (end < s.length() || start <= s.length() - t.length()) {
            c = s.charAt(start);
            while (chars[c - 'A'] < 0 || end - start + 1 >= min) {
                if (chars[c- 'A'] >= 0)
                    diff++;
                chars[c - 'A']++;
                start++;
                if (start > s.length() - t.length()) break;
                c = s.charAt(start);
            }
            if (diff == 0 && end - start + 1 < min) {
                min = end - start + 1;
                map.put(min, new Window(start, end));
            }
            
            end++;
            if (end >= s.length()) 
                break;
            else {
                c = s.charAt(end);
                chars[c - 'A']--;
                if (chars[c - 'A'] >= 0) 
                    diff--;
                if (diff == 0 && end - start + 1 < min) {
                    min = end - start + 1;
                    map.put(min, new Window(start, end));
                }
            } 
        }
        
        return s.substring(map.get(min).start, map.get(min).end + 1);
        //return "000"+2;
    }
}