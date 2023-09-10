class Solution {

    private int MOD = (int)1e9 + 7;  
    private static final int MAX_PAIRS = 510; 
    private long[] memoization = new long[MAX_PAIRS];  

    private long calculateOrdersCount(long remainingPairs) {
        if (remainingPairs == 0)
            return 1;

        if (memoization[(int)remainingPairs] != -1)
            return memoization[(int)remainingPairs];

        long currentResult = calculateOrdersCount(remainingPairs - 1) * (2 * remainingPairs - 1) * remainingPairs % MOD;

        return memoization[(int)remainingPairs] = currentResult;
    }

    public int countOrders(int numPairs) {
        for(int i = 0 ; i < numPairs + 5 ; i ++){
            memoization[i] = -1 ;
        }

        return (int)calculateOrdersCount(numPairs);
    }
}
