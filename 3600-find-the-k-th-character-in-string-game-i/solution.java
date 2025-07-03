class Solution {
    public char kthCharacter(int k) {
        int n = k-1;
        int ans = 0;
        for(int i = 0; i<32; i++){
            if((n&(1<<i)) != 0){
                ans++;
            }
        }
        return (char)('a' + ans);
    }
}
