class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
       int n = nums.length;
       Arrays.sort(nums);
       int[] count = new int[n];
       int[] lastIndx = new int[n];
       Arrays.fill(count,1);
       Arrays.fill(lastIndx,-1);
       int maxL = 1, maxI = 0;
       List<Integer> answer = new ArrayList<>();
       for(int i=1;i<n;i++){
        for(int j=0;j<i;j++){
            if(nums[i]%nums[j] == 0 && count[j]+1 > count[i]){
                count[i] = count[j]+1;
                lastIndx[i] = j;
            }
          }
        if(maxL < count[i]){
            maxL = count[i];
            maxI = i;
        }
       }

       while(maxI != -1){
        answer.add(nums[maxI]);
        maxI =  lastIndx[maxI];
       }
       return answer; 
    }
}
