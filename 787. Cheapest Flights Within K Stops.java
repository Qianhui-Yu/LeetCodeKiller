787. Cheapest Flights Within K Stops

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // HashMap: source - (dest - price)
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] f: flights) {
            if (!prices.containsKey(f[0]))
                prices.put(f[0], new HashMap<>());
            prices.get(f[0]).put(f[1], f[2]);
        }
        // minHeap: (total_price*, cur_city, remain_stops+1)
        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        pq.offer(new int[]{0, src, K + 1});
        while (!pq.isEmpty()) {
            int[] e = pq.poll();
            int price = e[0];
            int city = e[1];
            int stops = e[2];
            if (city == dst) 
                return price;
            if (stops > 0 && prices.containsKey(city)) {
                Map<Integer, Integer> adj = prices.get(city);
                for (Map.Entry<Integer, Integer> entry: adj.entrySet()) {
                    pq.offer(new int[]{price + entry.getValue(), entry.getKey(), stops - 1});
                }
            }
        }
        
        return -1;
    }
}