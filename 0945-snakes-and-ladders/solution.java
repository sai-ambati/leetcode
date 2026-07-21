class Solution {
    public int snakesAndLadders(int[][] board) {
        
        ArrayList<ArrayList<Integer>> adj;

        adj = createAdjList(board);

        // print(adj);

        int v = adj.size();
        int[] dist = new int[v];
        Arrays.fill(dist, -1);
        dfs(adj, 1, dist);
        // System.out.println(Arrays.toString(dist));
        return dist[v-1];
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, int node, int[] dist) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        dist[node] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nbr:adj.get(cur)){
                if(dist[nbr] == -1){
                    q.add(nbr);
                    dist[nbr] = dist[cur] + 1;
                }
            }
        }
    }

    private static void print(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();

        for(int i = 0; i<n; i++){
            System.out.println("node " + i + ":");
            for(int nbr:adj.get(i)){
                System.out.print(nbr + "\t");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> createAdjList(int[][] board) {
        int n = board.length;
        int l = n*n + 1;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(l);

        for(int i = 0; i<l; i++){
            adj.add(new ArrayList<>());
        }
        int k = 1;
        int[] temp = new int[l];
        boolean leftToRight = true;
        for(int i = n-1; i>=0; i--){
            if(leftToRight){
                for(int j = 0; j<n; j++){
                    temp[k] = board[i][j];
                    k++;
                }
            }
            else{
                for(int j = n-1; j>=0; j--){
                    temp[k] = board[i][j];
                    k++;
                }
            }
            leftToRight = !leftToRight; 
        }
        boolean[] visited = new boolean[l];
        for(int i = 1; i<l ; i++){
            int start = i;
            for(int j = 1; j<=6; j++){
                int end = j+i;
                if(end < l && visited[end]){
                    continue;
                }
                if(end <l && temp[end] != -1){
                    end = temp[end];
                }
                if(end<l){
                    adj.get(start).add(end);
                }
            }
        }
        return adj;
    }
}
