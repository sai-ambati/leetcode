class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length-1;
        if(n==0) return true;
        int sum = 0;
        for(int x:nums){
            sum += x;
        }
        int p1 = solve(nums, 0, n);
        int p2 = sum-p1;
        return p1>=p2;
    }

    public static int solve(int[] nums, int i, int j){
        if(i > j){
            return 0;
        }
        if(i==j) return nums[i];

        int left = Math.min(solve(nums, i+2, j), solve(nums, i+1, j-1)) + nums[i];
        int right = Math.min(solve(nums, i, j-2), solve(nums, i+1, j-1)) + nums[j];

        return Math.max(left, right);
        
    }
}
