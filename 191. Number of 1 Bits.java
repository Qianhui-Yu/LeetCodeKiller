191. Number of 1 Bits

不用考虑正负数，直接看32bits每一位是不是1
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) != 0) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}