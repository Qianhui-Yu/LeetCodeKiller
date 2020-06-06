528. Random Pick with Weight

class Solution {
    double[] prob;
    public Solution(int[] w) {
        this.prob = new double[w.length];
        double sumWeights = 0;
        for (int weight: w) {
            sumWeights += weight;
        }
        for (int i = 0; i < w.length; ++i) {
            // cumulative weight
            w[i] += (i == 0) ? 0 : w[i-1]; 
            this.prob[i] = w[i] / sumWeights;
        }
    }
    
    public int pickIndex() {
        return Math.abs(Arrays.binarySearch(this.prob, Math.random())) - 1;
    }
}