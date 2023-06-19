class Solution {
    public int largestAltitude(int[] gain) {
        
        int[] temp = new int[gain.length+1];

        int largest = 0;

        temp[0] = 0;

        for(int i = 0; i<gain.length; i++){
            temp[i+1] = temp[i] + gain[i];

            if(temp[i+1] > largest){
                largest = temp[i+1];
            }
        }

        return largest;
    }
}
