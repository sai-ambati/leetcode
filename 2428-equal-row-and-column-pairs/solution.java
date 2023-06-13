class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<ArrayList<Integer>, Integer> hm = new HashMap<>();

        

        for(int i =0 ; i<grid.length; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j<grid[0].length; j++){
                temp.add(grid[i][j]);
            }
            // if(!hm.containsValue(temp)){
            //     hm.put(temp, 1);
            // }
            // else{
            //     hm.put(temp, hm.getOrDefault(temp,0) + 1);
            // }

            hm.put(temp, hm.getOrDefault(temp,0) + 1);
        }

        int ans = 0;
        HashMap<ArrayList<Integer>, Integer> hm2 = new HashMap<>();
        for(int i = 0; i<grid.length ; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j<grid[0].length; j++){
                temp.add(grid[j][i]);
            }

            hm2.put(temp, hm2.getOrDefault(temp,0) + 1);

            if(hm.containsKey(temp)){
                ans = ans + hm.get(temp)*hm2.get(temp) - hm.get(temp)*(hm2.get(temp)-1);
            }

        }

        // int ans = 0;
        // for(ArrayList<Integer> al:hm){
        //     if(hm2.containsValue(al)){
        //         ans += hm.get(al)*hm2.get(a2);
        //         hm.put(al,0);
        //         hm2.put(al,0);
        //     }
        // }

        return ans;
    }
}
