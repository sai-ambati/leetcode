class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int left = 0;
        int right = n-1;

        int ans = -1;
        
        while(left <= right){
            int min_height = Math.min(height[left], height[right]);
            ans = Math.max(ans, min_height*(right - left));
            if(height[left] <= height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return ans;
    }
}
