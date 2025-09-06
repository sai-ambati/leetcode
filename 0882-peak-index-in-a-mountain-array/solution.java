class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;

        int start = 0;
        int end = n-1;

        if(arr[1] > arr[0] && arr[1] > arr[2]){
            return 1;
        }
        if(arr[n-2] > arr[n-1] && arr[n-2] > arr[n-3]){
            return n-2;
        }
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return mid;
            }
            else if(arr[mid] > arr[mid+1]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }
}
