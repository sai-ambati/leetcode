class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;

        int[] temp = new int[n];

        for(int i = 0; i<queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];

            temp[l] -= 1;
            if(r <n-1){
                temp[r+1] += 1;
            }
        }

        for(int i = 1; i<n; i++){
            temp[i] += temp[i-1];
        }

        for(int i = 0; i<n; i++){
            temp[i] += nums[i];
            // if(temp[i] < 0){
            //     temp[i] = 0;
            // }
            // System.out.print(temp[i] + " ");
            if(temp[i] > 0){
                return false;
            }
        }

        
        return true;
    }
}
