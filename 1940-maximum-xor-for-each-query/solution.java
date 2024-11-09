class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor=0;

        for(int x:nums){
            xor ^= x;
        }

        int n = nums.length;
        int[] ans = new int[n];
        // int temp = 0;
        for(int i = n-1; i>=0; i--){
            ans[n-1-i] = ~(xor) ^ (~((1<<maximumBit)-1));
            xor = xor ^ nums[i];
        }

        return ans;
    }
}
