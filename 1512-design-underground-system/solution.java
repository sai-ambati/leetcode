class UndergroundSystem {

    private final Map<Integer, Pair<String, Integer>> passenger;
    private final Map<String, int[]> stationDistance;


    public UndergroundSystem() {
        this.passenger = new HashMap<>();
        this.stationDistance = new HashMap<>();
    }

    
    public void checkIn(int id, String stationName, int t) {
        this.passenger.put(id, new Pair(stationName, t));
    }

    
    public void checkOut(int id, String stationName, int t) {
        final Pair<String, Integer> passenger  = this.passenger.get(id);

        this.stationDistance.putIfAbsent(passenger.getKey() + "-" + stationName, new int[2]);

        final int[] sum = this.stationDistance.get(passenger.getKey() + "-" + stationName);

        sum[0] += t - passenger.getValue();
        sum[1]++;

        this.passenger.remove(id);
    }

    
    public double getAverageTime(String startStation, String endStation) {
        final int[] sum = this.stationDistance.get(startStation + "-" + endStation);
        return (double) sum[0] / sum[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
