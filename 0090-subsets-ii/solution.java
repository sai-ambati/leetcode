class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<ArrayList<Integer>> hs = new HashSet<>();

        List<Integer> al = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        solve(nums, 0, hs, al, ans);

        return ans;
    }

    public static void solve(int[] nums, int i, HashSet<ArrayList<Integer>> hs, List<Integer> al, List<List<Integer>> ans){
        if(i==nums.length){
            List<Integer> temp = new ArrayList<>(al);
            Collections.sort(temp);
            if(!hs.contains(temp)){
                ans.add(new ArrayList<>(temp));
                hs.add(new ArrayList<>(temp));
                return;
            }
            return;
        }

        al.add(nums[i]);
        solve(nums, i+1, hs, al, ans);
        al.remove(al.size() -1 );
        solve(nums, i+1, hs, al, ans);
    }
}
