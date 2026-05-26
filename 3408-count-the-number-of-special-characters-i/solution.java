class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> hs = new HashSet<>();
        HashSet<Character> ch = new HashSet<>();
        int n = word.length();
        int ans = 0;
        for(int i = 0; i<n; i++){
            char cc = word.charAt(i);
            char temp = ' ';
            if(cc >= 'a' && cc<='z'){
                temp = (char)(cc-'a' + 'A');
            }
            else if(cc >= 'A' && cc <= 'Z'){
                temp = (char)(cc-'A' + 'a');
            }
            if(hs.contains(temp) && !(ch.contains(cc) && ch.contains(temp))){
                ans++;
                ch.add(cc);
                ch.add(temp);
            }
            hs.add(cc);
        }
        return ans;
    }
}
