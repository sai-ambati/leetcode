class Solution {
    public int maxScore(String s) {
        int total_ones = 0;

        int n = s.length();

        for(int i = 0; i<n; i++){
            total_ones += (s.charAt(i) - '0');
        }

        int zeros = 0;
        int ones = 0;
        int ans = 0;
        for(int i = 0; i<n-1; i++){
            zeros += (1-(s.charAt(i) - '0'));
            ones += (s.charAt(i) - '0');
            ans = Math.max(ans, zeros + total_ones - ones);
        }
        return ans;
    }
}
