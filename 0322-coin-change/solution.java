class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);

        int res =  solve(coins, amount, dp);

        return res==Integer.MAX_VALUE ? -1 : res;
    }

    public static int solve(int[] coins, int amount, int[] dp){
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return Integer.MAX_VALUE;
        }
        
        if(dp[amount] != -1){
            return dp[amount];
        }
        int temp = Integer.MAX_VALUE;
        for(int x:coins){
            int res = solve(coins, amount-x, dp);
            if(res != Integer.MAX_VALUE){
                temp = Math.min(temp, res + 1);
            }
        }

        dp[amount] = temp;
        return dp[amount];
    }
}
