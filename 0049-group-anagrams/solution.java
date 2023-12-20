class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();

        for(int i = 0; i<strs.length; i++){
            String tempString = sort(strs[i]);

            if(!hm.containsKey(tempString)){
                List<String> ls = new ArrayList<>();
                ls.add(strs[i]);
                hm.put(tempString, ls);
            }

            else{
                List<String> ls = hm.get(tempString);
                ls.add(strs[i]);
                hm.put(tempString, ls);
            }


        }

        List<List<String>> ans= new ArrayList<>();

        hm.forEach((key, value) -> {ans.add(value);});

        return ans;
    }

    static String sort(String string){
        char[] ca = string.toCharArray();
Arrays.sort(ca);
        return new String(ca);
    }
}
