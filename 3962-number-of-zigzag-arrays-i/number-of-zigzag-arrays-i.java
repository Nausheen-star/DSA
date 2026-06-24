class Solution {

    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;

        if (n == 1) {
            return m % (int) MOD;
        }

        long[] up = new long[m + 1];
        long[] down = new long[m + 1];

        for (int v = 1; v <= m; v++) {
            up[v] = v - 1;
            down[v] = m - v;
        }

        for (int len = 3; len <= n; len++) {

            long[] newUp = new long[m + 1];
            long[] newDown = new long[m + 1];

            long pref = 0;

            for (int v = 1; v <= m; v++) {
                newUp[v] = pref;
                pref = (pref + down[v]) % MOD;
            }

            long suff = 0;

            for (int v = m; v >= 1; v--) {
                newDown[v] = suff;
                suff = (suff + up[v]) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        for (int v = 1; v <= m; v++) {
            ans = (ans + up[v] + down[v]) % MOD;
        }

        return (int) ans;
    }
}



//Approach-1 (Recursion + Memoization) - TLE
//T.C : O(n*m*m), we have n*m*2 states and we run for loop inside the recursion
//S.C : O(n*m)
// class Solution {
//     int MOD = 1_000_000_007;
//     int N, M;
//     int[][][] t;

//     public int zigZagArrays(int n, int l, int r) {
//         N = n;
//         M = r - l + 1;
//         t = new int[N + 1][M + 1][2];
//         for (int[][] a : t)
//             for (int[] b : a)
//                 Arrays.fill(b, -1);

//         long result = 0;
//         for (int startVal = 1; startVal <= M; startVal++) {
//             //a < b > c < d ...
//             result = (result + solve(1, startVal, true)) % MOD;
//             //a > b < c > d...
//             result = (result + solve(1, startVal, false)) % MOD;
//         }
//         return (int) result;
//     }

//     private int solve(int i, int prevVal, boolean increasing) {
//         if (i == N) { //able to find N elements of zigzag array
//             return 1;
//         }

//         int dir = increasing ? 1 : 0;
//         if (t[i][prevVal][dir] != -1) {
//             return t[i][prevVal][dir];
//         }

//         int result = 0;
//         if (increasing) {
//             for (int nextVal = prevVal + 1; nextVal <= M; nextVal++) {
//                 result = (result + solve(i + 1, nextVal, false)) % MOD;
//             }
//         } else {
//             for (int nextVal = 1; nextVal < prevVal; nextVal++) {
//                 result = (result + solve(i + 1, nextVal, true)) % MOD;
//             }
//         }

//         return t[i][prevVal][dir] = result;
//     }
// }

