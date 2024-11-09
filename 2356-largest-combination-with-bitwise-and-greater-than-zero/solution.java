class Solution {
    public int largestCombination(int[] candidates) {
        int max = 0;
        for(int i = 0; i<32; i++){
            int count = 0;
            for(int x:candidates){
                if((1<<i & x)>0){
                    count++;
                }
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
