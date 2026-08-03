class Solution {

    int[]dp;

    public int solve(int[] stone, int i, int n){

         if (i >= n)
            return 0;

        if(dp[i] !=-1){
            return dp[i];
        }

        int result = stone[i] - solve(stone, i + 1, n);

        if (i + 1 < n) {
            result  = Math.max(result,
                    stone[i] + stone[i + 1] - solve(stone, i + 2, n));
        }

        if (i + 2 < n) {
            result  = Math.max(result,
                    stone[i] + stone[i + 1] + stone[i + 2]
                            - solve(stone, i + 3, n));
        }

        return  dp[i] =result;

    }
    public String stoneGameIII(int[] stoneValue) {
        
        int n =stoneValue.length;
        dp = new int[n];

        Arrays.fill(dp,-1);


        int diff= solve(stoneValue, 0, n);

        if(diff > 0){
            return "Alice";
        }else if(diff < 0){
            return "Bob";
        }
        return "Tie";
    }

}