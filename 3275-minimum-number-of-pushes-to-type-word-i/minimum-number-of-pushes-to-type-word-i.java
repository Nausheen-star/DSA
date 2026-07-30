
//T.C : O(n) + O(26log26)
//S.C : O(n)
public class Solution {
    public int minimumPushes(String word) {
        if (word.length() <= 8) {
            return word.length();
        }

        int count = 0;
	//You can use an array of size 10 also and use index 2 to 9
        Map<Integer, Integer> mp = new HashMap<>();

        int assign = 2;
        for (char ch : word.toCharArray()) {
            if (assign > 9) {
                assign = 2;
            }

            mp.put(assign, mp.getOrDefault(assign, 0) + 1);
            count += mp.get(assign);
            assign++;
        }

        return count;
    }
}

// //Approach-2 (Simplifying Approach-1 above)
// //T.C : O(n) + O(26log26)
// //S.C : O(1)
// public class Solution {
//     public int minimumPushes(String word) {
//         int[] mp = new int[26];

//         // Generic solution
//         for (char ch : word.toCharArray()) {
//             mp[ch - 'a'] = 1; // Mentioned in the question, all letters will be distinct
//         }

//         // Descending order of frequency
//         Integer[] mpInteger = Arrays.stream(mp).boxed().toArray(Integer[]::new);
//         Arrays.sort(mpInteger, Comparator.reverseOrder());

//         int ans = 0;
//         for (int i = 0; i < 26; i++) {
//             ans += mpInteger[i] * ((i / 8) + 1);
//         }
//         return ans;
//     }
// }