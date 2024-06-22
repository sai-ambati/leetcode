class Solution {
    public String longestPalindrome(String s) {
        int start;
        int end;

        int length = -1;
        String ans = "";


            for(int i = 0; i<s.length(); i++){
                start = i;
                end = i;
                while((start>=0) && (end <= s.length()-1) && s.charAt(start) == s.charAt(end)){
                    if((end-start+1)>length){
                        length = end-start+1;
                        ans = s.substring(start, end+1);
                    }
                    start--;
                    end++;
                }
            }

            for(int i = 0; i<s.length()-1; i++){
                start = i;
                end = i+1;
                while((start>=0) && (end <= s.length()-1) && (s.charAt(start) == s.charAt(end))){
                    if((end-start+1)>length){
                        length = end-start+1;
                        ans = s.substring(start, end+1);
                    }
                    start--;
                    end++;
                }
            }

        return ans;
    }
}
