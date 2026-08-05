class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for(int x:prices){
            min = Math.min(min, x);
            ans = Math.max(ans, x-min);
        }
        return ans;
    }
}
