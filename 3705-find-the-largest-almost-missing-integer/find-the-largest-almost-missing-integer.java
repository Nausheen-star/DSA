class Solution {
    public int largestInteger(int[] nums, int k) {

      int n = nums.length;
      // count[x] = number of size-k subarrays
        // containing x
      int count[] = new int[51];

   // Generate every subarray of size k
   for(int start=0; start<=n-k; start++){

      boolean[] seen = new boolean[51];

      for(int i=start; i<start+k; i++){

        int x=nums[i];
        if(!seen[x]){
            seen[x] =true;
            count[x]++;
        }
      }
   }

    // We need the LARGEST almost missing number
        for (int x = 50; x >= 0; x--) {

            if (count[x] == 1) {
                return x;
            }
        }

        return -1;

    }
}