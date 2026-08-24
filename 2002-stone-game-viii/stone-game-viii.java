import java.util.*;

class Solution {

    int n;
    int[] memo;

    private int solve(int i, int[] prefixSum) {

        // Base case
        if (i == n - 1) {
            return prefixSum[n - 1];
        }

        // Already calculated
        if (memo[i] != Integer.MIN_VALUE) {
            return memo[i];
        }

        // Take current prefix
        int take = prefixSum[i] - solve(i + 1, prefixSum);

        // Skip current prefix
        int skip = solve(i + 1, prefixSum);

        return memo[i] = Math.max(take, skip);
    }

    public int stoneGameVIII(int[] stones) {

        n = stones.length;
        memo = new int[n];

        Arrays.fill(memo, Integer.MIN_VALUE);

        // Build prefix sum
        int[] prefixSum = new int[n];
        prefixSum[0] = stones[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i];
        }

        return solve(1, prefixSum);
    }
}