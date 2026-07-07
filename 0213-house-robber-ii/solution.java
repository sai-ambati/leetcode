class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1){
            return nums[0];
        }

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int a = solve(0, n-2, nums, dp);
        Arrays.fill(dp, -1);
        int b = solve(1, n-1, nums, dp);
        return Math.max(a, b);
    }

    public static int solve(int start, int k, int[] nums, int[] dp){
        if(k == start){
            dp[start] =  nums[start];
            return dp[start];
        }

        if(k<start){
            return 0;
        }

        if(dp[k] != -1){
            return dp[k];
        }

        int a = solve(start, k-1, nums, dp);
        int b = solve(start, k-2, nums, dp);

        dp[k] = Math.max(a, b+nums[k]);
        return dp[k];
    }
}
