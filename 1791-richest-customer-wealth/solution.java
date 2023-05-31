class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        int sum;
        int m = accounts.length;
        int n = accounts[0].length;
        for(int i = 0; i<m; i++){
            sum = 0;
            for(int j = 0; j<n; j++){
                sum += accounts[i][j];
            }

            if(sum>max){
                max = sum;
            }
        }

        return max;
    }
}
