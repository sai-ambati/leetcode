class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];

        int[] right = new int[n];

        left[0] = 0;
        right[n-1] = 0;

        for(int i = 1; i<n; i++){
            left[i] = nums[i-1] + left[i-1];
            right[n-i-1] = nums[n-i] + right[n-i];
        }
        // System.out.println(Arrays.toString(nums));
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        int[] ans = new int[n];

        for(int i = 0; i<n; i++){
            ans[i] = Math.abs(left[i] - right[i]);
        }

        return ans;
    }
}
