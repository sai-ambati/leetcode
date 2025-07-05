class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;
        int[] freq = new int[501];
        for(int i:arr){
            freq[i]++;
        }

        int i = 500;
        while(i>0){
            if(freq[i] == i){
                return i;
            }
            i--;
        }
        return -1;
    }
}
