class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int count = 0;
        for(int x:derived){
            count += x;
        }

        return count%2==0;
    }
}
