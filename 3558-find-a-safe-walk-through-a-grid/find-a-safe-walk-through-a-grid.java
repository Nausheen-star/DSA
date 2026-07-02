class Solution {

    int m, n;
    Boolean[][][] dp;

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        m = grid.size();
        n = grid.get(0).size();

        dp = new Boolean[m][n][health + 1];

        return dfs(0, 0, health, grid);
    }

    private boolean dfs(int i, int j, int health, List<List<Integer>> grid) {

        // Out of bounds
        if (i < 0 || i >= m || j < 0 || j >= n)
            return false;

        // Already visited in current path
        if (grid.get(i).get(j) == -1)
            return false;

        // Lose health if current cell is unsafe
        health -= grid.get(i).get(j);

        // Health must remain positive
        if (health <= 0)
            return false;

        // Reached destination
        if (i == m - 1 && j == n - 1)
            return true;

        if (dp[i][j][health] != null)
            return dp[i][j][health];

        int temp = grid.get(i).get(j);
        grid.get(i).set(j, -1); // mark visited

        boolean ans =
                dfs(i + 1, j, health, grid) ||   // Down
                dfs(i - 1, j, health, grid) ||   // Up
                dfs(i, j + 1, health, grid) ||   // Right
                dfs(i, j - 1, health, grid);     // Left

        grid.get(i).set(j, temp); // backtrack

        return dp[i][j][health] = ans;
    }
}