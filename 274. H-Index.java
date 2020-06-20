274. H-Index

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int N = citations.length;
        int start = 0;
        int end = N - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int h = N - mid;
            if (citations[mid] < h) {
                start = mid + 1;
            }
            else if (citations[mid] > h) {
                end = mid - 1;
            }
            else return h;
        }
        
        return N - start;
    }
}