class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        boolean[] visited = new boolean[n + 1];
        
        backtrack(0, res, visited, n);
        return res;
    }
    
    private boolean backtrack(int i, int[] res, boolean[] visited, int n) {
        if (i == res.length) {
            return true;
        }
        if (res[i] > 0) {
            return backtrack(i + 1, res, visited, n);
        }
        for (int num = n; num >= 1; num--) {
            if (visited[num]) {
                continue;
            }
            if (num == 1) {
                res[i] = 1;
                visited[1] = true;
                if (backtrack(i + 1, res, visited, n)) {
                    return true;
                }
                res[i] = 0;
                visited[1] = false;
            } else {
                int targetIdx = i + num;
                if (targetIdx < res.length && res[targetIdx] == 0) {
                    res[i] = num;
                    res[targetIdx] = num;
                    visited[num] = true;
                    
                    if (backtrack(i + 1, res, visited, n)) {
                        return true;
                    }
                    res[i] = 0;
                    res[targetIdx] = 0;
                    visited[num] = false;
                }
            }
        }
        return false; 
    }
}

