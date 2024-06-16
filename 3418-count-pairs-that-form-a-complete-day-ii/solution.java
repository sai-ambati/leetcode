class Solution {
    public long countCompleteDayPairs(int[] hours) {
        long count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int a;
        int b;
        for(int i = 0; i<hours.length; i++){
            a = hours[i] % 24;
            b = (24 - a)%24;
            if(hm.containsKey(b)){
                count += hm.get(b);
            }
            if(!hm.containsKey(a)){
                hm.put(a,1);
            }
            else{
                hm.put(a, hm.get(a)+1);
            }
            

            // System.out.println(i + " " + count);
        }
        return count;
    }
}
