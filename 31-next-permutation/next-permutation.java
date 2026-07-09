class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        // Find the first decreasing element from the right
        while (i > 0) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
            i--;
        }
        // If such an element exists
        if (i != 0) {
            int index = i;

            // Find the just larger element from the right
            for (int j = n - 1; j >= i; j--) {
                if (nums[j] > nums[i - 1]) {
                    index = j;
                    break;
                }
            }

            swap(nums, i - 1, index);
        }

        // Reverse the suffix
        reverse(nums, i, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}