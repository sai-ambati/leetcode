class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for(int i = 0; i+2*k-1 < n; i++){
            boolean b1 = true;
            for(int j = i+1; j<i+k; j++){
                if(nums.get(j)<=nums.get(j-1)){
                    b1 = false;
                }
            }
            boolean b2 = true;
            for(int j = i+k+1; j<i + 2*k; j++){
                if(nums.get(j) <= nums.get(j-1)){
                    b2 = false;
                }
            }
            if(b1 && b2){
                return true;
            }
        }
        return false;
    }
}
