//Approach-5 (using different recursion style + Using BluePrint for solving palindromic DP problems as above for O(1) isPalindrome)
//T.C : O(n^2)
//S.C : O(n^2)
class Solution {
    boolean[][] isPalindrome;
    int[] t;

    public int solve(int n, int k) {
        if (n < k) return 0;

        if (t[n] != -1)
            return t[n];

        int result = solve(n - 1, k); //ignore the current character s[n-1]

        int j = n - 1;
        //end the current palindrome at the current character s[n-1]
        for (int i = 0; j - i + 1 >= k; i++) {
            if (isPalindrome[i][j]) {
                result = Math.max(result, 1 + solve(i, k));
            }
        }

        return t[n] = result;
    }

    public int maxPalindromes(String s, int k) {
        int n = s.length();
        isPalindrome = new boolean[n][n];

        for (int L = 1; L <= n; L++) {
            for (int i = 0; i + L <= n; i++) {
                int j = i + L - 1;

                if (i == j) {
                    isPalindrome[i][i] = true;
                } else if (i + 1 == j) {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1];
                }
            }
        }

        t = new int[n + 1];
        Arrays.fill(t, -1);
        return solve(n, k);
    }
}


// //Approach-6 (Bottom-up version of Approach-5 above)
// //T.C : O(n^2)
// //S.C : O(n^2)
// class Solution {
//     boolean[][] isPalindrome;
//     int[] t;

//     public int maxPalindromes(String s, int k) {
//         int n = s.length();
//         isPalindrome = new boolean[n][n];

//         for (int L = 1; L <= n; L++) {
//             for (int i = 0; i + L <= n; i++) {
//                 int j = i + L - 1;

//                 if (i == j) {
//                     isPalindrome[i][i] = true;
//                 } else if (i + 1 == j) {
//                     isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));
//                 } else {
//                     isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1];
//                 }
//             }
//         }

//         t = new int[n + 1];
//         //base case
//         for (int len = 0; len < k; len++) {
//             t[len] = 0; // if (n < k) return 0;
//         }

//         for (int len = k; len <= n; len++) {

//             int result = t[len - 1];      // int result = solve(n - 1, k);

//             int j = len - 1;
//             for (int i = 0; j - i + 1 >= k; i++) {
//                 if (isPalindrome[i][j]) {
//                     result = Math.max(result, 1 + t[i]);   // result = max(result, 1 + solve(i, k));
//                 }
//             }

//             t[len] = result;              // return t[n] = result;
//         }

//         return t[n];                      // return solve(n, k);
//     }
// }