class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        for(int i = 1; i<n-1; i++){
            if(arr[i]-arr[i-1] != arr[i+1]-arr[i]){
                return false;
            }
        }
        return true;
    }
}
