class Solution {
    public int pivotInteger(int n) {
        int totSum = n*(n+1) / 2;
        int prevSum = 0;
        int curSum = 0;
        for(int i = 1; i<=n; i++){
            curSum += i;
            if(curSum == totSum - prevSum){
                return i;
            }
            prevSum = curSum;
        }
        return -1;
    }
}
