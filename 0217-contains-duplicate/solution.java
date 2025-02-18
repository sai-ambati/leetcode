class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for(int x:nums){
            hs.add(x);
        }
        return hs.size() != nums.length;
    }
}
