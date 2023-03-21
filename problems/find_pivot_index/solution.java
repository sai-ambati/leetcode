class Solution {
    public int pivotIndex(int[] nums) {
        int ps=0;
        int cs=0;
        int ts=0;

        for(int num:nums){
            ts += num;
        }
        for(int i=0; i<nums.length; i++){
            cs = ps+nums[i];
            if(ps == (ts-cs)){
                return i;
            }
            ps = cs;
        }

        return -1;
    }
}