import java.util.Arrays;

class Solution {
    // Memoization table: [index][prev_digit][prev2_digit][is_tight][is_started]
    // Max digits for 10^15 is 16. 
    // Digits take values from 0-9. Value 10 represents an empty/unset padding slot.
    private long[][][][][] memoCount;
    private long[][][][][] memoWaviness;

    public long totalWaviness(long num1, long num2) {
        return countWaviness(num2) - countWaviness(num1 - 1);
    }

    private long countWaviness(long limit) {
        if (limit < 100) {
            return 0; // Numbers with fewer than 3 digits have 0 waviness
        }

        String s = Long.toString(limit);
        int n = s.length();

        memoCount = new long[n][11][11][2][2];
        memoWaviness = new long[n][11][11][2][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 10; j++) {
                for (int k = 0; k <= 10; k++) {
                    for (int t = 0; t < 2; t++) {
                        Arrays.fill(memoCount[i][j][k][t], -1);
                        Arrays.fill(memoWaviness[i][j][k][t], -1);
                    }
                }
            }
        }

        // Invoke DP: index=0, prev=10 (unset), prev2=10 (unset), tight=1, started=0
        long[] result = dp(0, 10, 10, 1, 0, s);
        return result[1];
    }

    // Returns array: {valid_numbers_count, cumulative_waviness}
    private long[] dp(int idx, int prev, int prev2, int tight, int started, String s) {
        // Base case: Finished assembling the number
        if (idx == s.length()) {
            return new long[]{started == 1 ? 1 : 0, 0};
        }

        // Return cached results if available
        if (memoCount[idx][prev][prev2][tight][started] != -1) {
            return new long[]{
                memoCount[idx][prev][prev2][tight][started], 
                memoWaviness[idx][prev][prev2][tight][started]
            };
        }

        long totalCount = 0;
        long totalWaviness = 0;
        int maxDigit = (tight == 1) ? (s.charAt(idx) - '0') : 9;

        for (int d = 0; d <= maxDigit; d++) {
            int nextTight = (tight == 1 && d == maxDigit) ? 1 : 0;
            int nextStarted = started;
            int nextPrev = d;
            int nextPrev2 = prev;

            long immediateWavinessGain = 0;

            if (started == 0 && d == 0) {
                // Keep skipping leading zeros safely
                nextPrev = 10;
                nextPrev2 = 10;
            } else {
                nextStarted = 1;
                // If a valid sequence window of 3 digits exists (prev2, prev, current d)
                // verify whether 'prev' functions as a peak or valley
                if (prev2 != 10 && prev != 10) {
                    if ((prev > prev2 && prev > d) || (prev < prev2 && prev < d)) {
                        immediateWavinessGain = 1;
                    }
                }
            }

            long[] nextStateResult = dp(idx + 1, nextPrev, nextPrev2, nextTight, nextStarted, s);
            long pathsCount = nextStateResult[0];
            long internalWaviness = nextStateResult[1];

            totalCount += pathsCount;
            // Cumulative waviness = future paths' waviness + (immediate gain * total paths utilizing it)
            totalWaviness += internalWaviness + (immediateWavinessGain * pathsCount);
        }

        memoCount[idx][prev][prev2][tight][started] = totalCount;
        memoWaviness[idx][prev][prev2][tight][started] = totalWaviness;

        return new long[]{totalCount, totalWaviness};
    }
}

