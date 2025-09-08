class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        for(int i = 1; i<=n/2; i++){
            ans[0] = i;
            ans[1] = n-i;
            if(!containsZero(ans[0]) && !containsZero(ans[1])){
                break;
            }
        }
        return ans;
    }
    public static boolean containsZero(int n){
        if(n==0){
            return true;
        }
        while(n!=0){
            if(n%10 == 0){
                return true;
            }
            n = n/10;
        }
        return false;
    }
}
