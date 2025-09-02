class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int cnt = nums[0];
        int ans = cnt;

        for(int i = 1; i<n; i++){
            if(nums[i]==0){
                ans = Math.max(cnt, ans);
                cnt = 0;
            }
            else{
                cnt++;
            }
        }
        return Math.max(ans, cnt);
    }
}
