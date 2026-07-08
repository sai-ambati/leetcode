class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
    
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[m-1][n-1] == 1) return 0;

        if(m==1 && n==1 && obstacleGrid[0][0] == 0) return 1;

        int[][] dp = new int[m][n];

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = -1;
                    continue;
                }
                if(i==0 && j==0){
                    obstacleGrid[i][j] = 0;
                }
                else if(i==0){
                    if(obstacleGrid[i][j-1] != -1){
                        obstacleGrid[i][j] = 1;
                    }
                    else{
                        obstacleGrid[i][j] = -1;
                    }
                }
                else if(j==0){
                    if(obstacleGrid[i-1][j] != -1){
                        obstacleGrid[i][j] = 1;
                    }
                    else{
                        obstacleGrid[i][j] = -1;
                    }
                }

                else{
                    if(obstacleGrid[i-1][j] != -1 && obstacleGrid[i][j-1] != -1){
                        obstacleGrid[i][j] = obstacleGrid[i][j-1] + obstacleGrid[i-1][j];
                    }
                    else if(obstacleGrid[i-1][j] == -1){
                        obstacleGrid[i][j] = obstacleGrid[i][j-1];
                    }
                    else{
                        obstacleGrid[i][j] = obstacleGrid[i-1][j];
                    }
                }
            }
        }
        return obstacleGrid[m-1][n-1] == -1 ? 0: obstacleGrid[m-1][n-1];
    }
}
