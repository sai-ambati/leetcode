class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        // left[0] = 1;
        right[n-1] = 1;

        for(int i = 1; i<n; i++){
            // left[i] = nume[i-1]*left[i-1];
            right[n-1-i] = nums[n-i] * right[n-i];
        }

        int cur = nums[0];

        for(int i = 1; i<n; i++){
            right[i] = right[i] * cur;
            cur = cur * nums[i];
        }

        return right;

    }
}
