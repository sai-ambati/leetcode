class Solution {
    public int getLargestOutlier(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int ts = 0;
        for(int i = 0; i<nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
            ts += nums[i];
        }

        int ans = Integer.MIN_VALUE;
        // boolean isModified = false;
        for(int i = 0; i<nums.length; i++){
            int temp = ts - nums[i];
            if(temp%2==0){
                if(temp/2 == nums[i] && hm.getOrDefault(temp/2, 0) > 1){                
                    ans = Math.max(ans, nums[i]);
                }
                else if(temp/2 != nums[i] && hm.getOrDefault(temp/2, 0) >= 1){
                    ans = Math.max(ans, nums[i]);
                }
            }
        }
        return ans;
    }
}
