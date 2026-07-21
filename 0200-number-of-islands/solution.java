class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfsHelper(grid, visited, i, j, m, n);
                    count++;
                }
            }
        }

        return count;
    }

    public static void dfsHelper(char[][] grid, boolean[][] visited, int i, int j, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] == '0' || visited[i][j]){
            return;
        }

        visited[i][j] = true;
        
        dfsHelper(grid, visited, i+1, j, m, n);
        dfsHelper(grid, visited, i-1, j, m, n);
        dfsHelper(grid, visited, i, j+1, m, n);
        dfsHelper(grid, visited, i, j-1, m, n);
    }
}
