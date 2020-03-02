 public int findLengthOfLCIS(int[] nums) {
        int res = 0, cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i-1] < nums[i]) res = Math.max(res, ++cnt);
            else cnt = 1;
        }
        return res;
    }

static int maxSumIS(int[] input) 
    { 
        int n = input.length;
        int i, j, max = 0; 
        int msis[] = new int[n]; 
  
        /* Initialize msis values  
           for all indexes */
        for (i = 0; i < n; i++) 
            msis[i] = input[i]; 
  
        /* Compute maximum sum values 
           in bottom up manner */
        for (i = 1; i < n; i++) 
            for (j = 0; j < i; j++) 
                if (input[i] > input[j] && msis[i] < msis[j] + input[i]) 
                    msis[i] = msis[j] + input[i]; 
  
        /* Pick maximum of all 
           msis values */
        for (i = 0; i < n; i++) 
            if (max < msis[i]) 
                max = msis[i]; 
  
        return max; 
    } 