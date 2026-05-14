class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;

        HashSet<Integer> hs = new HashSet<>();
        int count = 0;
        for(int x:nums){
            if(x<=0 || x>=n){
                return false;
            }
            else if(x!=n-1 && hs.contains(x)){
                return false;
            }
            else if(x==n-1){
                count++;
            }
            hs.add(x);
        }
        return count==2;
        
    }
}
