204. Count Primes

1. isPrime法 upper bound 缩到 <= 根号n
class Solution {
    public int countPrimes(int n) {
        // go through
        int count = 0;
        
        for (int i = 1; i < n; ++i) {
            if (isPrime(i)) count++; 
        }
        
        return count;
    }
    
    // O(sqrt(N))
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int d = 2; d * d <= n; ++d) {
            if (n % d == 0)
                return false;
        }
        return true;
    }
}