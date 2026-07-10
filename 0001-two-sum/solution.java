class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] ans = new int[2];
        int n = nums.length;
        for(int i = 0; i<n; i++){
            int temp = target - nums[i];

            if(hm.containsKey(temp)){
                ans[0] = hm.get(temp);
                ans[1] = i;
                break;
            }

            hm.put(nums[i], i);
        }

        return ans;
    }
}
