class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        int len = nums.length;
        
        for(int i = 0; i<len-2; i++){
            if(nums[i] == 0){
                nums[i] = 1^nums[i];
                nums[i+1] = 1^nums[i+1];
                nums[i+2] = 1^nums[i+2];
                ans++;
            }
        }
        
        for(int i = len-2; i<len; i++){
            if(nums[i] == 0){
                return -1;
            }
        }
        
        return ans;
        
    }
}
