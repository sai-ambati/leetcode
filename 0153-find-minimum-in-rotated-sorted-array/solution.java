class Solution {
    public int findMin(int[] nums) {
        int ans = nums[0];

        for(int x:nums){
            ans = Math.min(ans, x);
        }

        return ans;
    }
}
