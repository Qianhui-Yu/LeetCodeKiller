/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int mid = 0;
        // binary search
        while(start < end) {
            mid = start + (end - start) / 2;
            if (isBadVersion(mid))
                end = mid;
            else
                start = mid + 1; // 注意这里start=mid+1;而不是start=mid因为mid已经不在考虑范围内了
        }
        
        return start;
    }
}