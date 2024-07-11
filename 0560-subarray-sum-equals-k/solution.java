class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        for(int i = 1; i<n; i++){
            nums[i] += nums[i-1];
        }
        // for(int x:nums){
        //     System.out.print(x + " ");
        // }
        // System.out.println();

        int count = 0;
        for(int i = 0; i<n; i++){
            int sum = 0;
            for(int j = i; j<n; j++){
                sum = nums[j];
                if(i>0){
                    sum -= nums[i-1];
                }
                if(sum == k){
                    count++;
                }
                // System.out.println(i + " " + j + " " + count);
            }
            // System.out.println();
            
        }
        return count;
    }
}
