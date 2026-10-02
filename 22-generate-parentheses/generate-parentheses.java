// Approach-2 (Smart Recursion)
//T.C : O(2^n)
//S.C : O(2*n) -> Removing constant -> O(n) -> recursion stack space - Max depth of recusion tree
public class Solution {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        solve(n, "", 0, 0);
        return result;
    }

    private void solve(int n, String curr, int open, int close) {
        if (curr.length() == 2 * n) {
            result.add(curr);
            return;
        }

        if (open < n) {
            curr += '(';
            solve(n, curr, open + 1, close);
            curr = curr.substring(0, curr.length() - 1);
        }
        if (close < open) {
            curr += ')';
            solve(n, curr, open, close + 1);
            curr = curr.substring(0, curr.length() - 1);
        }
    }
}



// // Approach-1 (Simple Recursion)
// //T.C : O(2n* (2^(2n)) -> Removing constant -> O(n * (2^n))
// //S.C : O(2*n) -> Removing constant -> O(n) -> recursion stack space - Max depth of recusion tree
// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> result = new ArrayList<>();
//         generate("", n, 0, result);
//         return result;
//     }

//     // Function to check if the parentheses are valid
//     private boolean isValid(String str) {
//         int sum = 0;
//         for (char ch : str) {
//             if (ch == '(')
//                 sum++;
//             else
//                 sum--;
//             if (sum < 0)
//                 return false;
//         }
//         return sum == 0;
//     }

//     // Recursive function to generate parentheses
//     private void generate(String curr, int n, int length, List<String> result) {
//         if (length == 2 * n) {
//             if (isValid(curr))
//                 result.add(curr);
//             return;
//         }

//         curr += '(';
//         generate(curr, n, length + 1, result);
//         curr = curr.substring(0, curr.length() - 1); // remove the last character

//         curr += ')';
//         generate(curr, n, length + 1, result);
//     }
// }