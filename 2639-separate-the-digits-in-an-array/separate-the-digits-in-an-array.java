class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for (int num : nums) {
            List<Integer> temp = new ArrayList<>();
            
            // Extract digits in reverse
            while (num > 0) {
                temp.add(num % 10);
                num /= 10;
            }
            
            // Add in correct order
            for (int i = temp.size() - 1; i >= 0; i--) {
                list.add(temp.get(i));
            }
        }
        
        // Convert to array
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}