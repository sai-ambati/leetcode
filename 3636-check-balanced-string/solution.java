class Solution {
    public boolean isBalanced(String num) {
        int es = 0;
        int os = 0;
        boolean evenPos = true;

        int n = num.length();
        for(int i = n-1; i>=0; i--){
            int ld = num.charAt(i) - '0';
            if(evenPos){
                es += ld;
            }
            else{
                os += ld;
            }
            evenPos = !evenPos;
        }
        return es == os;
    }
}
