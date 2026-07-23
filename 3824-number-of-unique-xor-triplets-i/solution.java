class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n<=2){
            return n;
        }
        int msb = (int)(Math.log(n)/Math.log(2)) + 1;
        return (int)Math.pow(2, msb);
    }
}
