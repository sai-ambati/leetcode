class Solution {
    public int[] findErrorNums(int[] arr) {
        Arrays.sort(arr);
        int[] ans = new int[2];
        int n = arr.length;
        for(int i = 1; i<n; i++){
            if(arr[i]==arr[i-1]){
                ans[0] = arr[i];
                break;
            }
        }
        int temp = 0;
        for(int i =0;i<n; i++){
            temp = temp + i+1 - arr[i];
        }
        ans[1] = temp + ans[0];
        return ans;
    }
}
