class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);

        for(int r= 0; r<numRows; r++){
            List<Integer> cols= new ArrayList<>(Collections.nCopies(r+1, 1));

            for(int c = 1; c<r; c++){
                cols.set(c, ans.get(r-1).get(c-1) + ans.get(r-1).get(c));
            }
            ans.add(cols);
        }

        return ans;
    }
}
