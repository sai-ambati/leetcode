class Solution {
    public String firstPalindrome(String[] words) {
        int n = words.length;
        String ans = "";
        for(int i = 0; i<n; i++){
            boolean is = true;

            int start = 0; 
            int end = words[i].length()-1;

            while(start <= end){
                if(words[i].charAt(start) != words[i].charAt(end)){
                    is = false;
                    break;
                }
                start++;
                end--;
            }
            if(is){
                ans = words[i];
                break;
            }
        }

        return ans;


    }
}
