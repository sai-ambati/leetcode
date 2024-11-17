class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        boolean isAllZeroes = true;
        for(int x:nums){
            if(x!=0){
                isAllZeroes = false;
                break;
            }
        }
        if(isAllZeroes){
            return 0;
        }
        int n = nums.length;
        int q = queries.length;

        int left = 1, right = q, result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canTransform(nums.clone(), queries, mid)) {
                result = mid; 
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }
        
        return result;
    }

    private boolean canTransform(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1]; 
        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            diff[l] -= val; 
            if (r + 1 < n) diff[r + 1] += val; 
        }
        int currentDecrement = 0;
        for (int i = 0; i < n; i++) {
            currentDecrement += diff[i]; 
            nums[i] += currentDecrement; 
            
            if (nums[i] > 0) return false;
        }

        return true; 
    }
}
