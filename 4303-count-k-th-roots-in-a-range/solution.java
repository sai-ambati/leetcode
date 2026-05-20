class Solution {
    public int countKthRoots(int l, int r, int k) {
        if(k==1){
            return r-l+1;
        }
        int count = 0;
        int curr = 0;
        while(Math.pow(curr, k) <= r){
            if(Math.pow(curr, k) >= l){
                count++;
            }
            curr++;
        }
        return count;
    }
}
