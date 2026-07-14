class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int n = g.length;
        int m = s.length;

        int left = 0;
        int right = 0;

        int count = 0;

        while(left < n && right < m){
            if(s[right] >= g[left]){
                count++;
                left++;
                right++;
            }
            else{
                right++;
            }
        }

        return count;
    }
}
