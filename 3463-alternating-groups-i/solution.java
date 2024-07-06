class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int ans = 0;
        for(int i = 0; i<n; i++){
            if(i==0){
                if(colors[n-1] != colors[0] && colors[1] != colors[0]){
                    ans++;
                }
            }
            else if(i == n-1){
                if(colors[n-1] != colors[0] && colors[n-1]!= colors[n-2]){
                    ans++;
                }
            }
            else{
                if(colors[i] != colors[i+1] && colors[i] != colors[i-1]){
                    ans++;
                }
            }
        }
        return ans;
    }
}
