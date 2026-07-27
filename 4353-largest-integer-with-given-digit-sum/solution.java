class Solution {
    public int largestInteger(int n, int s) {
        if(9*n < s) return -1;
        int ans = 0;
        while(n>0){
            int temp = s-9;
            if(temp <= 0){
                ans = ans*10 + s;
                temp = s;
                s = 0;
            }
            
            else{
                s -= 9;
                ans = ans*10 + 9;
            }
            n--;
        }
        return ans;
    }
}
