class Solution {
    public int numRescueBoats(int[] people, int limit) {
        if(people.length == 1){
            return 1;
        }

        Arrays.sort(people);

        int start = 0;
        int end = people.length - 1;

        int count = 0;
        while(start<=end){

            count++;
            if(people[start] + people[end] <= limit){
                // count++;
                start++;
                end--;
            }
            else{
                // count++;
                end--;
            }
        }
        return count;
    }
}
