class Solution {
    public int minBitFlips(int start, int goal) {
        int temp = start ^ goal;

        int ans=0;
        for(int i = 0; i<32; i++){
            ans += (temp&(1<<i))>0?1:0;
        }

        return ans;
        
    }
}
