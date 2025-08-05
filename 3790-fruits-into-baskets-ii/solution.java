class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;

        int ans = 0;

        int[] temp = new int[n];

        for(int i = 0; i<n; i++){
            int j = 0;
            for(; j<n; j++){
                if(temp[j] == 0 && baskets[j] >= fruits[i]){
                    temp[j] = 1;
                    break;
                }
            }
            if(j==n){
                ans++;
            }
        }
        return ans;
    }
}
