class Solution {
    public int minPathSum(int[][] grid) {

        // for(int i=1; i<grid[0].length; i++){
        //     grid[0][i] += grid[0][i-1];
        // }
        
        // for(int i=1; i<grid.length; i++){
        //     grid[i][0] += grid[i-1][0];
        // }        
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length; j++){
                if(i==0 && j==0){
                    grid[i][j] = grid[i][j];
                }
                else if(i==0){
                    grid[i][j] += grid[i][j-1];
                }
                else if(j==0){
                    grid[i][j] += grid[i-1][j];
                }
                else{
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }

            }
        }

        return grid[grid.length-1][grid[0].length-1];
    }
}
