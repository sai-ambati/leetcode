class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        int size = s.length();

        int n = size/k;

        HashMap<String, Integer> hm = new HashMap<>();

        for(int i = 0; i<size; i = i+n){
            String temp = s.substring(i, i+n);
            hm.put(temp, hm.getOrDefault(temp, 0) + 1);
        }

        for(int i = 0; i<size; i = i+n){
            String temp = t.substring(i, i+n);
            if(!hm.containsKey(temp)){
                return false;
            }
            else{
                hm.put(temp, hm.get(temp)-1);
            }
        }

        for(String x:hm.keySet()){
            if(hm.get(x)!=0){
                return false;
            }
        }
        return true;
    }
}
