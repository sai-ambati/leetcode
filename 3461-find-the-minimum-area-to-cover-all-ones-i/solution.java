class Solution {
    public int minimumArea(int[][] grid) {
        int sr=-1;
        int sc=-1;
        int er=-1;
        int ec=-1;
        int rl = grid.length;
        int cl = grid[0].length;
        int row; 
        int col;
        for(row = 0; row<rl;row++){
            for(col = 0; col<cl; col++){
                if(grid[row][col] == 1){
                    sr = row;
                    break;
                }
            }
            if(col<cl && grid[row][col]==1){
                sr = row;
                break;
            }
        }

        for(row = rl-1; row>=0;row--){
            for(col = 0; col<cl; col++){
                if(grid[row][col] == 1){
                    er = row;
                    break;
                }
            }
            if(col<cl && grid[row][col]==1){
                er = row;
                break;
            }
        }
        
        for(col = 0; col<cl;col++){
            for(row = 0; row<rl; row++){
                if(grid[row][col] == 1){
                    sc = col;
                    break;
                }
            }
            if(row<rl && grid[row][col]==1){
                sc = col;
                break;
            }
        }
                
        for(col = cl-1; col>=0;col--){
            for(row = 0; row<rl; row++){
                if(grid[row][col] == 1){
                    ec = col;
                    break;
                }
            }
            if(row<rl && grid[row][col]==1){
                ec = col;
                break;
            }
        }
        
        // System.out.println(sr+" " + er + " " + sc + " " + ec);
        int ans = (er-sr+1) * (ec-sc+1);
        return ans;
        
    }
}
