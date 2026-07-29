class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int start = 0;
        int end = n-1;
        int[][] dp = new int[n][n];
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(s, start, end, dp);
    }

    public static int solve(String s, int start, int end, int[][] dp){
        if(start >= end) return 0;
        
        if(dp[start][end] != -1){
            return dp[start][end];
        }
        if(s.charAt(start) == s.charAt(end)){
            dp[start][end] = solve(s, start+1, end-1, dp);
            return dp[start][end];
        }

        dp[start][end] = Math.min(solve(s, start+1, end, dp), solve(s, start, end-1, dp)) + 1;
        return dp[start][end];
    }
}
