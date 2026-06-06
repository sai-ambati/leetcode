class Solution {
    public boolean consecutiveSetBits(int n) {
        int prev = 0;
        int count = 0;
        while(n!=0){
            int cur = 1&n;
            if(cur == 1 && prev == 1){
                count++;
            }
            prev = cur;
            n /= 2;
        }

        return count == 1;
    }
}
