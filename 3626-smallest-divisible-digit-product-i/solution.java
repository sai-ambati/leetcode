class Solution {
    public int smallestNumber(int n, int t) {
        int temp = product(n);
        while(temp%t != 0){
            n+=1;
            temp = product(n);
        }
        return n;
    }
    public static int product(int n){
        int ans = 1;
        while(n>0){
            int ld = n%10;
            ans *= ld;
            n /= 10;
        }
        return ans;
    }
}
