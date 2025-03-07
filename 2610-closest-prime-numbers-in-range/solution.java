class Solution {
    public int[] closestPrimes(int left, int right) {
        ArrayList<Integer> al = new ArrayList<>();

        for(int i = left; i<= right; i++){
            if(checkPrime(i)){
                al.add(i);
            }
        }

        int n = al.size();
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int min = Integer.MAX_VALUE;

        for(int i = 1; i<n; i++){
            int diff = al.get(i) - al.get(i-1);
            if(diff < min){
                min = diff;
                ans[0] = al.get(i-1);
                ans[1] = al.get(i);
            }
        }
        return ans;
    }
    public static boolean checkPrime(int n){
        if(n==1){
            return false;
        }
        int i = 2;
        while(i*i <= n){
            if(n%i == 0){
                return false;
            }
            i++;
        }
        return true;
    }
}
