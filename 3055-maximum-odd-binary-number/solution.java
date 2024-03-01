class Solution {
    public String maximumOddBinaryNumber(String s) {
        int l = s.length();

        int count1 = 0;

        for(int i = 0; i<l; i++){
            if(s.charAt(i) == '1'){
                count1++;
            }
        }

        int count0 = l-count1;

        String ans = "1";
        
        int i=1;
        while(i<=count0){
            ans = '0' + ans;
            i++;
        }

        i=2;
        while(i<=count1){
            ans = '1' + ans;
            i++;
        }

        return ans;
    }
}
