class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        boolean flipped = false;
        
        for(int i = 0; i<nums.length; i++){
            if((!flipped && nums[i] == 0 )||(flipped && nums[i] == 1) ){
                flipped = !flipped;
                ans++;
            }
        }
        
        return ans;
    }
}
