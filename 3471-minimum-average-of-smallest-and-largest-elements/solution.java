class Solution {
    public double minimumAverage(int[] nums) {
        
        int n = nums.length;
        
        Arrays.sort(nums);
        
        int start = 0;
        int end = n-1;
        
        double[] avg = new double[n/2];
        
        while(start <= end){
            avg[start] = (nums[start] + nums[end])/2.0;
            start++;
            end--;
        }
        
        double ans = avg[0];
        for(int i = 1; i<n/2; i++){
            if(avg[i] < ans){
                ans = avg[i];
            }
        }
        
        return ans;
        
    }
}
