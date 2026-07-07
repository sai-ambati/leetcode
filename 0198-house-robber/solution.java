class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(n-1, nums, dp);
    }

    public static int solve(int k, int[] nums, int[] dp){
        if(k==0){
            dp[0] = nums[0];
            return nums[0];
        }
        if(k<0){
            return 0;
        }
        if(dp[k]!=-1){
            return dp[k];
        }
        int a = solve(k-1, nums, dp);
        int b = solve(k-2, nums, dp);

        dp[k] = Math.max(a, b+nums[k]);
        return dp[k];
    }
}
