class Solution {
    public int maxProduct(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(int x:nums){
            if(x>firstMax){
                secondMax = firstMax;
                firstMax = x;
            }
            else if(x>secondMax){
                secondMax = x;
            }
        }

        return (firstMax-1)*(secondMax-1);
    }
}
