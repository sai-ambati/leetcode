class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int a = helper(nums, 0, n-2,dp1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int b = helper(nums, 1, n-1, dp2);
        return Math.max(a, b);
    }

    public static int helper(int[] nums, int i, int n, int[] dp){
        if(i>n) return 0;
        if(dp[i] != -1){
            return dp[i];
        }
        int inc = helper(nums, i+2, n, dp) + nums[i];
        int exc = helper(nums, i+1, n, dp);
        dp[i] = Math.max(inc, exc);
        return dp[i];
    }

}
