class Solution {
    public int[] countBits(int n) {
        
        int[] ans = new int[n+1];

        for(int i = 0; i<n+1; i++){
            ans[i] = numberOfSetBits(i);
        }

        return ans;
    }

    public static int numberOfSetBits(int n){
        int count = 0;

        int i = 0;
        while(n>0){
            count += (n&(1)) >0 ? 1:0;
            // i++;
            n=n>>1;
        }

        return count;
    }
}
