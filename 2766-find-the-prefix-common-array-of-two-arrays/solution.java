class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = A.length;
        for(int i=1; i<=n; i++){
            hm.put(i, 2);
        }
        int[] ans = new int[n];

        for(int i = 0; i<n; i++){

            hm.put(A[i], hm.get(A[i])-1);
            hm.put(B[i], hm.get(B[i])-1);
            if(A[i] == B[i]){
                hm.remove(A[i]);
            }
            else{
                if(hm.get(A[i]) == 0){
                    hm.remove(A[i]);
                }
                if(hm.get(B[i]) == 0){
                    hm.remove(B[i]);
                }
            }
            ans[i] = n-hm.size();
        }
        return ans;
    }
}
