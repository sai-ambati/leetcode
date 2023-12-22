class Solution {
    public int maxScore(String s) {
        
        int l = s.length();

        int[] zeros = new int[l];
        int[] ones = new int[l];

        int count = 0;
        for(int i = 0; i<l ; i++){
            
            if(s.charAt(i) - '0' == 0){
                count++;
            }
            zeros[i] = count;
        }

        count = 0;
        for(int i = l - 1; i>=0; i--){
            
            if(s.charAt(i) - '1' == 0){
                count++;
            }

            ones[i] = count;
        }

        count = 0;

        for(int i = 0; i<l-1; i++){
            if(zeros[i] + ones[i+1] > count){
                count = zeros[i] + ones[i+1];
            }
        }

        return count;

    }
}
