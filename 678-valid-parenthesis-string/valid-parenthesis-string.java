//Approach-2 (Constant Space)
//T.C : O(n)
//S.C :O(1)
class Solution {
    public boolean checkValidString(String s) {
        
        int open=0;
        int close=0;
        int n = s.length();

 // Left to Right - Check Open Brackets
        for(int i=0; i<n; i++){

            if(s.charAt(i) == '(' || s.charAt(i) == '*'){
                open++;
            }else{
                open--;
            }

            if(open < 0){
                return false;
            }
        }

          // Right to Left - Check Close Brackets
          for(int i=n-1; i>=0; i--){
            if(s.charAt(i) == ')' || s.charAt(i)=='*'){
                close++;
            }else{
                close--;
            }

            if(close<0){
                return false;
            }
          } 

        return true;
    }
}


// //Approach-1 (Using two Stacks) - No DP required
// //T.C : O(n)
// //S.C : O(n)
// class Solution {
//     public boolean checkValidString(String s) {
//         Stack<Integer> openSt = new Stack<>();
//         Stack<Integer> asterisksSt = new Stack<>();

//         for (int i = 0; i < s.length(); i++) {
//             char ch = s.charAt(i);

//             if (ch == '(') {
//                 openSt.push(i);
//             } else if (ch == '*') {
//                 asterisksSt.push(i);
//             } else {
//                 if (!openSt.isEmpty()) {
//                     openSt.pop();
//                 } else if (!asterisksSt.isEmpty()) {
//                     asterisksSt.pop();
//                 } else {
//                     return false;
//                 }
//             }
//         }

//         // This post processing will be required for cases like - "*(())(*"
//         while (!openSt.isEmpty() && !asterisksSt.isEmpty()) {
//             if (openSt.peek() > asterisksSt.peek()) {
//                 return false;
//             }
//             openSt.pop();
//             asterisksSt.pop();
//         }

//         return openSt.isEmpty();
//     }
// }