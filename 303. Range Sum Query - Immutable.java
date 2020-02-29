class NumArray {
    // 不用初始化，留在构造方法里初始化，就可以知道nums的size了；
    int[] sum;
    
    public NumArray(int[] nums) {
        sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) this.sum[0] = nums[0];
            else this.sum[i] = this.sum[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        //if (j == 0) return -100;
        if (sum.length == 0) return -100;
        if (i == 0) return sum[j];
        else return sum[j] - sum[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */