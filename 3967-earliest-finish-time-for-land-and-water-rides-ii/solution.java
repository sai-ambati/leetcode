class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        int minEnd1 = Integer.MAX_VALUE;

        int m = landStartTime.length;

        for(int i = 0; i<m; i++){
            minEnd1 = Math.min(minEnd1, landStartTime[i] + landDuration[i]);
        }

        int startTime1 = minEnd1;

        int n = waterStartTime.length;
        int finishTime1 = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            int startTime = Math.max(minEnd1, waterStartTime[i]);
            finishTime1 = Math.min(finishTime1, startTime + waterDuration[i]);
        }


        int minEnd2 = Integer.MAX_VALUE;

        

        for(int i = 0; i<n; i++){
            minEnd2 = Math.min(minEnd2, waterStartTime[i] + waterDuration[i]);
        }

        int startTime2 = minEnd2;

        
        int finishTime2 = Integer.MAX_VALUE;
        for(int i = 0; i<m; i++){
            int startTime = Math.max(minEnd2, landStartTime[i]);
            finishTime2 = Math.min(finishTime2, startTime + landDuration[i]);
        }
        return Math.min(finishTime1, finishTime2);
    }
}
