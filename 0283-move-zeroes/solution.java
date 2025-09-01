class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = 0;
        while(end < n){
            while(end < n && nums[end] == 0){
                end++;
            }
            if(end == n){
                break;
            }
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end++;
        }
    }
}
