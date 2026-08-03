class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        Integer[] dp = new Integer[n];
        
        int alice = helper(stoneValue, 0, n, dp);
        int sum = 0;
        for(int x:stoneValue){
            sum += x;
        }
        int bob = sum-alice;
        System.out.println(alice + " " + bob);
        if(alice == bob){
            return "Tie";
        }
        else if(alice > bob){
            return "Alice";
        }
        else{
            return "Bob";
        }
    }

    public static int helper(int[] stoneValue, int i, int n, Integer[] dp){
        if(i>=n){
            return 0;
        }
        if(dp[i] != null) return dp[i];
        int ans = Integer.MIN_VALUE;
        if(i<n){
            int temp = Integer.MAX_VALUE;
            for(int j = 1; j<=3; j++){
                
                    temp = Math.min(temp, helper(stoneValue, i+j+1, n, dp));
                
            }
            if(temp==Integer.MAX_VALUE){
                temp = 0;
            }
            ans = Math.max(ans, temp+stoneValue[i]);
        }
        if(i+1<n){
            int temp = Integer.MAX_VALUE;
            for(int j = 1; j<=3; j++){
                
                    temp = Math.min(temp, helper(stoneValue, i+j+2, n, dp));
                
            }
            if(temp==Integer.MAX_VALUE){
                temp = 0;
            }
            ans = Math.max(ans, temp+stoneValue[i]+stoneValue[i+1]);
        }
        if(i+2<n){
            int temp = Integer.MAX_VALUE;
            for(int j = 1; j<=3; j++){
                
                    temp = Math.min(temp, helper(stoneValue, i+j+3, n, dp));
                
            }
            if(temp==Integer.MAX_VALUE){
                temp = 0;
            }                
            ans = Math.max(ans, temp+stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]);
        }

        dp[i] = ans!=Integer.MIN_VALUE ? ans: 0;
        return dp[i];
    }
}
