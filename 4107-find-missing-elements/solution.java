class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int min = nums[0];
        int max = nums[0];
        hs.add(nums[0]);
        for(int x:nums){
            min = Math.min(min, x);
            max = Math.max(max, x);
            hs.add(x);
        }
        List<Integer> ans = new ArrayList<>();
        while(min <= max){
            if(!hs.contains(min)){
                ans.add(min);
            }
            min++;
        }
        return ans;
    }
}
