class Solution {
    public int numberOfChild(int n, int k) {
        int mod = k %(2*(n - 1));

        if(mod <=(n-1)){
            return mod;
        }
        else{
            return (2*(n-1)) - mod;
        }
    }
}
