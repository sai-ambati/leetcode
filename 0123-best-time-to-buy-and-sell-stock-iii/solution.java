class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // Initialize buy states to lowest possible cash
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int profit1 = 0;
        int profit2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            profit1 = Math.max(profit1, buy1 + price);
            buy2 = Math.max(buy2, profit1 - price); // Fix: cash after reinvesting profit1
            profit2 = Math.max(profit2, buy2 + price); // Fix: final cash position
        }
        return profit2;
    }
}

