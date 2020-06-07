406. Queue Reconstruction by Height

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return (a[0] == b[0]) ? a[1] - b[1] : b[0] - a[0];
            }
        });
        
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; ++i) {
            list.add(people[i][1], people[i]);
        }
        
        return list.toArray(new int[0][0]);
    }
}