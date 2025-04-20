class Solution {
  public int numRabbits(int[] answers) {
    int res = 0;
    int[] count = new int[1000]; 
    for (int num : answers) {
      if (count[num] != 0) { 
        count[num]--;
      } else if (num == 0) { 
        res++;
      } else {
        count[num] = num;
        res += num + 1;
      }
    }
    return res;
  }
}
