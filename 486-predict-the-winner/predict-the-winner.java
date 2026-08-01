//T.C: O(n²)
// S.C: O(n²)

class Solution {

    int[][] dp;

    private int maxDiff(int[] nums, int left, int right) {

        if (left == right)
            return nums[left];

        if (dp[left][right] != Integer.MIN_VALUE)
            return dp[left][right];

        int takeLeft = nums[left] - maxDiff(nums, left + 1, right);
        int takeRight = nums[right] - maxDiff(nums, left, right - 1);

        return dp[left][right] = Math.max(takeLeft, takeRight);
    }

    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;
        dp = new int[n][n];

        for (int[] row : dp)
            Arrays.fill(row, Integer.MIN_VALUE);

        return maxDiff(nums, 0, n - 1) >= 0;
    }
}

//T.C: O(n²)
// S.C: O(n²)
// class Solution {

//     int[][] dp;

//     private int solve(int[] nums, int left, int right) {

//         if (left > right)
//             return 0;

//         if (left == right)
//             return nums[left];

//         if (dp[left][right] != -1)
//             return dp[left][right];

//         int takeLeft = nums[left] +
//                 Math.min(solve(nums, left + 2, right),
//                          solve(nums, left + 1, right - 1));

//         int takeRight = nums[right] +
//                 Math.min(solve(nums, left, right - 2),
//                          solve(nums, left + 1, right - 1));

//         return dp[left][right] = Math.max(takeLeft, takeRight);
//     }

//     public boolean predictTheWinner(int[] nums) {

//         int n = nums.length;
//         dp = new int[n][n];

//         for (int[] row : dp)
//             Arrays.fill(row, -1);

//         int total = 0;
//         for (int num : nums)
//             total += num;

//         int player1 = solve(nums, 0, n - 1);
//         int player2 = total - player1;

//         return player1 >= player2;
//     }
// }