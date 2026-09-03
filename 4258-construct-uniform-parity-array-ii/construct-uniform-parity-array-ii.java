//Approach (Mathematical observation)
//T.C : O(n)
//S.C : O(1)

class Solution {
    public boolean uniformArray(int[] nums1) {
        

        int minE=Integer.MAX_VALUE;

        for(int nums : nums1){
            minE=Math.min(minE, nums);
        }

        if(minE % 2==1){
            return true; //odd-then we can convert to all even to odd
                         // all nums2 will be odd
        }

        // check if we can make all even in nums2

        for(int nums : nums1){

            if(nums % 2==1){
                return false;
            }
        }
        return true; // all nums2 will be even
    }
}