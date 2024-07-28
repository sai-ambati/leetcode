class Solution {
    public boolean check(int[] nums) {
        
        int pos = 0;

        for(int i = 0; i<nums.length-1; i++){
            if(nums[i] <= nums[i+1]){
                pos++;
            }
            else{
                break;
            }
        }
        if(pos == nums.length-1){
            return true;
        }
        // System.out.println(pos);
        for(int i = pos+1; i<nums.length-1; i++){
            if(nums[i]> nums[i+1]){
                return false;
            }
        }

        if(nums[nums.length-1] > nums[0]){
            return false;
        }

        return true;
    }
}
