import java.util.Arrays;

class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        int totalInitialEnergy = 0;
        int currentEnergy = 0;

        for (int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];

            if (currentEnergy < minimum) {
                totalInitialEnergy += (minimum - currentEnergy);
                currentEnergy = minimum;
            }
            
            currentEnergy -= actual;
        }

        return totalInitialEnergy;
    }
}

