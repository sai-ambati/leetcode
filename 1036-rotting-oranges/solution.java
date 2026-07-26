class Solution {
    public int orangesRotting(int[][] grid) {

        // dimesnsions of the given grid or matrix
        int m = grid.length;
        int n = grid[0].length;

        // creating a distance matrix to track whether a cell is visited or not and finding the no of days taken to be rotten
        int[][] dist = new int[m][n];

        for(int i =0; i<m; i++){
            Arrays.fill(dist[i], -1);
        }

        // creating a queue for multisource bfs

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 2){
                    // pushing a rotten orange cell into queue
                    q.add(new int[]{i, j}); 
                    // marking the source distance as zero
                    dist[i][j] = 0;
                }
            }
        }

        // directions for 4 way connectivity travel
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        // bfs code
        while(!q.isEmpty()){
            int[] front = q.poll();
            int i = front[0];
            int j = front[1];

            for(int k = 0; k<4; k++){
                int ni = i+dx[k];
                int nj = j+dy[k];

                if(ni<0 || nj<0 || ni>=m || nj>=n || grid[ni][nj] == 0){
                    continue;
                }

                if(grid[ni][nj] == 1){
                    grid[ni][nj] = 2;
                    dist[ni][nj] = dist[i][j] + 1;
                    q.add(new int[]{ni, nj});
                }
            }
        }

        int ans = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
                ans = Math.max(ans, dist[i][j]);
            }
        }
        return ans;
    }
}
