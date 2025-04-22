class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        
        HashSet<Character> hs = new HashSet<>();
        int ans = 0;
        for(int i = 0; i<n; i++){
            hs = new HashSet<>();
            int length = 0;
            for(int j = i; j<n; j++){
                if(hs.contains(s.charAt(j))){
                    break;
                }
                else{
                    hs.add(s.charAt(j));
                    length += 1;
                }
            }
            ans = Math.max(ans, length);
        }
        return ans;
    }
}
