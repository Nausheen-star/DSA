//Using longest subarray Sum logic
//T.C : O(n)
//S.C : O(n)
class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            mp.put(sum, i);
        }
        if (sum < x)
            return -1;
        int restSum = sum - x;
        int longest = Integer.MIN_VALUE;
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (mp.containsKey(sum - restSum)) {
                longest = Math.max(longest, i - mp.get(sum - restSum));
            }
        }
        return longest == Integer.MIN_VALUE ? -1 : n - longest;
    }
}

// //Approach-2 (Using Recursion) - You Can memoize it as well but it will still give TLE
// //T.C : O(2^n) -  We take and skip each ith and jth index
// //S.C : O(1) excluding Stack space
// class Solution {
//     static int minCount ;
    
//     public int minOperations(int[] nums, int x) {
//         int n = nums.length;
//         minCount = Integer.MAX_VALUE;
//         int count = 0;
        
//         solve(nums , x, 0, 0, n-1);
        
//         if(minCount == Integer.MAX_VALUE) 
//             return -1;
        
//         return minCount;
//     }
//     public static void solve(int[] nums, int remain, int count, int i, int j){
        
//         if(remain == 0) {
//             minCount = Math.min(minCount, count);
//             return;
//         }
//         else if(remain<0 || i>j || count>=minCount ) 
//             return;
//         else{
//             solve(nums, remain-nums[i], count+1, i+1, j);
//             solve(nums, remain-nums[j], count+1, i, j-1);
//         }
//     }
// }