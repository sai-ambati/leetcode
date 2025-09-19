class Solution {
    public int earliestTime(int[][] tasks) {
        int n = tasks.length;
        int ans = tasks[0][0] + tasks[0][1];

        for(int i = 1; i<n; i++){
            int temp = tasks[i][0] + tasks[i][1];
            ans = Math.min(ans, temp);
        }
        return ans;
    }
}
