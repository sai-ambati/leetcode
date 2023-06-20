class Solution {
    public int[] getAverages(int[] nums, int k) {

        if(k == 0){
            return nums;
        }

        int n = nums.length;

        int[] ans = new int[n];

        Arrays.fill(ans, -1);

        if(2*k+1 >n){
            return ans;
        }

        long windowSum = 0;

        for(int i = 0; i<(2*k+1); ++i){
            windowSum += nums[i];
        }

        ans[k] = (int)(windowSum/ (2*k+1));

        for(int i = (2*k +1); i<n; ++i){
            windowSum = windowSum - nums[i-(2*k+1)] + nums[i];
            ans[i-k] = (int)(windowSum / (2*k+1));
        }

        return ans;

        
    }
}
