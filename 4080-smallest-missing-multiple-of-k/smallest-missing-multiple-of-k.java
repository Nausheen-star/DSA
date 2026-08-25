class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int val=k;
        while(set.contains(val)){
             val+=k;
        }
        return val;
    }
}