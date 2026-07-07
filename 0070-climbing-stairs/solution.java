class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];

        return solve(n, dp);

        
    }

    public static int solve(int n , int[] dp){
        // base case
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }

        if(dp[n]!=0){
            return dp[n];
        }

        dp[n] = solve(n-1, dp) + solve(n-2, dp);

        return dp[n];
    } 
}
