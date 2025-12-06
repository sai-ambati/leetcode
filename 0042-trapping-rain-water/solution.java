class Solution {
    public int trap(int[] A) {
        int n = A.length;

        int left = 0;
        int right = n-1;

        int leftMax = A[left];
        int rightMax = A[right];

        int ans = 0;

        while(left <= right){
            leftMax = Math.max(leftMax, A[left]);
            rightMax = Math.max(rightMax, A[right]);

            if(A[left] <= A[right]){
                ans += Math.min(leftMax, rightMax) - A[left];
                left++;
            }
            else{
                ans += Math.min(leftMax, rightMax) - A[right];
                right--;
            }
        }
        return ans;        
    }
}
