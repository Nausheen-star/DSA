class Solution {
    public String reverseParentheses(String s) {
        
        Stack<Integer> openBracket= new Stack<>();
        StringBuilder result = new StringBuilder();

        for(char ch : s.toCharArray()){

            if(ch == '('){
                openBracket.push(result.length());
            }else if(ch == ')'){
                int start = openBracket.pop();
                reverse(result, start, result.length()-1);
            }else{
                result.append(ch);
            }
        }

        return result.toString();

    }

    public static void reverse(StringBuilder ans, int start, int end){

        while(start<end){

            char temp = ans.charAt(start);
            ans.setCharAt(start++, ans.charAt(end));
            ans.setCharAt(end--, temp);
        }
    }
}


// //Approach-2 (Linear Approach)
// //T.C : O(n)
// //S.C : O(n)
// class Solution {
//     public String reverseParentheses(String s) {
//         int n = s.length();
//         Stack<Integer> openBracket = new Stack<>();
//         int[] door = new int[n];

//         // First pass: Pair up parentheses
//         for (int i = 0; i < n; ++i) {
//             if (s.charAt(i) == '(') {
//                 openBracket.push(i);
//             } else if (s.charAt(i) == ')') {
//                 int j = openBracket.pop();
//                 door[i] = j;
//                 door[j] = i;
//             }
//         }

//         // Second pass: Build the result string
//         StringBuilder result = new StringBuilder();
//         int direction = 1; // Left to Right
//         for (int i = 0; i < n; i += direction) {
//             if (s.charAt(i) == '(' || s.charAt(i) == ')') {
//                 i = door[i];
//                 direction = -direction;
//             } else {
//                 result.append(s.charAt(i));
//             }
//         }
//         return result.toString();
//     }
// }