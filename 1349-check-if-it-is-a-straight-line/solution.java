class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int a = coordinates[1][0] - coordinates[0][0];
        int b = coordinates[1][1] - coordinates[0][1];

        for(int i = 2; i<coordinates.length; i++){
            if((b*(coordinates[i][0] - coordinates[0][0])) != (a*(coordinates[i][1] - coordinates[0][1]))){
                return false;
            }
        }

        return true;
    }
}
