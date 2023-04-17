class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        int max = Integer.MIN_VALUE;

        for(int x:candies){
            if(x>max){
                max = x;
            }
        }

        List<Boolean> ans = new ArrayList<>();

        for(int x:candies){
            if(x+extraCandies >= max){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }

        return ans;
    }
}
