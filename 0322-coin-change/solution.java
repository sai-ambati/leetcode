class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        Arrays.fill(dp, -1);

        int ans = solve(amount, coins, dp);

        return ans != Integer.MAX_VALUE ? ans : -1;
    }

    public static int solve(int amount, int[] coins, int[] dp){
        if(amount == 0){
            return 0;
        }

        if(dp[amount] != -1){
            return dp[amount];
        }

        int cur_min = Integer.MAX_VALUE;
        for(int coin:coins){
            if(amount - coin >= 0){
                cur_min = Math.min(cur_min, solve(amount-coin, coins, dp));
            }
        }
        
        
        dp[amount] = cur_min!=Integer.MAX_VALUE ? cur_min + 1 : cur_min;

        return dp[amount];
    }
}
