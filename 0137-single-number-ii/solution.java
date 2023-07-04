// class Solution {
//     public int singleNumber(int[] nums) {
//         int[] temp = new int[32];

//         for(int i = 0; i<nums.length; i++){
//             for(int j = 0; j<32; j++){
//                 int b = (nums[i] & (1<<j)) > 0 ? 1: 0;
//                 temp[j] += b;
//             }
//         }

//         int ans = 0;
//         for(int i = 0; i<32; i++){
//             temp[i] = temp[i]%3;
//             ans = ans + (temp[i] << i);
//         }

//         return ans;
//     }
// }








class Solution {
  public int singleNumber(int[] nums) {
    int ans = 0;

    for (int i = 0; i < 32; ++i) {
      int sum = 0;
      for (final int num : nums)
        sum += num >> i & 1;
      sum %= 3;
      ans |= sum << i;
    }

    return ans;
  }
}
