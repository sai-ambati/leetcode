class Solution {
    public boolean isPowerOfTwo(int n) {
        int a = n & (n-1);

        if(n<=0){
            return false;
        }
        if(a>0){
            return false;
        }
        else{
            return true;
        }
    }
}
