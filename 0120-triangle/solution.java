class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row, -10001);
        }
        // Arrays.fill(dp, -10001);
        return solve(dp, triangle, 0, 0);
    }

    public static int solve(int[][] dp, List<List<Integer>> al, int lev, int pos){
        if(lev == al.size()){
            return 0;
        }
        if(dp[lev][pos]!=-10001){
            return dp[lev][pos];
        }
        int left = solve(dp, al, lev+1, pos);
        int right = solve(dp, al, lev+1, pos+1);

        dp[lev][pos] =  Math.min(left, right) + al.get(lev).get(pos);

        return dp[lev][pos];
    }
}
