class Solution {
    public int minElement(int[] nums) {
        int ans = digitSum(nums[0]);
        for(int x:nums){
            ans = Math.min(ans, digitSum(x));
        }
        return ans;
    }

    public static int digitSum(int n){
        int ans = 0;
        while(n>0){
            int ld = n%10;
            ans = ans + ld;
            n = n/10;
        }
        return ans;
    }
}
