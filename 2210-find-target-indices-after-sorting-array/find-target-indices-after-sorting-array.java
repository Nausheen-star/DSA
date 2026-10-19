//Approach-2 (Using one Count variable)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count = 0;  // Number of elements less than target
        for (int num : nums) {
            if (num < target)
                count++;
        }

        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (num == target) {
                result.add(count);
                count++;
            }
        }
        return result;
    }
}


// //Approach-3 (Using two Count variables)
// //T.C : O(n)
// //S.C : O(1)
// class Solution {
//     public List<Integer> targetIndices(int[] nums, int target) {
//         int count1 = 0;  // Number of elements less than target
//         int count2 = 0;  // Number of elements equal to target
//         for (int num : nums) {
//             if (num < target)
//                 count1++;
//             else if (num == target)
//                 count2++;
//         }

//         List<Integer> result = new ArrayList<>();
//         for (int i = count1; i < count1 + count2; i++) {
//             result.add(i);
//         }
//         return result;
//     }
// }