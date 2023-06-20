class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        int temp;

        for(int i =0; i<prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }

            temp = prices[i] - min;

            if(ans<temp){
                ans = temp;
            }
        }

        return ans;
    }
}
