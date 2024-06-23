class Solution {
    public int maximumWealth(int[][] accounts) {
        int largest = Integer.MIN_VALUE;

        int sum = 0;

        int rl = accounts.length;
        int cl = accounts[0].length;

        for(int row = 0; row<rl; row++){
            sum = 0;
            for(int col = 0; col<cl; col++){
                sum += accounts[row][col];
            }
            if(sum > largest){
                largest = sum;
            }
        }

        return largest;
    }
}
