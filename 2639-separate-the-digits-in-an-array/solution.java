class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<String> al = new ArrayList<>();
        for(int n:nums){
            String[] temp = (String.valueOf(n)).split("");
            Collections.addAll(al, temp);
        }

        int size = al.size();

        int[] ans = new int[size];

        for(int i = 0; i<size; i++){
            ans[i] = al.get(i).charAt(0) - '0';
        }

        return ans;
    }
}
