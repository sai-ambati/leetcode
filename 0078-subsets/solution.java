class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();

        solve(nums, 0, al, ans);
        return ans;
        
    }

    public static void solve(int[] arr, int i, List<Integer> al, List<List<Integer>> ans){
        if(i == arr.length){
            ans.add(new ArrayList<>(al));
            return;
        }
        al.add(arr[i]);
        solve(arr, i+1, al, ans);
        al.remove(al.size() - 1);
        solve(arr, i+1, al, ans);
    }
}
