//Approach-1 (Brute Force)
//T.C : O(n^3)
//S.C : O(n), for temp string of length n
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        for (int len = k; len <= n; len++) {
            String result = "";
            for (int start = 0; start + len <= n; start++) { //trying all possible substr of len
                String temp = s.substring(start, start + len); //[start ... start+len)
                int ones = 0;
                for (char ch : temp.toCharArray()) {
                    ones += (ch == '1') ? 1 : 0;
                }
                // Keep it if it's beautiful and smaller than current best.
                if (ones == k) {
                    if (result.isEmpty() || temp.compareTo(result) < 0)
                        result = temp;
                }
            }

            //if we find result of len size, then it's smallest, no need to move to len++
            if (!result.isEmpty())
                return result;
        }
        return "";
    }
}


// //Approach-2 (Sliding Window)
// //T.C : O(n^2)
// //S.C : O(1)
// class Solution {
//     public String shortestBeautifulSubstring(String s, int k) {
//         int n = s.length();
//         int i = 0;
//         int ones = 0;     // number of '1's in window [i, j]
//         String result = "";
//         for (int j = 0; j < n; j++) {
//             if (s.charAt(j) == '1')
//                 ones++;
//             //remove extra 1's, then trim leading 0's
//             while (ones > k || s.charAt(i) == '0') {
//                 if (s.charAt(i) == '1')
//                     ones--;
//                 i++;
//             }
//             if (ones == k) {
//                 String temp = s.substring(i, j + 1);
//                 if (result.isEmpty()
//                     || j - i + 1 < result.length()
//                     || (j - i + 1 == result.length() && temp.compareTo(result) < 0)) {
//                     result = temp;
//                 }
//             }
//         }
//         return result;
//     }
// }