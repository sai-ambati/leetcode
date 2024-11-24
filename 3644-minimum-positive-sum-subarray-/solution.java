class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();

        int[] ps = new int[n];

        ps[0] = nums.get(0);

        for(int i = 1; i<n; i++){
            ps[i] = nums.get(i) + ps[i-1];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = l; i<=r; i++){
            int temp;
            for(int j = 0; j<=n-i; j++){
                if(j==0){
                    temp = ps[j+i-1];
                }
                else{
                    temp = ps[j+i-1] - ps[j-1];
                }
                if(temp > 0){
                    ans = Math.min(ans, temp);
                }
            }
        }
        if(ans != Integer.MAX_VALUE){
            return ans;
        }
        else{
            return -1;
        }
    }
}
