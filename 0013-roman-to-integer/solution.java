class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();

        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);

        int n = s.length()-1;
        int ans = hm.get(s.charAt(n));

        for(int i = n-1; i>=0; i--){
            int val = hm.get(s.charAt(i));
            int prev = hm.get(s.charAt(i+1));
            if(val < prev){
                ans -= val;
            }
            else{
                ans += val;
            }
        }
        return ans;
    }
}
