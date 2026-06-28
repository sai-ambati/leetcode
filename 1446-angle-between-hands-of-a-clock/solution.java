class Solution {
    public double angleClock(int hour, int minutes) {
        double h = hour * 30;
        double m = minutes * 5.5;

        return h>m ? Math.min(h-m, 360-(h-m)) : Math.min(m-h, 360-(m-h));
    }
}
