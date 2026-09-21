
//Approach-3 (Using count of remainders of previous subarrays)
//T.C : O(n*k)
//S.C : O(k)
class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;

        long[] result = new long[k];
        long[] prevCount = new long[k];

        for (int i = 0; i < n; i++) {

            //index i par end hone waale all subarrays
            long[] currCount = new long[k];

            int currElementRemainder = nums[i] % k;
            currCount[currElementRemainder]++;

            for (int oldRem = 0; oldRem <= k - 1; oldRem++) {
                int newRemain = (int) (((long) oldRem * nums[i] % k) % k);

                currCount[newRemain] += prevCount[oldRem];
            }

            prevCount = currCount;

            for (int x = 0; x <= k - 1; x++) {
                result[x] += prevCount[x];
            }
        }

        return result;
    }
}



// //Approach-1 (Super Brute Force)) - TLE
// //T.C : O(n^3)
// //S.C : O(1)
// class Solution {
//     public int solve(int i, int j, int[] nums, int k) {
//         long product = 1;
//         for (int t = i; t <= j; t++) {
//             product = (product * nums[t]) % k;
//         }
//         return (int) product;
//     }

//     public long[] resultArray(int[] nums, int k) {
//         int n = nums.length;
//         long[] result = new long[k];

//         for (int i = 0; i < n; i++) {
//             for (int j = i; j < n; j++) {
//                 int x = solve(i, j, nums, k);
//                 result[x]++;
//             }
//         }

//         return result;
//     }
// }



// //Approach-2 (Improved Brute Force) - MLE
// //T.C : O(n^3)
// //S.C : O(n^2) for memo - Causing MLE
// class Solution {
//     public int solve(int i, int j, int[] nums, int k, int[][] memo) {
//         if (memo[i][j] != -1) return memo[i][j];

//         if (i == j) {
//             return memo[i][j] = nums[i] % k;
//         }
//         int prev = solve(i, j - 1, nums, k, memo);

//         return memo[i][j] = (prev * (nums[j] % k)) % k;
//     }

//     public long[] resultArray(int[] nums, int k) {
//         int n = nums.length;
//         int[][] memo = new int[n][n];
//         for (int[] row : memo) {
//             Arrays.fill(row, -1);
//         }
//         long[] result = new long[k];

//         for (int i = 0; i < n; i++) {
//             for (int j = i; j < n; j++) {
//                 int x = solve(i, j, nums, k, memo);
//                 result[x]++;
//             }
//         }

//         return result;
//     }
// }

