class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for(int i = num1; i<= num2; i++){
            int count = countWaves(i);
            ans += count;
        }
        return ans;
    }

    public static int countWaves(int n){
        String str = String.valueOf(n);
        int l = str.length();
        int count = 0;
        for(int i =1; i<l-1; i++){
            int prev = str.charAt(i-1) - '0';
            int cur = str.charAt(i) - '0';
            int next = str.charAt(i+1) - '0';

            if((cur > prev && cur > next) || (cur < prev && cur < next)){
                count++;
            }
        }
        return count;
    }
}
