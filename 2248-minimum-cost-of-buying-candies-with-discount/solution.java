class Solution {
    public int minimumCost(int[] cost) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

        for(int x:cost){
            pq.add(x);
        }
        int n = pq.size();
        int i = 0;
        int ans = 0;
        while(i<n/3){
            ans += pq.poll() + pq.poll();
            pq.poll();
            i++;
        }
        while(pq.size() != 0){
            ans += pq.poll();
        }

        return ans;
    }
}
