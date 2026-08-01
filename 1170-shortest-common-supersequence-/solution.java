class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];
        
        int prev = 0;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        String lcs = "";
        int i = n;
        int j = m;
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                lcs = str1.charAt(i-1) + lcs;
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        System.out.println(lcs);
        int k = 0;
        i = 0;
        j = 0;
        String ans = "";
        while(k<dp[n][m]){
            while((i<n) && (str1.charAt(i) != lcs.charAt(k))){
                ans += str1.charAt(i);
                i++;
            }
            while((j<m) && (str2.charAt(j) != lcs.charAt(k))){
                ans += str2.charAt(j);
                j++;
            }
            ans += lcs.charAt(k);
            k++;
            i++;
            j++;
        }

        while(i<n){
            ans += str1.charAt(i);
            i++;
        }
        while(j<m){
            ans += str2.charAt(j);
            j++;
        }
        return ans;

    }
}
