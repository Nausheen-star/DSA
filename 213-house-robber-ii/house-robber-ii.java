class Solution {
    

    public int solve(int i, int[] nums, int n, int dp[]){

        if(i >n) return 0;

        if(dp[i] != -1){
            return dp[i];
        }

        int take = nums[i] + solve(i+2, nums, n, dp);
        int notTake = solve(i+1, nums, n, dp);

        return dp[i] = Math.max(take, notTake);
    }
    public int rob(int[] nums) {
        
        int n = nums.length;
               if(n == 1)
            return nums[0];
        int dp1[] = new int[n];
        int dp2[] = new int[n];
             Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int rob1 = solve(0, nums, n-2, dp1);
        int rob2 = solve(1, nums, n-1, dp2);

        return Math.max(rob1, rob2);
    }
}