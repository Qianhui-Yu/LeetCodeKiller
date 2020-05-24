451. Sort Characters By Frequency

1. hashmap + pq
class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() < 3) return s;
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(s.length(), new Comparator<>(){
            @Override
            public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        });
        /*
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            queue.offer(entry);
        }
        */
        queue.addAll(map.entrySet());
        
        //int i = 0;
        StringBuilder sb= new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            int freq = entry.getValue();
            while (freq > 0) {
                sb.append(entry.getKey());
                freq--;
            } 
        }
        
        return sb.toString();
        
    }
}

2. hashmap + bucket sort
class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() < 3) return s;
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        List<Character>[] bucket = new List[s.length() + 1];
        
        for (char c: map.keySet()) {
            int freq = map.get(c);
            if (bucket[freq] == null) 
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int freq = bucket.length - 1; freq > 0; freq--) {
            if (bucket[freq] != null) {
                for (char c: bucket[freq]) {
                    for (int i = 0; i < freq; i++) {
                        sb.append(c);
                    }
                }
            }
        }
        
        return sb.toString();
        
    }
}

