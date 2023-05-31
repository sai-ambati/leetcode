class Solution {
    public boolean isPowerOfTwo(int n) {
        // if((n & (n-1)) == 0){
        //     return true;
        // }
        // return false;
        if(n<=0){
            return false;
        }
        // System.out.println();
        return ((n & (n-1)) == 0);
    }
}
