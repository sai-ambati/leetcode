class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj;
        adj = createGraph(n, edges);
        
        boolean[] visited = new boolean[n];
        int ans = 0;
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                int[] counts = new int[2];
                dfsHelper(adj, i, visited, counts);
                int v_count = counts[0];
                int e_count = counts[1]/2;
                if(e_count == (v_count*(v_count-1))/2){
                    ans++;
                }
            }
        }

        return ans;
    }

        // visited[node] = true;
    public static void dfsHelper(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited, int[] counts){
        visited[node] = true;
        counts[0]++;
        counts[1] += adj.get(node).size();
        for(int nbr:adj.get(node)){
            if(!visited[nbr]){
                dfsHelper(adj, nbr, visited, counts);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> createGraph(int v, int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for(int i = 0; i<v; i++){
            adj.add(new ArrayList<>());
        }

        int e = edges.length;
        for(int i = 0; i<e; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        return adj;
    }
}
