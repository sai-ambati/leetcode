class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int prev = 0;

        int ans = -1;
        int longestTime = 0;

        for(int i = 0; i<events.length; i++){
            int time = events[i][1] - prev;
            if(time > longestTime){
                ans = events[i][0];
                longestTime = time;
            }
            else if (time == longestTime){
                ans = Math.min(ans, events[i][0]);
                longestTime = time;
            }
            prev = events[i][1];
        }
        return ans;
    }
}
