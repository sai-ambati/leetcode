class Solution {
    public int scoreDifference(int[] nums) {
        int[] act = new int[2];

        int active = 0;


        int n = nums.length;

        for(int i = 0; i<n; i++){
            // System.out.println(i + " " + active + " " + act[0] + " " + act[1]);
            if(nums[i]%2 != 0){
                active = 1-active;
            }
            if((i+1)%6==0){
                active = 1-active;
            }

            act[active] += nums[i];

            // System.out.println(i + " " + active + " " + act[0] + " " + act[1]);
        }

        return act[0] - act[1];
    }

}
