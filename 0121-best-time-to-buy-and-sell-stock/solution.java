class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] pre = new int[n];
        int[] suf = new int[n];

        pre[0] = prices[0];
        suf[n-1] = prices[n-1];
        for(int i = 1; i<n; i++){
            pre[i] = Math.min(pre[i-1], prices[i]);
            suf[n-1-i] = Math.max(suf[n-i], prices[n-1-i]);
        }

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){
            ans = Math.max(ans, suf[i] - pre[i]);
        }

        return ans;


    }
}
