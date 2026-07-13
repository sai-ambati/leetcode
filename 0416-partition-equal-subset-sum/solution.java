class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        long total_sum = 0;

        for(int x:nums){
            total_sum += x;
        }

        if(total_sum %2 != 0){
            return false;
        }

        int target = (int)total_sum/2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int x:nums){
            for(int j = target; j>= x; j--){
                if(dp[j-x]){
                    dp[j] = true;
                }
            }
        }

        return dp[target];
    }
}
