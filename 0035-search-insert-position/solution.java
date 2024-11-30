class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n-1;
        int ans = 0;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] == target){
                start = mid+1;
                ans = mid;
            }
            else if(nums[mid] < target){
                start = mid+1;
                ans = start;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
}
