class Solution {
    public int trailingZeroes(int n) {
        return solve(n, 5);
    }

    public static int solve(int n, int mul){
        if((n/mul)==0){
            return 0;
        }
        
        return n/mul + solve(n, mul*5);
    }
}
