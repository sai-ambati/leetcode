class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> al = new ArrayList<>();

        al.add(1);
        int n = rowIndex;
        int d = 1;

        for(int i = 1; i<=rowIndex/2; i++){
            long temp = (long)al.get(i-1) * n / d;
            al.add((int)temp);
            n--;
            d++;
        }
        for(int i = rowIndex/2 + 1; i<=rowIndex; i++){
            int temp = rowIndex - i;
            al.add(al.get(temp));
        }
        return al;
    }
}
