class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int x:asteroids){
            pq.add((long)x);
        }
        Long cs = (long)mass;
        while(pq.size() != 0){
            long temp = pq.poll();
            if(cs < temp){
                return false;
            }
            cs += temp;
        }
        return true;
    }
}
