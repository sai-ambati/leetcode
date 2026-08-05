import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] inv : invocations) {
            adj.get(inv[0]).add(inv[1]);
        }
        
        
        boolean[] isSuspicious = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(k);
        isSuspicious[k] = true;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor : adj.get(curr)) {
                if (!isSuspicious[neighbor]) {
                    isSuspicious[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        
        
        boolean canRemove = true;
        for (int[] inv : invocations) {
            if (!isSuspicious[inv[0]] && isSuspicious[inv[1]]) {
                canRemove = false;
                break;
            }
        }
        
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!canRemove || !isSuspicious[i]) {
                result.add(i);
            }
        }
        
        return result;
    }
}

