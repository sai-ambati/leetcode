class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int left = 0;
        int right = 0;

        int m = nums1.length;
        int n = nums2.length;

        while(left <m && right < n){
            if(nums1[left] == nums2[right]){
                return nums1[left];
            }
            else if(nums1[left] < nums2[right]){
                left++;
            }
            else{
                right++;
            }
        }
        return -1;
    }
}
