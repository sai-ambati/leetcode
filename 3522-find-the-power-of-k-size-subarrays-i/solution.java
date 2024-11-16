class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        for(int i = 0; i<=n-k; i++){
            int power = nums[i+k-1];
            for(int j = i+1; j<i+k; j++){
                if(nums[j] != nums[j-1]+1){
                    power = -1;
                    break;
                }
            }
            ans[i] = power;
        }
        return ans;
    }
}
