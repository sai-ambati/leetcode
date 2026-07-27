class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        int m = series1.length;
        int n = series2.length;

        ArrayList<Integer> al = new ArrayList<>();
        int left = 0;
        int right = 0;

        while(left < m && right < n){
            if(series1[left][0] < series2[right][0]){
                al.add(series1[left][0]);
                left++;
            }
            else if(series1[left][0] > series2[right][0]){
                al.add(series2[right][0]);
                right++;
            }
            else{
                al.add(series1[left][0]);
                left++;
                right++;
            }
        }
        while(left < m){
            al.add(series1[left][0]);
            left++;
        }
        while(right < n){
            al.add(series2[right][0]);
            right++;
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<al.size(); i++){
            int target = al.get(i);
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(target);
            temp.add(get(series1, target) + get(series2, target));
            ans.add(temp);
        }
        return ans;
    }

    public static int get(int[][] series, int target){
        int n = series.length;
        int start = 0;
        int end = n-1;
        int ans = -1;
        while(start<=end){
            int mid = (start + end)/2;
            if(series[mid][0] >= target){
                ans = series[mid][1];
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans == -1 ? 0 : ans;
    }
}
