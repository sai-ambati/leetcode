class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] memo = new Boolean[n+1][m+1];
        return solve(s, p, 0, 0, memo);
    }

    public static boolean solve(String s, String p, int i, int j, Boolean[][] memo){
        if(memo[i][j] != null){
            return memo[i][j];
        }
        if((i==s.length()) && (j==p.length())){
            memo[i][j] = true;
            return memo[i][j];
        }
        if(j==p.length() && i!=s.length()){
            memo[i][j] = false;
            return memo[i][j];
        }
        if(i==s.length()){
            while(j<p.length()){
                if(p.charAt(j) != '*'){
                    memo[i][j] = false;
                    return memo[i][j];
                }
                j++;
            }
            memo[i][j] = true;
            return memo[i][j];
        }
        if(p.charAt(j) == '?'){
            memo[i][j] = solve(s, p, i+1, j+1, memo);
            return memo[i][j];
        }
        if(p.charAt(j) == '*'){
            memo[i][j] = (solve(s, p, i+1, j, memo) || solve(s, p, i, j+1, memo));
            return memo[i][j];
        }
        if(p.charAt(j) == s.charAt(i)){
            memo[i][j] = solve(s, p, i+1, j+1, memo);
            return memo[i][j];
        }
        memo[i][j] = false;
        return memo[i][j];
    }
}
