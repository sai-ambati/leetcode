class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = 1;
        int k = 1;
        while(end < n){
            if(nums[start] != nums[end]){
                k++;
                start++;
                if(start!=end){
                    // int temp = nums[start];
                    nums[start] = nums[end];
                    // nums[end] = temp;
                }
            }
            end++;
        }
        return k;
    }
}
