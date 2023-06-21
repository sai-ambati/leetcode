class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> hs = new HashSet<>();

        for(int i = 0; i<allowed.length(); i++){
            hs.add(allowed.charAt(i));
        }

        int count  = 0;


        for(int i = 0; i<words.length; i++){
            int j = 0;
            for(; j<words[i].length(); j++){
                if(!hs.contains(words[i].charAt(j))){
                    break;
                }
            }

            if(j==words[i].length()){
                count++;
            }
        }

        return count;
    }
}
