class Solution {
    public int[] leftRightDifference(int[] nums) {
        
        int rightSum =0;

        for(int num : nums){
            rightSum += num;
        }
        
        int[] ans = new int[nums.length];

        int leftSum =0;
        for(int i=0; i<nums.length; i++){

            rightSum -= nums[i];
            ans[i] = Math.abs(rightSum- leftSum);
            leftSum += nums[i];
        }
        return ans;
    }
}