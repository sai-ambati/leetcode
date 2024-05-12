class Solution {
    public int findGCD(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] > largest){
                largest = nums[i];
            }
            if(nums[i] < smallest){
                smallest = nums[i];
            }
        }

        return gcd(smallest, largest);
    }

    public static int gcd(int a, int b){
        int temp;
        while(b%a != 0){
            temp = b%a;
            b = a;
            a = temp;
        }

        return a;
    }
}
