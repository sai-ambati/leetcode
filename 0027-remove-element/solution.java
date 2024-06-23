class Solution {
    public int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length -1;
        int temp;
        while(start <= end){
            while(start < nums.length && nums[start] != val){
                start++;
            }
            while(end >=0 && nums[end] == val){
                end--;
            }

            if(start<=end){
                temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
            System.out.println(Arrays.toString(nums));
        }

        return start;
    }
}
