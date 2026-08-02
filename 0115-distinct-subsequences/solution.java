class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] memo = new int[m+1][n+1];

        for(int i=0; i<=n; i++){
            memo[0][i] = 1;
        }

        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                if(t.charAt(i-1) == s.charAt(j-1)){
                    memo[i][j] = memo[i-1][j-1] + memo[i][j-1];
                }
                else{
                    memo[i][j] = memo[i][j-1];
                }
            }
        }

        return memo[m][n];
    }
}
