class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;

        int[] temp = new int[n];
        temp[0] = check(words[0]) ? 1: 0;
        for(int i = 1; i<n; i++){
            temp[i] = temp[i-1] + (check(words[i]) ? 1: 0);
        }

        n = queries.length;
        int[] ans = new int[n];
        for(int i = 0; i<n; i++){
            int s = queries[i][0];
            int e = queries[i][1];
            if(s == 0){
                ans[i] = temp[e];
            }
            else{
                ans[i] = temp[e] - temp[s-1];
            }
        }
        return ans;
    }

    public static boolean check(String s){
        return isVowel(s.charAt(0)) && isVowel(s.charAt(s.length()-1));
    }

    public static boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
}
