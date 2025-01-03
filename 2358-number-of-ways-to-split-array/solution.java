class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;

        long ts = 0;

        for(int i = 0; i<n; i++){
            ts += nums[i];
        }

        long cs = 0;
        int ans = 0;
        for(int i = 0; i<n-1; i++){
            cs += nums[i];
            if(cs >= (ts - cs)){
                ans++;
            }
        }
        return ans;
    }
}
