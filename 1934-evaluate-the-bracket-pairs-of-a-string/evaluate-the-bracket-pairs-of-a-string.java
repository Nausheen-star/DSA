//Approach-1
//T.C : O(n+m) //Traversing all characters in s and knowledge
//S.C : O(n+m)
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        Map<String, String> mp = new HashMap<>();

        for (List<String> vec : knowledge) {
            mp.put(vec.get(0), vec.get(1));
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < n) {
            if (Character.isAlphabetic(s.charAt(i))) {
                result.append(s.charAt(i));
            } else { //(
                i++;
                StringBuilder temp = new StringBuilder();
                while (i < n && s.charAt(i) != ')') {
                    temp.append(s.charAt(i));
                    i++;
                }
                result.append(mp.getOrDefault(temp.toString(), "?"));
            }
            i++;
        }

        return result.toString();
    }
}


// //Approach-2
// //T.C : O(n+m) //Traversing all characters in s and knowledge
// //S.C : O(n+m)
// class Solution {
//     public String evaluate(String s, List<List<String>> knowledge) {
//         int n = s.length();
//         Map<String, String> mp = new HashMap<>();

//         for (List<String> vec : knowledge) {
//             mp.put(vec.get(0), vec.get(1));
//         }

//         StringBuilder result = new StringBuilder();
//         StringBuilder temp = new StringBuilder();
//         boolean bracketOpened = false;
//         int i = 0;

//         while (i < n) {
//             char c = s.charAt(i);
//             if (c == '(') {
//                 bracketOpened = true;
//             } else if (c == ')') {
//                 result.append(mp.getOrDefault(temp.toString(), "?"));
//                 bracketOpened = false;
//                 temp = new StringBuilder();
//             } else if (bracketOpened) {
//                 temp.append(c);
//             } else {
//                 result.append(c);
//             }

//             i++;
//         }

//         return result.toString();
//     }
// }


// //Approach-3
// //T.C : O(n+m) //Traversing all characters in s and knowledge
// //S.C : O(n+m)
// class Solution {
//     public String evaluate(String s, List<List<String>> knowledge) {
//         int n = s.length();
//         Map<String, String> mp = new HashMap<>();

//         for (List<String> vec : knowledge) {
//             mp.put(vec.get(0), vec.get(1));
//         }

//         StringBuilder result = new StringBuilder();
//         int i = 0;

//         while (i < n) {
//             if (s.charAt(i) == '(') {
//                 int j = s.indexOf(")", i + 1);
//                 String temp = s.substring(i + 1, j);
//                 result.append(mp.getOrDefault(temp, "?"));
//                 i = j;
//             } else {
//                 result.append(s.charAt(i));
//             }

//             i++;
//         }
//         return result.toString();
//     }
// }