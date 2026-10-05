
//Approach-2 (Calculating from Depth)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0;
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
                if (s.charAt(i - 1) == '(') {
                    score += (1 << depth); // i.e. 2^depth
                }
            }
        }
        return score;
    }
}


// //Approach-1 (Using stack or vector as stack)
// //T.C : O(n)
// //S.C : O(n)
// class Solution {
//     public int scoreOfParentheses(String s) {
//         int n = s.length();
//         Deque<Integer> stack = new ArrayDeque<>();

//         int score = 0;

//         for (int i = 0; i < n; i++) {
//             char ch = s.charAt(i);
//             if (ch == '(') {
//                 stack.push(score);
//                 score = 0;
//             } else {
//                 if (s.charAt(i - 1) == '(') { // we found innermost "()" -> +1 point
//                     score = stack.peek() + 1;
//                 } else {
//                     // had content inside -> double it
//                     score = stack.peek() + (2 * score);
//                 }
//                 stack.pop();
//             }
//         }
//         return score;
//     }
// }