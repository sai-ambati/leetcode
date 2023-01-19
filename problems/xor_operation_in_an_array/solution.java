class Solution {
    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        nums[0] = start;
        int ans = nums[0];
        for(int i=1; i<n; i++){
            nums[i] = nums[i-1] + 2;
            ans = ans^nums[i];
        }
        return ans;
    }
}