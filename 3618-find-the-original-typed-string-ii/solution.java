class Solution {
    public int possibleStringCount(String word, int k) {
        int n = word.length();
        if(k==n){
            return 1;
        }
        ArrayList<Integer> al = new ArrayList<>();

        int count = 0;
        int start = 0;
        int end = 0;
        while(start < n && end < n){
            char ch = word.charAt(start);
            end = start;
            count = 0;
            while(end < n && word.charAt(end) == ch){
                count++;
                end++;
            }
            al.add(count);
            start = end;
        }
        // System.out.println(al.toString());

        int gl = al.size();
        int mod = 1_000_000_007;
        long total = 1;
        for(int x:al){
            total = (total * x)%mod;
        }

        if(k <= gl){
            return (int)total;
        }

        int[][] dp = new int[gl+1][k];
        dp[0][0] = 1;
        // System.out.println();
        // System.out.println(Arrays.toString(dp[0]));
        for(int i = 1; i<=gl; i++){
            int windowSize = al.get(i-1);
            int[] ps = new int[k];
            ps[0] = dp[i-1][0];
            for(int j = 1; j<k; j++){
                ps[j] = (ps[j-1]%mod + dp[i-1][j]%mod)%mod;
            }
            // System.out.println(Arrays.toString(ps));
        
            dp[i][i] = 1;
            for(int j = i+1; j<k; j++){
                if(j <= windowSize){
                    dp[i][j] = ps[j-1];
                }
                // else if(j == windowSize){
                //     dp[i][j] = ps[j-1];
                // }
                else{
                    dp[i][j] = (ps[j-1]%mod - ps[j-windowSize-1]%mod + mod)%mod;
                }
            }
            // System.out.println(Arrays.toString(dp[i]));
        }
        int temp = 0;
        for(int i = 0; i<k; i++){
            temp = (temp%mod + dp[gl][i]%mod)%mod;
        }
        return (int)((total - temp + mod)%mod);
    }
}
