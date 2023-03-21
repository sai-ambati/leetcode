class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long count = 0;
        for(int x:nums){
            if(x!=0){
                ans += (count*(count+1))/2;
                count = 0;
            }
            else{
                count++;
            }
        }
        ans += (count*(count+1))/2;
        return ans;
    }
}