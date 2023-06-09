class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans = letters[0];

        if(ans>target){
            return ans;
        }

        for(int i = 1; i<letters.length; i++){
            if(letters[i] > target ){
                ans = letters[i];
                break;
            }
        }

        return ans;
    }
}
